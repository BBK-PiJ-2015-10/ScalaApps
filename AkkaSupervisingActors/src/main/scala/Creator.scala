import akka.actor._
import Messages._

trait Creator extends Actor with ActorLogging {
  
  //bad approach, just useful for illustration
  var children: Vector[ActorRef] = Vector()
  
  //creates a child and watches over it
  def create(name: String) = {
    val child = context.actorOf(Props[Youngling],name)
    context.watch(child)
  }
  
  def receive = {
    
    case Create(name) =>
      val child = create(name)
      child ! "Welcome My Child"
      children = children :+ child //not a good approach, mutuable
    
    case YourKids =>
      if (context.children.isEmpty){
        log.info("I have no children")
      }
      else {
        context.children.foreach { c =>
          println(c)
          c ! YourKids }
      }
        
    case Terminated(m) =>
      log.info(s"${m.path.name} just died")
    
    case BecomeGrandParent =>
      scala.util.Random.shuffle(children).head ! Create("grandchild1")
    
    
    case KillEveryone =>
      log.info("Killing everyone")
      context.children.foreach(c=> c ! PoisonPill)
       
  }
    
  
}