package BasicJava.lesson_4_3;

/**
 * Интерфейс, который задает класс, который может
 * каким-либо образом обработать почтовый объект.
 * Created by btow on 09.11.2016.
 */
public interface MailService {

    Sendable processMail(Sendable mail);

}
