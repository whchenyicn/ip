import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class whchenyicn {
    private static String hline = "__________________________________________________";
    private List<Task> tlist = new ArrayList<>(100);
    private Storage storage = new Storage();

    private void start() {
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);
        List<Task> load = storage.load();
        if (!load.isEmpty()) {
            tlist.clear();
            tlist.addAll(load);
            System.out.println(hline);
            System.out.println("Loaded " + tlist.size() + " tasks from list");
            System.out.println(hline);
        }
    }

    private void save() {
        try {
            storage.save(tlist);
        }
        catch (IOException e){
            System.out.println(hline);
            System.out.println("failed to save: " + e.getMessage());
            System.out.println(hline);
        }
    }

    private void mark(String s) throws whchenyicnExceptions{
        //mark as done

        if (s.length() <=5) {
            throw new whchenyicnExceptions("Please provide a task number");
        }

        if (tlist.size() == 0 ) {
            throw new whchenyicnExceptions("list is empty! you cant mark anything");
        }

        int i;
        try {
            i = Integer.parseInt(s.substring(5).trim());
        } catch (NumberFormatException e) {
            throw new whchenyicnExceptions("Index must be a number");
        }
        if (i < 1 || i > tlist.size()) {
            throw new whchenyicnExceptions("Invalid Index, please ensure the index is within range 1 to " + tlist.size());
        }
        tlist.get(i - 1).markDone();
        System.out.println(hline);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
        save();
    }

    private void unmark(String s) throws whchenyicnExceptions {

        if (s.length() <= 7) {
            throw new whchenyicnExceptions("Please provide a task number");
        }

        if (tlist.size() == 0 ) {
            throw new whchenyicnExceptions("list is empty! you cant unmark anything");
        }

        int i;

        try {
            i = Integer.parseInt(s.substring(7).trim());
        } catch (NumberFormatException e) {
            throw new whchenyicnExceptions("Index must be a number");
        }

        if (i < 1 || i > tlist.size()) {
            throw new whchenyicnExceptions("Invalid Index, please ensure the index is within range 1 to " + tlist.size());
        }

        tlist.get(i - 1).unmark();
        System.out.println(hline);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
        save();
    }

    private void list(){
        System.out.println(hline);
        if (tlist.size() <=0 ) {
            System.out.println("List is empty");
        }
        for (int i = 0; i < tlist.size(); i++) {
            int number = i + 1;
            System.out.println(number + ". " + tlist.get(i).toString());
        }
        System.out.println(hline);
    }

    private void todoTask(String s) throws whchenyicnExceptions{
        checkFull();

        if (s.length() <= 4) {
            throw new whchenyicnExceptions("Description cannot be empty");
        }

        String desc = s.substring(5).trim();
        if (desc.isEmpty()) {
            throw new whchenyicnExceptions("Description cannot be empty");
        }
        tlist.add(new ToDo(desc));
        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
        save();
    }

    private void deadlineTask(String s) throws whchenyicnExceptions{
        checkFull();

        if (s == null || s.length() <= 8) {
            throw new whchenyicnExceptions(("task cannot be empty, use deadline <desc> /by <when>"));
        }

        String rest = s.substring(9).trim();

        if (rest.isEmpty()) {
            throw new whchenyicnExceptions("task cannot be empty, use deadline <desc> /by <when>");
        }

        int b = rest.indexOf("/by");

        if (b < 0) {
            throw new whchenyicnExceptions("Missing '/by', use deadline <desc> /by <when>");
        }

        String desc = rest.substring(0, b).trim();
        String by = rest.substring(b + 3).trim().replaceFirst("^:", "").trim();

        if (desc.isEmpty()) {
            throw new whchenyicnExceptions("Description cannot be empty 'deadline <desc> /by <when>' ");
        }

        if (by.isEmpty()) {
            throw new whchenyicnExceptions("The deadline cannot be empty, 'deadline <desc> /by <when>'");
        }



        try {
            tlist.add(new Deadline(desc, by));
        }
        catch (IllegalArgumentException ex) {
            throw new whchenyicnExceptions("Invalid date. Use yyyy-MM-dd");
        }

        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
        save();
    }

    private void eventTask(String s) throws whchenyicnExceptions{
        checkFull();

        if (s == null || s.length() <= 5) {
            throw new whchenyicnExceptions("Cannot be empty, event <desc> /from <start> /to <end>");
        }
        String rest = s.substring(6).trim();
        int f = rest.indexOf("/from");
        int t = rest.indexOf("/to");
        if (f <= 0 || t <= f) {
            throw new whchenyicnExceptions("event <desc> /from <start> /to <end>");
        }
        String desc = rest.substring(0, f).trim();

        if (desc.isEmpty()) {
            throw new whchenyicnExceptions("description cannot be empty");
        }

        String from = rest.substring(f + 5, t).trim().replaceFirst("^:", "").trim();

        if (from.isEmpty()) {
            throw new whchenyicnExceptions("from date cannot be empty");
        }

        String to = rest.substring(t + 3).trim().replaceFirst("^:", "").trim();

        if (to.isEmpty()) {
            throw new whchenyicnExceptions("to date cannot be empty");
        }



        tlist.add(new Event(desc, from, to));
        System.out.println(hline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
        save();

    }

    private void checkFull() throws whchenyicnExceptions {
        if (tlist.size() >=100) {
            throw new whchenyicnExceptions("List is full, max 100");
        }
    }

    private void deleteTask (String s) throws whchenyicnExceptions {
        if (tlist.size() == 0) {
            throw new whchenyicnExceptions("List is empty! You can't delete anything");
        }

        if (s.length() <= 7) {
            throw new whchenyicnExceptions("Provide the task number you want to delete");
        }

        int i;

        try {
            i = Integer.parseInt(s.substring(7).trim());
        } catch (NumberFormatException e) {
            throw new whchenyicnExceptions("Index must be a number");
        }
        if (i < 1 || i > tlist.size()) {
            throw new whchenyicnExceptions("Invalid Index, please ensure the index is within range 1 to " + tlist.size());
        }

        Task remove = tlist.remove(i - 1);
        System.out.println(hline);
        System.out.println("This task has been removed");
        System.out.println("  " + remove.toString());
        System.out.println(tlist.size() + " tasks left in the list.");
        System.out.println(hline);
        save();
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
            }

            try {
                if (s.startsWith("mark")) {
                    w.mark(s);
                } else if (s.startsWith("unmark")) {
                    //mark as undone
                    w.unmark(s);
                } else if (s.equals("list")) {
                    // Listing out everything
                    w.list();
                } else if (s.startsWith("todo")) {
                    w.todoTask(s);
                } else if (s.startsWith("deadline")) {
                    w.deadlineTask(s);
                } else if (s.startsWith("event")) {
                    w.eventTask(s);
                } else if (s.startsWith("delete")) {
                    w.deleteTask(s);
                }
                else {
                    throw new whchenyicnExceptions("Invalid command, try 'todo', 'deadline', 'event', 'list', 'mark', 'unmark'");
                }
            } catch (whchenyicnExceptions ex) {
                System.out.println(hline);
                System.out.println(ex.getMessage());
                System.out.println(hline);
            }
        }
    }
}

