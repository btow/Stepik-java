package BasicJava.lession_4_3;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 *
 * Created by btow on 09.11.2016.
 */
public class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {

        Sendable sendables[] = {
                new MailPackage("Ustas Alex", AUSTIN_POWERS, new Package(WEAPONS, 1000000)),
                new MailMessage(AUSTIN_POWERS, "Ustas Alex", "Atas"),
                new MailMessage("Prof Plashner", "Ustas Alex", "Arrived at its destination"),
                new MailMessage("Prof Plashner", "Mjuller Felix", "Arrived at its destination"),
                new MailPackage("Mjuller Felix", "Prof Plashner", new Package("allowed attachment", 500)),
                new MailPackage("Ustas Alex", AUSTIN_POWERS, new Package(BANNED_SUBSTANCE, 200)),
                new MailPackage("Mjuller Felix", "Prof Plashner", new Package("allowed attachment", 100)),
        };

        MailService mailServices[] = {
                new Spy(Logger.getLogger(Spy.class.getName())),
                new Thief(300),
                new Inspector()
        };

        for (Sendable sendable : sendables) {
            UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(mailServices);
            Sendable newSendable = untrustworthyMailWorker.processMail(sendable);
            if (newSendable.equals(sendable)) {
                System.out.println("Original value: \n" +
                sendable.toString() + ";\n" +
                "New value: \n" + newSendable.toString() + ".\n" +
                "Test is in complied.");
            } else {
                System.out.println("Original value: \n" +
                        sendable.toString() + ";\n" +
                        "New value: \n" + newSendable.toString() + ".\n" +
                        "Test isn't correctly.");
            }
        }

//        configureLogging();

    }

//    private static void configureLogging() {
//        // your implementation here
//        Logger loggingClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
//        loggingClassA.setLevel(Level.ALL);
//        Logger loggingClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
//        loggingClassB.setLevel(Level.WARNING);
//        Logger orgStepicJava = Logger.getLogger("org.stepic.java");
//        orgStepicJava.setUseParentHandlers(false);
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.ALL);
//        consoleHandler.setFormatter(new XMLFormatter());
//        orgStepicJava.addHandler(consoleHandler);
//
//    }
}
