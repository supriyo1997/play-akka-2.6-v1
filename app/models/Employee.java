package models;

import io.ebean.Model;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Employee extends Model {

    @Id
    Integer id;
    @NonNull
    String name;
    String dept;

    Integer salary;

    public Employee() {

    }

    public Employee(Integer id, String name, String dept, Integer salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    private static Set<Employee> employee;

    static {
        employee=new HashSet<>();
        employee.add(new Employee(1,"supriyo","IT",20000));
        employee.add(new Employee(2,"somnath","IT",300000));

    }

    public static Set<Employee> allBooks()
    {
        return employee;
    }

    public static Employee findByID(Integer id)
    {
        for(Employee emp:employee)
        {
            if(id.equals(emp.id))
            {
                return emp;
            }
        }
        return null;
    }
}
