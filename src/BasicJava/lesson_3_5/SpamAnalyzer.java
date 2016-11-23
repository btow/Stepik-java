package BasicJava.lesson_3_5;

/**
 * The class checks the text for any keywords from a predefined set,
 * and in the case of finding one of the keywords return Label SPAM,
 * and if nothing was found, return OK.
 * Created by btow on 28.10.2016.
 */
class SpamAnalyzer extends KeywordAnalyzer {

    private final String[] keywords;

    SpamAnalyzer (String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return Label.SPAM;
    }

}
