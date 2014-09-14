import spray.json._

object M2eeJsonProtocol extends DefaultJsonProtocol {

  type StringToAny = Map[String, Any]

  implicit object MapJsonFormat extends JsonFormat[Map[String, Any]] { // 1
    def write(m: Map[String, Any]) = {
      JsObject(m.mapValues {                  // 2
        case v: String => JsString(v)         // 3
        case v: Int => JsNumber(v)
        case v: StringToAny => write(v)  // 4
        case v: Any => JsString(v.toString)   // 5
      })
    }

    def read(value: JsValue) = ???            // 6
  }
}
