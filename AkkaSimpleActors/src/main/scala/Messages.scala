
sealed trait Message

case class Greeting(message: String) extends Message