package whchenyicn.command;

import java.io.IOException;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.TaskList;

public class UnmarkCommand extends Command {
    private String s;

    public UnmarkCommand(String s) {
        this.s = s;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException {
        if (s == null || s.isEmpty()) {
            throw new WhchenyicnException("Please provide a task number");
        }

        if (tlist.size() == 0) {
            throw new WhchenyicnException("list is empty! you cannot unmark anything");
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

        tlist.get(i - 1).unmark();
        ui.printUnmarked(tlist, i);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
