import akka.actor._

//import akka.actor.Actor
//import akka.actor.ActorLogging
//import akka.actor.ActorRef

class Hordor extends Actor with ActorLogging {
  
  def receive = {
    
    case Greeting(m) =>
      log.info(s"${self.path.name} got $m from ${sender.path.name}")
      log.warning(s"Simple mind tries to process $m")
      Thread.sleep(2000)
      sender ! Greeting("Hordor")
    
    case x =>
      println("Hordor got something that is not a greeting")
      
  }
  
  
}