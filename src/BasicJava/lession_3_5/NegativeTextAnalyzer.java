package BasicJava.lession_3_5;

/**
 * The class checks the text for any keywords from a set of sad faces,
 * and in the case of finding one of the keywords return Label NEGATIVE_TEXT,
 * and if nothing was found, return OK.
 * Created by btow on 28.10.2016.
 */
class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] keywords;

    NegativeTextAnalyzer() {
        keywords  = new String[] {":(", "=(", ":|"};
    }

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

}
