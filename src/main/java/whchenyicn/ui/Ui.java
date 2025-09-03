package whchenyicn.ui;

import whchenyicn.task.Task;
import whchenyicn.task.TaskList;

import java.util.Scanner;

public class Ui {
    private static String hline = "__________________________________________________";
    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void printWelcome() {
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn.whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);
    }

    public void printLoad(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Loaded " + tlist.size() + " tasks from list");
        System.out.println(hline);
    }

    public void printError(String msg) {
        System.out.println(hline);
        System.out.println(msg);
        System.out.println(hline);
    }

    public void printMarked(TaskList tlist, int i) {
        System.out.println(hline);
        System.out.println("Nice! I've marked this whchenyicn.task as done:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
    }

    public void printUnmarked(TaskList tlist, int i) {
        System.out.println(hline);
        System.out.println("OK, I've marked this whchenyicn.task as not done yet:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
    }

    public void printList(TaskList tlist) {
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

    public void printTodoTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    public void printDeadlineTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    public void printEventTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    public void printDelete(TaskList tlist, Task remove) {
        System.out.println(hline);
        System.out.println("This whchenyicn.task has been removed");
        System.out.println("  " + remove.toString());
        System.out.println(tlist.size() + " tasks left in the list.");
        System.out.println(hline);
    }

    /**
     * Prints list of tasks that matches find keyword.
     *
     * @param matchList List of tasks containing keyword.
     */
    public void printFind(TaskList matchList) {
        System.out.println(hline);
        if (matchList.isEmpty()) {
            System.out.println("No matching tasks found.");
        }
        else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchList.size(); i++) {
                System.out.printf("%d.%s%n", i + 1, matchList.get(i).toString());
            }
        }
        System.out.println(hline);
    }

    public void printBye() {
        System.out.println("Bye! Hope to see you again soon!");
        System.out.println(hline);
    }
}
