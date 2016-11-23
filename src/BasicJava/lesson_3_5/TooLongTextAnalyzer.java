package BasicJava.lesson_3_5;

/**
 * The class checks the length of the text for compliance
 * with the maximum length. In the case of excess returns
 * the label of "TOO_LONG", and otherwise "OK"
 * Created by btow on 28.10.2016.
 */
class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLength;

    TooLongTextAnalyzer (final int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
