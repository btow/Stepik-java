package BasicJava.lesson_4_3;

/**
 * Интерфейс: сущность, которую можно отправить по почте.
 * У такой сущности можно получить от кого и кому направляется письмо.
 * Created by btow on 09.11.2016.
 */
public interface Sendable {
    String getFrom();
    String getTo();
}
