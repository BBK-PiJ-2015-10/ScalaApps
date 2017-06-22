import akka.actor._
import akka.actor.actorRef2Scala


object Pi extends App {
  
  //calculate(nrOfWorkers = 20, nrOfElements = 1000000, nrOfMessages = 1000000)
  
  calculate(nrOfWorkers = 20, nrOfElements = 10000, nrOfMessages = 10000)
  
  def calculate(nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int) {
    
    //create an Akka System
    val system = ActorSystem("PiSystem")
    
    // create the result listener, which will print the result and shutdown the system
    
    val listener = system.actorOf(Props[Listener], name="listener")
    
    //create the master
    
    val master = system.actorOf(Props(new Master(nrOfWorkers,nrOfMessages,nrOfElements,listener)),
        name = "master")
    
    //start the calculation
    
    master ! Calculate
    
  }
  
}