import java.io.IOException;

public class MarkCommand extends Command {
    private String s;

    public MarkCommand(String s) {
        this.s = s;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws whchenyicnExceptions {
        if (s == null || s.isEmpty()) {
            throw new whchenyicnExceptions("Please provide a task number");
        }

        if (tlist.size() == 0 ) {
            throw new whchenyicnExceptions("list is empty! you cant mark anything");
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
        tlist.get(i - 1).markDone();
        ui.printMarked(tlist, i);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
