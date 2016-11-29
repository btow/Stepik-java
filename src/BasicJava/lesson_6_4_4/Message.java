package BasicJava.lesson_6_4_4;

/**
 * General class for all massage
 * Created by btow on 28.11.2016.
 */
public class Message {

    private final String from;
    private final String to;

    public Message(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
