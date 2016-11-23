package BasicJava.lesson_4_3;

/**
 * Исключение в случае обнаружения запрещенной посылки с одним
 * из запрещенных содержимым ("weapons" и "banned substance")
 * Created by btow on 10.11.2016.
 */
public class IllegalPackageException extends RuntimeException {

    public IllegalPackageException (String message) {
        super(message);
    }

}
