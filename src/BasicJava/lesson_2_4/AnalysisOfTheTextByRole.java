package BasicJava.lesson_2_4;

import java.util.HashMap;

/**
 * The program parses the script text for the specified roles.
 * Created by btow on 26.10.2016.
 */
public class AnalysisOfTheTextByRole {

    private static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder result = new StringBuilder("");
        StringBuilder[] results = new StringBuilder[roles.length];
        int linesNumber = 1, positionOfColon, rolesIndex;
        HashMap hashMapByRoles = new HashMap();

        for (int rI = 0; rI < roles.length; rI++) {
            results[rI] = new StringBuilder(roles[rI].subSequence(0, roles[rI].length()));
            results[rI] = results[rI].append(":\n");
            hashMapByRoles.put(roles[rI], rI);
        }

        for (String textLine : textLines) {

            if (textLine.isEmpty()) {continue;}

            positionOfColon = textLine.indexOf(": ");
            String          roleInLine = textLine.substring(0, positionOfColon);
            StringBuilder   rolesTextInLine = new StringBuilder (textLine.substring(positionOfColon + 2));
            rolesIndex = (int)hashMapByRoles.get(roleInLine);
            results[rolesIndex] = results[rolesIndex].append(linesNumber +") ").append(rolesTextInLine).append("\n");
            linesNumber++;

        }

        for (StringBuilder rolesString : results) {

            result = result.append(rolesString).append("\n");

        }

        return result.toString();

    }

    public static void main(String[] args) {

        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        String sampleOutput =
                "Городничий:\n" +
                "1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
                "4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
                "\n" +
                "Аммос Федорович:\n" +
                "2) Как ревизор?\n" +
                "5) Вот те на!\n" +
                "\n" +
                "Артемий Филиппович:\n" +
                "3) Как ревизор?\n" +
                "6) Вот не было заботы, так подай!\n" +
                "\n" +
                "Лука Лукич:\n" +
                "7) Господи боже! еще и с секретным предписаньем!\n" +
                "\n";

        String result = printTextPerRole(roles, textLines);

        if (!result.equals(sampleOutput)) {

            String stopText = "The test isn't complied";
            System.out.println(stopText);
            System.exit(-1);

        } else {

            String stopText = "The test is in complied";
            System.out.println(stopText);

        }
    }

}
