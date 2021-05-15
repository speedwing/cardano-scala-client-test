import akka.actor.ActorSystem
import iog.psg.cardano.CardanoApi.CardanoApiOps.CardanoApiRequestOps
import iog.psg.cardano.CardanoApi.ErrorMessage
import iog.psg.cardano.CardanoApiCodec.NetworkInfo
import iog.psg.cardano.{ApiRequestExecutor, CardanoApi}

import scala.concurrent.duration.DurationInt

object Main {

  def main(args: Array[String]): Unit = {

    println("a")
    implicit val requestExecutor = ApiRequestExecutor
    implicit val as = ActorSystem("MyActorSystem")

    println("b")
    val baseUri = "http://localhost:8090/v2/"
    import as.dispatcher
    println("c")

    val api = CardanoApi(baseUri)
    println("d")

    val result = api
      .networkInfo
      .executeBlocking(1.minute)

    println(result)
      .map {
        case Left(ErrorMessage(message, code)) => println(s"Message: $message, Code: $code")
        case Right(netInfo: NetworkInfo) => println(s"NetInfo: $netInfo")
      }
//    Thread.sleep(10000)
  }

}
