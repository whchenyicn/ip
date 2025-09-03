package whchenyicn.command;

import java.io.IOException;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.TaskList;
import whchenyicn.task.Task;

/**
 * A command to remove task from tasklist.
 */
public class DeleteCommand extends Command {
    private String s;

    /**
     * Creates a command to delete the task from taskList.
     *
     * @param s User input String after "remove".
     */
    public DeleteCommand(String s) {
        this.s = s;
    }


    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException {
        if (tlist.size() == 0) {
            throw new WhchenyicnException("List is empty! You can't delete anything");
        }

        if (s == null || s.isEmpty()) {
            throw new WhchenyicnException("Provide the whchenyicn.task number you want to delete");
        }

        int i;
        try {
            i = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new WhchenyicnException("Index must be a number");
        }
        if (i < 1 || i > tlist.size()) {
            throw new WhchenyicnException("Invalid Index, please ensure the index is within range 1 to " + tlist.size());
        }

        Task remove = tlist.remove(i - 1);
        ui.printDelete(tlist, remove);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
