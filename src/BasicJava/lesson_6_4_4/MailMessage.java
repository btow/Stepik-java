package BasicJava.lesson_6_4_4;

/**
 * Class emulated a mails massage
 * Created by btow on 25.11.2016.
 */
public class MailMessage extends Message {

    private final String content;

    public MailMessage(String from, String to, String content) {
        super(from, to);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
