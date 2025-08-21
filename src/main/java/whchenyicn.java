import java.util.Scanner;

public class whchenyicn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hline = "__________________________________________________";
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);

        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye") || s.equals("Bye")){
                System.out.println("Bye! Hope to see you again soon!");
                System.out.println(hline);
                break;
            }
            System.out.println(hline);
            System.out.println("    " + s);
            System.out.println(hline);
        }
    }
}
