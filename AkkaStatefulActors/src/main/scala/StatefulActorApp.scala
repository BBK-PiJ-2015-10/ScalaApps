import akka.actor._
import CoffeeProtocol._

object StatefulActorApp extends App {
  
  val system = ActorSystem("hipstercoffee")
  val shop = system.actorOf(Props[CoffeeShop], "hipstercoffeeshop")
  shop ! Open
  shop ! CustomerOrder("Capuccino")
  shop ! Queue
  Thread.sleep(5)
  shop ! Queue
  Thread.sleep(2000)
  system.terminate()
  
}