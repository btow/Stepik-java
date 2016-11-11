package BasicJava.lession_4_3;

/**
 * Rласс, моделирующий ненадежного работника почты, который вместо того,
 * чтобы передать почтовый объект непосредственно в сервис почты,
 * последовательно передает этот объект набору третьих лиц,
 * а затем, в конце концов, передает получившийся объект
 * непосредственно экземпляру RealMailService
 * Created by btow on 09.11.2016.
 */
public class UntrustworthyMailWorker implements MailService {

    public final MailService unrealMailServices[];
    public final RealMailService realMailService;

    /**
     * Конструктор от массива MailService ( результат вызова processMail
     * первого элемента массива передается на вход processMail второго элемента, и т. д.)
     *
     * @param unrealMailServices
     */
    public UntrustworthyMailWorker(MailService unrealMailServices[]) {

        this.unrealMailServices = unrealMailServices;
        realMailService = new RealMailService();

    }

    public RealMailService getRealMailService() {

        return realMailService;

    }

    @Override
    public Sendable processMail(Sendable mail) {

        for (MailService unrealMailService : unrealMailServices) {
            mail = unrealMailService.processMail(mail);
        }

        return realMailService.processMail(mail);
    }
}
