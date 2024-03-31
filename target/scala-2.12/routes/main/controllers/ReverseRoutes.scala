// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/DELL/Desktop/AKKA/play-akka-2.6-v1/conf/routes
// @DATE:Sun Mar 31 11:57:56 IST 2024

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deleteEmployee(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:8
    def getEmployee(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "all")
    }
  
    // @LINE:10
    def updateEmployee(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:9
    def createEmployee(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create")
    }
  
  }


}
