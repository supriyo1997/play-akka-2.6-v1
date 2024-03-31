package actor;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import lombok.Data;
import models.Employee;

import javax.inject.Inject;


public class UserActor extends AbstractActor {

    @Inject
    private Employee emp;

    @Data
    public static class GetItemById {
        public final Integer itemId;


    }

    @Data
    public static class RequestMessage {
        private final Integer id;
        private final JsonNode jsonData;


    }


    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(Double.class, d -> {

                    sender().tell(d.isNaN() ? 0 : d, self());
                }).
                match(Integer.class, i -> {
                    sender().tell(i * 10, self());
                }).
                match(GetItemById.class, msg -> {
                    Employee emp=fetchItemById(msg.itemId);
                    sender().tell(emp, self());
                }).match(Employee.class,
                        msg->{
                           Employee emp=createEmployee(msg);
                            sender().tell(emp, self());
                        })
                .match(RequestMessage.class, msg->{

                            RequestMessage requestMessage = (RequestMessage) msg;
                            if(requestMessage.getJsonData()!=null) {
                                Employee emp = Employee.findByID(requestMessage.getId());
                                emp.setDept(requestMessage.getJsonData().get("dept").toString());
                                emp.setName(requestMessage.getJsonData().get("name").toString());
                                emp.setSalary(requestMessage.getJsonData().get("salary").asInt());

                                Ebean.update(emp);
                                sender().tell("Update successfully", self());
                            }
                            else {
                                Employee emp = Employee.findByID(requestMessage.getId());
                                Ebean.delete(emp);
                                sender().tell("Delete successfully", self());
                            }

                })
                .build();

    }


    private Employee createEmployee(Employee emp)
    {
        emp.save();
        return emp;
    }

    private Employee fetchItemById(Integer itemId) {

        return Ebean.find(Employee.class,itemId);
    }

}
