package BasicJava.lesson_4_3;

/**
 * При обнаружении посылки, состоящей из камней (содержит слово "stones"),
 * то тревога прозвучит в виде StolenPackageException.
 * Created by btow on 10.11.2016.
 */
public class StolenPackageException extends RuntimeException{

    public StolenPackageException (String message) {
        super(message);
    }

}
