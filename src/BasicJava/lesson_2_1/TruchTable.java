package BasicJava.lesson_2_1;

/**
 * A program prints a truth table
 * Created by btow on 21.10.2016.
 */
public class TruchTable {

    public static void main(String[] args) {
        {
            System.out.print("   a    ");
            System.out.print("   b    ");
            System.out.print("(a | b) ");
            System.out.print("(a || b) ");
            System.out.print("(a & b) ");
            System.out.print("(a == b) ");
            System.out.print("(a ^ b) ");
            System.out.print("(a != b) ");
        }
        System.out.println();
        {
            boolean a = true;
            boolean b = false;
            System.out.print("  " + a + " ");
            System.out.print("  " + b + "  ");
            System.out.print((a | b) + "     ");
            System.out.print((a || b) + "    ");
            System.out.print((a & b) + "    ");
            System.out.print((a == b) + "    ");
            System.out.print((a ^ b) + "    ");
            System.out.print((a != b) + "    ");
        }
        System.out.println();
        {
            boolean a = false;
            boolean b = true;
            System.out.print("  " + a + " ");
            System.out.print(" " + b + "   ");
            System.out.print((a | b) + "    ");
            System.out.print((a || b) + "    ");
            System.out.print((a & b) + "    ");
            System.out.print((a == b) + "    ");
            System.out.print((a ^ b) + "    ");
            System.out.print((a != b) + "    ");
        }
        System.out.println();
        {
            boolean a = false;
            boolean b = false;
            System.out.print("  " + a + " ");
            System.out.print(" " + b + "  ");
            System.out.print((a | b) + "    ");
            System.out.print((a || b) + "    ");
            System.out.print((a & b) + "    ");
            System.out.print((a == b) + "    ");
            System.out.print((a ^ b) + "    ");
            System.out.print((a != b) + "    ");
        }
        System.out.println();
        {
            boolean a = true;
            boolean b = true;
            System.out.print("  " + a + "  ");
            System.out.print(" " + b + "   ");
            System.out.print((a | b) + "    ");
            System.out.print((a || b) + "    ");
            System.out.print((a & b) + "    ");
            System.out.print((a == b) + "    ");
            System.out.print((a ^ b) + "    ");
            System.out.print((a != b) + "    ");
        }
    }
}
