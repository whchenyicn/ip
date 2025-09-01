package whchenyicn.command;

import java.io.IOException;
import whchenyicn.task.*;
import whchenyicn.exceptions.whchenyicnExceptions;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;

public class AddDeadlineCommand extends Command{

    private String s;

    public AddDeadlineCommand(String s) {
        this.s = s;
    }

    private void checkFull(TaskList tlist) throws whchenyicnExceptions {
        if (tlist.size() >=100) {
            throw new whchenyicnExceptions("List is full, max 100");
        }
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws whchenyicnExceptions {
        checkFull(tlist);

        if (s == null || s.isEmpty()) {
            throw new whchenyicnExceptions(("whchenyicn.task cannot be empty, use deadline <desc> /by <when>"));
        }

        int b = s.indexOf("/by");

        if (b < 0) {
            throw new whchenyicnExceptions("Missing '/by', use deadline <desc> /by <when>");
        }

        String desc = s.substring(0, b).trim();
        String by = s.substring(b + 3).trim().replaceFirst("^:", "").trim();

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

        ui.printDeadlineTask(tlist);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
