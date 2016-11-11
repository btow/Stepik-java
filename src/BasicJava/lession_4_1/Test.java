package BasicJava.lession_4_1;

/**
 *
 * Created by btow on 07.11.2016.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(getCallerClassAndMethodName());
        anotherMethod();

    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        System.out.println("stackTraceElements contains " + stackTraceElements.length + " records.");
        String stringForOut = "";
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            stringForOut = "";
            stringForOut = stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName();
            System.out.println(stringForOut);
        }
        System.out.println("\n");

        if (stackTraceElements.length <= 2) {
            stringForOut = null;
        } else {
            stringForOut = stackTraceElements[2].getClassName().toString() + "#" + stackTraceElements[2].getMethodName().toString();
        }

        return stringForOut;
    }

}
