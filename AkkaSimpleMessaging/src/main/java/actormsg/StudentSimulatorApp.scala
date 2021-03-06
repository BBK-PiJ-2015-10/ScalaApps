package actormsg

import akka.actor.ActorSystem
import akka.actor.Props
import logtest.TeacherActor
import protocols.StudentProtocol._
import protocols.TeacherProtocol._

object StudentSimulatorApp extends App {

  val system = ActorSystem("UniversityMessageSystem")
  
  val teacher = system.actorOf(Props[TeacherActor])
  
  teacher ! QuoteRequest
  
  Thread.sleep(2000)
  
  system.terminate()
  
  
  
}