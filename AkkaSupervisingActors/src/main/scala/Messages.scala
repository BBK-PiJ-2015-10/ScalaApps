

object Messages {
  
  sealed trait Message
  
  case class Create (name: String) extends Message
  
  case object YourKids extends Message
  
  case object BecomeGrandParent extends Message
  
  case object KillEveryone extends Message
  
}