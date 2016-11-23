package BasicJava.lesson_4_3;

/**
 * Инспектор, который следит за запрещенными и украденными посылками
 * и бьет тревогу в виде исключения, если была обнаружена подобная посылка.
 * Created by btow on 10.11.2016.
 */
public class Inspector implements MailService {

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    /**
     * Если он заметил запрещенную посылку с одним из запрещенных
     * содержимым ("weapons" и "banned substance"), то он бросает
     * IllegalPackageException. Если он находит посылку, состоящую
     * из камней (содержит слово "stones"), то тревога прозвучит
     * в виде StolenPackageException.
     * @param mail - проверяемое почтовое отправление;
     * @return mail - проверенное почтовое отпрпвление.
     */
    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            String contentOfPackage = ((MailPackage)mail).getContent().getContent();
            if (contentOfPackage.contains("stones")) {
                throw new StolenPackageException("Discovered the theft from the parcel!");
            } else if (contentOfPackage.contains(WEAPONS) | contentOfPackage.contains(BANNED_SUBSTANCE)) {
            throw new IllegalPackageException("In the package discovered forbidden content.");
            }
        }
        return mail;
    }
}
