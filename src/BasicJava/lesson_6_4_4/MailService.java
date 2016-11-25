package BasicJava.lesson_6_4_4;

/**
 * Class emulated mails service
 * Created by btow on 25.11.2016.
 */
public class MailService<T> {

    private final T mailBox;

    public MailService(T mailBox) {
        this.mailBox = mailBox;
    }

    public T getMailBox() {
        return mailBox;
    }
}
