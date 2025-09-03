package whchenyicn.ui;

import whchenyicn.task.Task;
import whchenyicn.task.TaskList;

import java.util.Scanner;

/**
 * Ui class to print messsages for usre interaction.
 */
public class Ui {
    private static String hline = "__________________________________________________";
    private Scanner sc;

    /**
     * Creates UI with a scanner for user input.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Reads next command by user.
     *
     * @return User input as string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints welcome message.
     */
    public void printWelcome() {
        System.out.println(hline);
        System.out.println("Hello! I'm whchenyicn.whchenyicn");
        System.out.println("What can I do for you?");
        System.out.println(hline);
    }

    /**
     * Prints loaded tasks and message.
     *
     * @param tlist List of tasks loaded and to be printed.
     */
    public void printLoad(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Loaded " + tlist.size() + " tasks from list");
        System.out.println(hline);
    }

    /**
     * Prints error msg.
     *
     * @param msg Error msg to be printed.
     */
    public void printError(String msg) {
        System.out.println(hline);
        System.out.println(msg);
        System.out.println(hline);
    }

    /**
     * Prints marked task.
     *
     * @param tlist List of tasks.
     * @param i Index of task to be marked.
     */
    public void printMarked(TaskList tlist, int i) {
        System.out.println(hline);
        System.out.println("Nice! I've marked this whchenyicn.task as done:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
    }

    /**
     * Prints unmarked task.
     *
     * @param tlist List of tasks.
     * @param i Index of task to be unmarked.
     */
    public void printUnmarked(TaskList tlist, int i) {
        System.out.println(hline);
        System.out.println("OK, I've marked this whchenyicn.task as not done yet:");
        System.out.println(tlist.get(i - 1).toString());
        System.out.println(hline);
    }

    /**
     * Prints the list of tasks.
     *
     * @param tlist List of tasks.
     */
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

    /**
     * Prints the todo task added to the list.
     *
     * @param tlist List of tasks.
     */
    public void printTodoTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    /**
     * Prints the deadline task added to the list.
     *
     * @param tlist List of Tasks.
     */
    public void printDeadlineTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    /**
     * Prints the Event task added to the list.
     *
     * @param tlist List of Tasks.
     */
    public void printEventTask(TaskList tlist) {
        System.out.println(hline);
        System.out.println("Got it. I've added this whchenyicn.task:");
        System.out.println("  " + tlist.get(tlist.size() - 1).toString());
        System.out.println("Now you have " + tlist.size() + " tasks in the list.");
        System.out.println(hline);
    }

    /**
     * Prints the task removed from the list.
     *
     * @param tlist List of Tasks.
     */
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

    /**
     * Prints exit message.
     */
    public void printBye() {
        System.out.println("Bye! Hope to see you again soon!");
        System.out.println(hline);
    }
}
