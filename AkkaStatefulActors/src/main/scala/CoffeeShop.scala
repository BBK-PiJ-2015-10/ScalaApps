import akka.actor._
import CoffeeProtocol._
import CoffeeProtocol.Uninitialised

class CoffeeShop extends FSM[State,Data] {
  
  startWith(Closed,Uninitialised)
  
  when(Closed) {
    
    case Event(Open, _) =>
      //Creates Barrister actors
      context.actorOf(Props[Barrister], "john")
      context.actorOf(Props[Barrister], "maria")
      context.actorOf(Props[Barrister], "james")
      context.actorOf(Props[Barrister], "the-one-with-the-hipster-beard")
      //transitions to Opened and OrderQueue
      goto (Opened) using OrderQueue(Map.empty)

    case Event(Barristas, _) =>
      
      println(context.children)
      sender ! context.children
      stay
      
  }
  
  when (Opened) {
    
    case Event(CustomerOrder(name), o@OrderQueue(q)) =>
      val barrista = getNextAvailableBarrista
      //sends order to barrista and identifies itself
      barrista.tell(CustomerOrder(name),self)
      //Tells the sender who will be making the coffee today
      sender.tell(Info("I will be making your coffee today"),barrista)
      //Updates queue, by adding a barrista to the queue
      stay using o.copy(queue = q + (barrista -> name))
    
    //Coffee is sent from Barrista, OrderQueue was injected when moved to Open
    case Event(Coffee(name), o@OrderQueue(q)) =>
      log.info(s"Got coffee back from ${sender.path.name}")
      //Removes sender from the queue
      val newQueue = q - sender
      //updates the queue with a new instance
      stay using o.copy(queue = newQueue)
    
    case Event(Barristas, _) =>
      sender ! context.children
      stay
    
    case Event(Queue, o@OrderQueue(q)) =>
      sender ! q
      stay
  }
  
  
  onTransition {
    
    //when it moves from anything to Opened
    case _ -> Opened =>
      log.info("Transitioning to Active")
    
    //when it moves from anything to Closed  
    case _ -> Closed =>
      log.info("Transitioning to IDLE")
      context.children.foreach {
        _ ! PoisonPill
      }
    
  }
  
  def getNextAvailableBarrista: ActorRef = {
    //using a different algorithm based on the state of Data
    stateData match {
      case OrderQueue(m) =>
        //Get children of context, filters the one not in the queue, makes a list, and provides head
        context.children.filterNot(c=>m.keys.toList.contains(c)).head
      case Uninitialised =>
        //Randomly shuffles the children of context and provides the head
        scala.util.Random.shuffle(context.children).head
    }
  }
  
  
  initialize()
  
}