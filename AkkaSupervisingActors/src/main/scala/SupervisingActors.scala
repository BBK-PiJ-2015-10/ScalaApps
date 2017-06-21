import akka.actor._
import Messages._

object SupervisingActors extends App {
  
  val system = ActorSystem("familyTree")
  
  val papa = system.actorOf(Props[Parent],"daddy")
  
  papa ! Create("firstborn")
  
  papa ! Create("secondborn")
  
  papa ! Create("thirdborn")
  
  papa ! YourKids
  
  papa ! BecomeGrandParent
  
  papa ! YourKids
  
  papa ! KillEveryone
  
  papa ! YourKids
  
  system.terminate()
  
  
  
}