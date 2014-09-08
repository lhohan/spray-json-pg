package webclient

import spray.json._

object M2eeJsonProtocol extends DefaultJsonProtocol {

  implicit object MapJsonFormat extends RootJsonFormat[Map[String, Any]] {
    def write(m: Map[String, Any]) = {
      JsObject(m.map {
        case (k, v) => v match {
          case v: String => (k, JsString(v))
          case v: Map[String, Any] => (k, write(v))
          case _ => (k, JsString(v.toString))
        }
      })
    }

    def read(value: JsValue) = ???
  }
}
