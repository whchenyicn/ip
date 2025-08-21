import java.util.Scanner;

public class whchenyicn {
    private static String hline = "__________________________________________________";
    private Task[] tlist = new Task[100];
    private int tcount = 0;

    private void start() {
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);
    }

    private void mark(String s) {
        //mark as done
        Integer i = Integer.parseInt(s.substring(5).trim());
        tlist[i - 1].markDone();
        System.out.println(hline);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tlist[i - 1].toString());
        System.out.println(hline);
    }

    private void unmark(String s) {
        Integer i = Integer.parseInt(s.substring(7).trim());
        tlist[i - 1].unmark();
        System.out.println(hline);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tlist[i - 1].toString());
        System.out.println(hline);
    }

    private void list() {
        System.out.println(hline);
        for (int i = 0; i < tcount; i++) {
            int number = i + 1;
            System.out.println(number + ". " + tlist[i].toString());
        }
        System.out.println(hline);
    }

    private void todoTask(String s) {
        String desc = s.substring(5).trim();
        tlist[tcount++] = new ToDo(desc);
        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist[tcount - 1].toString());
        System.out.println("Now you have " + tcount + " tasks in the list.");
        System.out.println(hline);
    }

    private void deadlineTask(String s) {
        String rest = s.substring(9).trim();
        int b = rest.indexOf("/by");
        String desc = rest.substring(0, b).trim();
        String by = rest.substring(b + 3).trim().replaceFirst("^:", "").trim();
        tlist[tcount++] = new Deadline(desc, by);
        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist[tcount - 1].toString());
        System.out.println("Now you have " + tcount + " tasks in the list.");
        System.out.println(hline);
    }

    private void eventTask(String s) {
        String rest = s.substring(6).trim();
        int f = rest.indexOf("/from");
        int t = rest.indexOf("/to");
        String desc = rest.substring(0, f).trim();
        String from = rest.substring(f + 5, t).trim().replaceFirst("^:", "").trim();
        String to = rest.substring(t + 3).trim().replaceFirst("^:", "").trim();
        tlist[tcount++] = new Event(desc, from, to);
        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist[tcount - 1].toString());
        System.out.println("Now you have " + tcount + " tasks in the list.");
        System.out.println(hline);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        whchenyicn w = new whchenyicn();
        w.start();

        while (true) {
            String s = sc.nextLine();
            //terminate with bye
            if (s.equals("bye") || s.equals("Bye")) {
                System.out.println("Bye! Hope to see you again soon!");
                System.out.println(hline);
                break;
            } else {
                if (s.startsWith("mark")) {
                    w.mark(s);
                } else {
                    //mark as undone
                    if (s.startsWith("unmark")) {
                        w.unmark(s);
                    } else {
                        // Listing out everything
                        if (s.equals("list")) {
                            w.list();
                        }
                        else if (s.startsWith("todo ")) {
                            w.todoTask(s);
                        }
                        else if (s.startsWith("deadline ")) {
                            w.deadlineTask(s);
                        }
                        else if (s.startsWith("event ")) {
                            w.eventTask(s);
                        }
                    }
                }
            }
        }
    }
}
