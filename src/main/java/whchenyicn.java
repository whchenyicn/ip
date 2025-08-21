import java.util.Scanner;

public class whchenyicn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] tlist = new Task[100];
        boolean[] doneList = new boolean[100];
        int tcount = 0;
        String hline = "__________________________________________________";
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);

        while (true) {
            String s = sc.nextLine();
            Task t = new Task(s);
            //terminate with bye
            if (s.equals("bye") || s.equals("Bye")) {
                System.out.println("Bye! Hope to see you again soon!");
                System.out.println(hline);
                break;
            } else {
                //mark as done
                if (s.startsWith("mark")) {
                    Integer i = Integer.parseInt(s.substring(5).trim());
                    tlist[i - 1].markDone();
                    System.out.println(hline);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + tlist[i - 1].getStatus() + "]" + tlist[i - 1].toString());
                    System.out.println(hline);
                } else {
                    //mark as undone
                    if (s.startsWith("unmark")) {
                        Integer i = Integer.parseInt(s.substring(7).trim());
                        tlist[i - 1].markDone();
                        System.out.println(hline);
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("[" + tlist[i - 1].getStatus() + "]" + tlist[i - 1].toString());
                        System.out.println(hline);
                    } else {
                        // Listing out everything
                        if (s.equals("list")) {
                            System.out.println(hline);
                            for (int i = 0; i < tcount; i++) {
                                int number = i + 1;
                                System.out.println(number + ". [" + tlist[i].getStatus() + "] " + tlist[i].toString());
                            }
                            System.out.println(hline);
                        } else {
                            tlist[tcount] = t;
                            tcount += 1;
                            System.out.println(hline);
                            System.out.println("added: " + s);
                            System.out.println(hline);
                        }
                    }
                }
            }
        }
    }
}
