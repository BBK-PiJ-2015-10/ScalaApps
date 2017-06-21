import akka.actor.ActorRef

object CoffeeProtocol {
 
  sealed trait Order
  case class CustomerOrder(name: String) extends Order
  case class Coffee(name: String) extends Order
  case object Barristas extends Order
  case object Open extends Order
  case object Queue extends Order
  case class Info(msg: String) extends Order
  
  sealed trait State
  case object Closed extends State
  case object Opened extends State
  
  sealed trait Data
  case object Uninitialised extends Data
  final case class OrderQueue (queue: Map[ActorRef,String]) extends Data
  
  
  
}