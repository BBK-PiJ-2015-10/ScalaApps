import akka.actor._

class GrumpyImp extends Actor with ActorLogging {
  
  def receive = {
    
    case Greeting(m) =>
      log.info(s"${self.path.name} got $m FROM ${sender.path.name}")
      sender ! Greeting("Go Away Mate")
    
    case x =>
      sender ! "Wink"
      log.info(s"Do not speak to me !!! Northern Remote Peasant !!! AKKA ${sender.path.name}")
    
  }
  
  
}