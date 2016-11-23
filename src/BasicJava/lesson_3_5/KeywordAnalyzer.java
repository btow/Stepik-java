package BasicJava.lesson_3_5;

/**
 * Abstract class checks the text for any keywords
 * (in the case of spam we receive them from the designer,
 * in the case of negative text, we know beforehand the set
 * of sad faces) and in the case of finding one of the keywords
 * return the Label (SPAM and NEGATIVE_TEXT respectively),
 * and if nothing was found, return OK.
 * Created by btow on 28.10.2016.
 */
abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract String[] getKeywords();

    abstract Label getLabel();

    /**
     * The program checks the text for any keywords
     * (in the case of spam we receive them from the designer,
     * in the case of negative text, we know beforehand the set
     * of sad faces) and in the case of finding one of the keywords
     * return the Label (SPAM and NEGATIVE_TEXT respectively),
     * and if nothing was found, return OK.
     * @param text - The string to be examined.
     * @return - returns the label text SPAM or OK.
     */
    @Override
    public Label processText(String text) {

        String[] keywords = getKeywords();

        for (String keyword : keywords) {
            if (text.indexOf(keyword) > -1) {
                return getLabel();
            }
        }

        return Label.OK;
    }
}
