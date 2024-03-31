// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/DELL/Desktop/AKKA/play-akka-2.6-v1/conf/routes
// @DATE:Sun Mar 31 11:57:56 IST 2024

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  UserController_2: controllers.UserController,
  // @LINE:14
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    UserController_2: controllers.UserController,
    // @LINE:14
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, UserController_2, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, UserController_2, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """controllers.UserController.getEmployee()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.UserController.createEmployee(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/""" + "$" + """id<[^/]+>""", """controllers.UserController.updateEmployee(request:Request, id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """id<[^/]+>""", """controllers.UserController.deleteEmployee(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_getEmployee1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_UserController_getEmployee1_invoker = createInvoker(
    UserController_2.getEmployee(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getEmployee",
      Nil,
      "GET",
      this.prefix + """all""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_createEmployee2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_UserController_createEmployee2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_2.createEmployee(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "createEmployee",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """create""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_updateEmployee3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateEmployee3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_2.updateEmployee(fakeValue[play.mvc.Http.Request], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateEmployee",
      Seq(classOf[play.mvc.Http.Request], classOf[Integer]),
      "PUT",
      this.prefix + """update/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_deleteEmployee4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteEmployee4_invoker = createInvoker(
    UserController_2.deleteEmployee(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteEmployee",
      Seq(classOf[Integer]),
      "DELETE",
      this.prefix + """delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:8
    case controllers_UserController_getEmployee1_route(params@_) =>
      call { 
        controllers_UserController_getEmployee1_invoker.call(UserController_2.getEmployee())
      }
  
    // @LINE:9
    case controllers_UserController_createEmployee2_route(params@_) =>
      call { 
        controllers_UserController_createEmployee2_invoker.call(
          req => UserController_2.createEmployee(req))
      }
  
    // @LINE:10
    case controllers_UserController_updateEmployee3_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_UserController_updateEmployee3_invoker.call(
          req => UserController_2.updateEmployee(req, id))
      }
  
    // @LINE:11
    case controllers_UserController_deleteEmployee4_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_UserController_deleteEmployee4_invoker.call(UserController_2.deleteEmployee(id))
      }
  
    // @LINE:14
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
