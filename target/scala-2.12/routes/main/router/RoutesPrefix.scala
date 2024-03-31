// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/DELL/Desktop/AKKA/play-akka-2.6-v1/conf/routes
// @DATE:Sun Mar 31 11:57:56 IST 2024


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
