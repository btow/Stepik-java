package BasicJava.lesson_4_3;

/**
 * Вор, который ворует самые ценные посылки и игнорирует все остальное.
 * Вор принимает в конструкторе переменную int – минимальную стоимость
 * посылки, которую он будет воровать.
 * Created by btow on 09.11.2016.
 */
public class Thief implements MailService {

    final int minCostPackage;
    int stolenValue;

    public Thief(final int minCostPackage) {

        this.minCostPackage = minCostPackage;
        this.stolenValue = 0;

    }

    /**
     * Воровство происходит следующим образом: вместо посылки,
     * которая пришла вору, он отдает новую, такую же, только
     * с нулевой ценностью и содержимым посылки "stones instead of {content}".
     *
     * @param mail - пересылаемая посылка
     * @return mail - подменённая посылка.
     */
    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            int priceOfPackage = ((MailPackage) mail).getContent().getPrice();
            if (priceOfPackage >= minCostPackage) {
                stolenValue += priceOfPackage;
                return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " +
                        ((MailPackage) mail).getContent().getContent(), 0));
            }
        }

        return mail;
    }

    int getStolenValue() {
        return stolenValue;
    }
}
