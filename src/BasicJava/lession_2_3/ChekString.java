package BasicJava.lession_2_3;

/**
 * The program performs validation of a string for its palindrome degree.
 * Created by btow on 25.10.2016.
 */
public class ChekString {

    public static void main(String[] args) {

        String[] testsValues = {
                "Malaysia",
                "Shahs",
                "Sagas",
                "Malayalam",
                "To be, or not to be",
                "Madam I'm Adam",
                "Able was I ere I saw Elba",
                "A man, a plan a canal-Panama",
                "Live not on evil",
                "Was it a car or a cat I saw?",
                "Pull up if I pull up",
                "Some men interpret nine memos",
                "Not New York, Roy went on",
                "Niagara o roar again",
                "Yawn a more Roman way"
        };

        boolean[] testsResults = {
                false,
                true,
                true,
                true,
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true
        };

        int testsNumber = 1;

        for (String testsValue : testsValues) {

            boolean testsResult = isPalindrome(testsValue);

            if (testsResult != testsResults[testsNumber - 1]) {

                String stopText = "The test number " + testsNumber + " isn't correct.";
                System.out.println(stopText);
                System.exit(-1);

            } else {

                String stopText = "The test number " + testsNumber + " is complied!";
                System.out.println(stopText);

            }

            testsNumber++;

        }

    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {

        StringBuilder reverseText = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]" ,"").toLowerCase()).reverse();

        return reverseText.toString().equals(text.replaceAll("[^a-zA-Z0-9]" ,"").toLowerCase()); // your implementation here
    }

}
