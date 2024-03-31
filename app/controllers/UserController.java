package controllers;

import actor.UserActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;

import com.fasterxml.jackson.databind.JsonNode;

import models.Employee;
import play.api.i18n.MessagesApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UserController extends Controller {

    private final ActorSystem system = ActorSystem.create("userActorSystem");
    private final ActorRef userActor = system.actorOf(Props.create(UserActor.class));

    @Inject
    FormFactory formFactory;
    @Inject
    private MessagesApi messagesApi;

    public CompletionStage<Result> getEmployee() {

        //userActor.tell("fooHello from the controller!", ActorRef.noSender());

        Future<Object> future = Patterns.ask(userActor, new UserActor.GetItemById(1), 50000);

        // Transform the Future to CompletionStage<Result>
        return FutureConverters.toJava(future).thenApply(response -> {
            if (response instanceof Employee) {

                // Process the response and return the result
                return ok(Json.toJson(response));
            } else {
                // Handle unexpected response
                return internalServerError("Unexpected response");
            }
        });
    }


    public CompletionStage<Result> createEmployee(Http.Request request) {

        Form<Employee> empForm = formFactory.form(Employee.class).bindFromRequest(request);
        if(empForm.hasErrors()){
            return CompletableFuture.completedFuture(internalServerError("Unexpected response"));
        }

        Employee emp=empForm.get();

        Future<Object> future = Patterns.ask(userActor, emp, 50000);

        // Transform the Future to CompletionStage<Result>
        return FutureConverters.toJava(future).thenApply(response -> {
            if (response instanceof Employee) {

                // Process the response and return the result
                return ok(Json.toJson(response));
            } else {
                // Handle unexpected response
                return internalServerError("Unexpected response");
            }
        });


    }


    public CompletionStage<Result> updateEmployee(Http.Request request, Integer id) {
        // Get the JSON body from the request
        JsonNode jsonData = request.body().asJson();

        UserActor.RequestMessage requestMessage = new UserActor.RequestMessage(id, jsonData);

        Future<Object> future = Patterns.ask(userActor, requestMessage, 50000);

        return FutureConverters.toJava(future).thenApply(response -> {
            if (response instanceof String) {

                // Process the response and return the result
                return ok(Json.toJson(response));
            } else {
                // Handle unexpected response
                return internalServerError("Unexpected response");
            }
        });
    }

    public CompletionStage<Result> deleteEmployee( Integer id) {

        UserActor.RequestMessage requestMessage = new UserActor.RequestMessage(id, null);

        Future<Object> future = Patterns.ask(userActor, requestMessage, 50000);

        return FutureConverters.toJava(future).thenApply(response -> {
            if (response instanceof String) {

                // Process the response and return the result
                return ok(Json.toJson(response));
            } else {
                // Handle unexpected response
                return internalServerError("Unexpected response");
            }
        });
    }


}