package BasicJava.example;

/**
 *
 * Created by btow on 31.10.2016.
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
            stringForOut += stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName();
            System.out.println(stringForOut);
        }

        if (stackTraceElements.length < 3) {
            stringForOut = null;
        } else {
            stringForOut = stackTraceElements[3].getClassName() + "#" + stackTraceElements[3].getMethodName();
        }

        return "\n" + stringForOut;

    }

}
