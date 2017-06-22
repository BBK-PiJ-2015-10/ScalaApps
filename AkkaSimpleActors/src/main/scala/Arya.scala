import akka.actor._

class Arya extends Actor with ActorLogging {
  
  def receive = {
    
    case Greeting(m) =>     
      log.info(s"${self.path.name} got $m from ${sender.path.name}")
      sender ! s"$m to you too ${sender.path.name}"
    
    case x =>
      log.info(s"Got $x from ${sender.path.name}")
      println("Winter IS comoming, Arya got something that is not a Greeting in this remote mode!!")
      
  }
  
}