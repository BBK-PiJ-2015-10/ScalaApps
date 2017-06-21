import akka.actor.Actor
import akka.actor.ActorContext


class Listener extends Actor {
  
  def receive = {
    
    case PiApproximation(pi, duration) =>
      
      println("\n\tPi approximination: \t\t%s\n\tCalculation time: \t%s".format(pi,duration))
      
      context.system.terminate()
    
  }
  
}