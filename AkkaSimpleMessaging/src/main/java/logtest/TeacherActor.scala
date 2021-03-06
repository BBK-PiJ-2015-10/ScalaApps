package logtest

import scala.util.Random

import akka.actor.Actor
import akka.actor.ActorLogging

import protocols.StudentProtocol._
import protocols.TeacherProtocol._

class TeacherActor extends Actor with ActorLogging {
  
  val quotes = List (
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is that you think you have time",
    "You are never gonna know if you never try"
  )
  
  
  def receive = {
    
    case QuoteRequest =>
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString())
      
  }
  
  def quoteList = quotes
  
  
}