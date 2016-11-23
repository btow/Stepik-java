package BasicJava.lesson_3_5;

import java.util.HashMap;
import java.util.Map;

/**
 * The use of the class AsciiCharSequence
 * Created by btow on 28.10.2016.
 */
public class Main {

    public static void main(String[] args) {

//        Тест класса AsciiCharSequence
//        byte[] inputText = "Hello world!".getBytes();
//        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(inputText);
//        System.out.println("Text of input: " + inputText);
//        System.out.println("Output of method \"toString()\": " + asciiCharSequence.toString());
//        System.out.println("Output of method \"charAt()\": " + asciiCharSequence.charAt(0));
//        System.out.println("Output of method \"length()\": " + asciiCharSequence.length());
//        System.out.println("Output of method \"subSequence()\": " + asciiCharSequence.subSequence(0, 5));

//        Тест классов KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.
        HashMap<String, Label> testSequence = new HashMap<String, Label>();
        testSequence.put("Продам такуую-то хрень", Label.SPAM);
        testSequence.put("Куплю такую-то хрень", Label.SPAM);
        testSequence.put("Это полная хрень :(", Label.NEGATIVE_TEXT);
        testSequence.put("Это наиполнпйшая хрень =(", Label.NEGATIVE_TEXT);
        testSequence.put("Это странная такая хрень :|", Label.NEGATIVE_TEXT);
        testSequence.put("Это слишком длинная хрень, которую никому не интересно читать", Label.TOO_LONG);
        testSequence.put("Это хрень будет интересна :)", Label.OK);

        String[] keywords = {"Куплю", "Продам"};

        TextAnalyzer[] analyzers = {
                new SpamAnalyzer(keywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(40)
        };

        Label result = Label.OK;

        for (Map.Entry<String, Label> testValue : testSequence.entrySet()) {
            System.out.println("The tests text:\n - " + testValue.getKey() + ".\n It's " + testValue.getValue().toString());
            result = checkLabels(analyzers, testValue.getKey());
            System.out.println("The result is - \"" + result.toString() + "\".\n The test is in complied.");
            if (testValue.getValue() != result) {
                String stopText = "The result is - \"" + result.toString() + "\". The test isn't correct.";
                System.out.println(stopText);
                System.exit(-1);
            }
        }
        String stopText = "A all tests is in complied.";
        System.out.println(stopText);

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {

        Label currentLabel = Label.OK;

        for (TextAnalyzer analyzer : analyzers) {

            currentLabel = analyzer.processText(text);

            if (!currentLabel.equals(Label.OK)) {
                break;
            }
        }

        return currentLabel;

    }
}
