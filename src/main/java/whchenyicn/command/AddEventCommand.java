package whchenyicn.command;

import java.io.IOException;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.TaskList;
import whchenyicn.task.Event;

public class AddEventCommand extends Command {
    private String s;

    public AddEventCommand(String s) {
        this.s = s;
    }

    private void checkFull(TaskList tlist) throws WhchenyicnException {
        if (tlist.size() >= 100) {
            throw new WhchenyicnException("List is full, max 100");
        }
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException {
        checkFull(tlist);

        if (s == null || s.isEmpty()) {
            throw new WhchenyicnException("Cannot be empty, event <desc> /from <start> /to <end>");
        }

        int f = s.indexOf("/from");
        int t = s.indexOf("/to");
        if (f <= 0 || t <= f) {
            throw new WhchenyicnException("event <desc> /from <start> /to <end>");
        }
        String desc = s.substring(0, f).trim();

        if (desc.isEmpty()) {
            throw new WhchenyicnException("description cannot be empty");
        }

        String from = s.substring(f + 5, t).trim().replaceFirst("^:", "").trim();

        if (from.isEmpty()) {
            throw new WhchenyicnException("from date cannot be empty");
        }

        String to = s.substring(t + 3).trim().replaceFirst("^:", "").trim();

        if (to.isEmpty()) {
            throw new WhchenyicnException("to date cannot be empty");
        }

        tlist.add(new Event(desc, from, to));
        ui.printEventTask(tlist);

        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
