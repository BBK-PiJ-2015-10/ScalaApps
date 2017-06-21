import akka.actor._
import CoffeeProtocol._

class Barrister extends Actor with ActorLogging {
  
  def receive = {
    
    case CustomerOrder(c) => 
      
      var message = s"${self.path.name} is making coffeee $c"
      
      if ( self.path.name == "the-one-with-the-hipster-beard")
        message += " with llama milk"
        
      log.info(message)
      Thread.sleep(2000)
      sender ! Coffee(c)
        
    
  }
  
}