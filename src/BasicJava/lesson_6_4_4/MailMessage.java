package BasicJava.lesson_6_4_4;

/**
 * Class emulated a mails massage
 * Created by btow on 25.11.2016.
 */
public class MailMessage {

    private final String from;
    private final String to;
    private final String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }
}
