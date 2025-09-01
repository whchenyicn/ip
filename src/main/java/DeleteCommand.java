import java.io.IOException;

public class DeleteCommand extends Command{
    private String s;
    public DeleteCommand(String s) {
        this.s = s;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) throws whchenyicnExceptions {
        if (tlist.size() == 0) {
            throw new whchenyicnExceptions("List is empty! You can't delete anything");
        }

        if (s == null || s.isEmpty()) {
            throw new whchenyicnExceptions("Provide the task number you want to delete");
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

        Task remove = tlist.remove(i - 1);
        ui.printDelete(tlist, remove);
        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }
}
