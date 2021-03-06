import akka.actor._
import akka.util.Timeout
import akka.actor.Actor

object SimpleActor extends App {
  
  val system = ActorSystem("winterfell")
  
  val hordor = system.actorOf(Props[Hordor], "Hordor")
  
  val arya = system.actorOf(Props[Arya],"Arya")
  
  val tyrion = system.actorOf(Props[GrumpyImp],"Tyrion")
  
  //the system sends a message to hordor
  hordor ! "Hello"
  
  hordor ! "Do you say anything besides hordor?"
  
  //arya sends a message to hordor
  hordor.tell(Greeting("Good morning!!"), arya)
  
  arya.tell(Greeting("Do not expect anything from that one"),tyrion)
  
  tyrion.tell(Greeting("Hordor"),hordor)
  
  hordor ! PoisonPill
  
  system.terminate()
  
}