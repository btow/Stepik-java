package BasicJava.lession_4_3;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Шпион, который логгирует о всей почтовой переписке,
 * которая проходит через его руки. Объект конструируется от экземпляра Logger,
 * с помощью которого шпион будет сообщать о всех действиях.
 * Created by btow on 09.11.2016.
 */
public class Spy implements MailService {

    private final Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy (Logger logger) {

        this.logger = logger;
        this.logger.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new SimpleFormatter());
        this.logger.addHandler(consoleHandler);
    }

    /**
     * Он следит только за объектами класса MailMessage и пишет в логгер
     * следующие сообщения (в выражениях нужно заменить части в фигурных
     * скобках на значения полей почты):
     * 2.1) Если в качестве отправителя или получателя указан "Austin Powers",
     *      то нужно написать в лог сообщение с уровнем WARN:
     *      Detected target mail correspondence: from {from} to {to} "{message}"
     * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO:
     *      Usual correspondence: from {from} to {to}
     * @param mail - пересылаемое отправление.
     * @return mail - пересылаемое отправление после обработки.
     */
    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailMessage) {
            if (mail.getFrom().equals(AUSTIN_POWERS) | mail.getTo().equals(AUSTIN_POWERS)) {
                logger.log(Level.WARNING,"Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[] {mail.getFrom(),
                                      mail.getTo(),
                                      ((MailMessage) mail).getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[] {mail.getFrom(),
                                      mail.getTo()});
            }
        }
        return mail;
    }
}
