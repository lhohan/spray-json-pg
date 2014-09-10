import spray.json._

object M2eeJsonProtocol extends DefaultJsonProtocol {

  implicit object MapJsonFormat extends JsonFormat[Map[String, Any]] { // 1
    def write(m: Map[String, Any]) = {
      JsObject(m.map {                                                 // 2
        case (k, v) => v match {
          case v: String => (k, JsString(v))
          case v: Map[String, Any] => (k, write(v))                    // 3
          case _ => (k, JsString(v.toString))                          // 4
        }
      })
    }

    def read(value: JsValue) = ???                                     // 5
  }
}
