package BasicJava.lesson_6_4_4;

import java.util.*;
import java.util.function.Consumer;
/**
 * Class emulated mails service
 * Created by btow on 25.11.2016.
 */
public class MailService<T> implements Consumer {

    private MailBox<T> mailBox;

    public MailService() {
        this.mailBox = new MailBox<T>();
    }

    public Map<String, List<T>> getMailBox() {

        return mailBox;
    }

    @Override
    public void accept(Object o) {

        Message args = (Message) o;
        String recipient = args.getTo();
        T content = null;

        if (this.mailBox.containsKey(recipient)) {

            if (o.getClass().getName().contains(".Salary")) {
                this.mailBox.get(recipient).add((T) ((Salary) o).getSalary());
            } else {
                this.mailBox.get(recipient).add((T) ((MailMessage) o).getContent());
            }

        } else {
            List<T> newMailList = new ArrayList<T>();
            if (newMailList.add(content)) {
                this.mailBox.put(recipient, newMailList);
            } else {
                throw new RuntimeException();
            }
        }

    }

}
