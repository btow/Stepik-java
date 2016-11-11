package BasicJava.lession_4_3;

/**
 * Класс, в котором скрыта логика настоящей почты
 * Created by btow on 09.11.2016.
 */
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }

}
