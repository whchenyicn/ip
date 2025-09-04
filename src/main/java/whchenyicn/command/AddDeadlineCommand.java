package whchenyicn.command;

import java.io.IOException;

import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.Deadline;
import whchenyicn.task.TaskList;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;

/**
 * A command to add a deadline task to tasklist.
 */
public class AddDeadlineCommand extends Command {

    private String s;

    /**
     * Creates a Command to Add Deadline Task.
     *
     * @param s User input text after "deadline".
     */
    public AddDeadlineCommand(String s) {
        this.s = s;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException {
        checkFull(tlist);

        if (s == null || s.isEmpty()) {
            throw new WhchenyicnException("whchenyicn.task cannot be empty, use deadline <desc> /by <when>");
        }

        int b = s.indexOf("/by");

        if (b < 0) {
            throw new WhchenyicnException("Missing '/by', use deadline <desc> /by <when>");
        }

        String desc = s.substring(0, b).trim();
        String by = s.substring(b + 3).trim().replaceFirst("^:", "").trim();

        if (desc.isEmpty()) {
            throw new WhchenyicnException("Description cannot be empty 'deadline <desc> /by <when>' ");
        }

        if (by.isEmpty()) {
            throw new WhchenyicnException("The deadline cannot be empty, 'deadline <desc> /by <when>'");
        }

        try {
            tlist.add(new Deadline(desc, by));
        } catch (IllegalArgumentException ex) {
            throw new WhchenyicnException("Invalid date. Use yyyy-MM-dd");
        }

        ui.printDeadlineTask(tlist);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
