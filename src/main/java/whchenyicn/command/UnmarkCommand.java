package whchenyicn.command;

import java.io.IOException;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.whchenyicnExceptions;
import whchenyicn.task.TaskList;

/**
 * A command to mark a task in the list as not done.
 */
public class UnmarkCommand extends Command {
    private String s;

    /**
     * Creates command to mark task as not done.
     *
     * @param s User input string after "unmark".
     */
    public UnmarkCommand(String s) {
        this.s = s;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws whchenyicnExceptions {
        if (s == null || s.isEmpty()) {
            throw new whchenyicnExceptions("Please provide a whchenyicn.task number");
        }

        if (tlist.size() == 0 ) {
            throw new whchenyicnExceptions("list is empty! you cant unmark anything");
        }

        int i;

        try {
            i = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new whchenyicnExceptions("Index must be a number");
        }

        if (i < 1 || i > tlist.size()) {
            throw new whchenyicnExceptions("Invalid Index, please ensure the index is within range 1 to " + tlist.size());
        }

        tlist.get(i - 1).unmark();
        ui.printUnmarked(tlist, i);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
