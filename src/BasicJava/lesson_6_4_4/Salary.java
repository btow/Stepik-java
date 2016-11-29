package BasicJava.lesson_6_4_4;

/**
 * Class emulated processes with salary
 * Created by btow on 26.11.2016.
 */
public class Salary extends Message {

    private final Integer salary;

    public Salary(String from, String to, Integer salary) {
        super(from, to);
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }
}
