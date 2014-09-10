import org.scalatest.FunSuite
import spray.json._
import M2eeJsonProtocol._

class JsonTest extends FunSuite {

  test("Map to JSON conversion") {
    val testMap = Map(
      "param1" -> "value1",
      "param2" -> 2,
      "param3" -> Map(
         "param4" -> "value4",
         "param5" -> Map(
            "param6" -> "value6",
            "param7" -> "value7"
         )
      )
    )

    assertResult( """{"param1":"value1","param2":2,"param3":{"param4":"value4","param5":{"param6":"value6","param7":"value7"}}}""") {  // 1
      testMap.toJson.toString()  // 2
    }
  }
}
