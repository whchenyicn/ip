import java.io.IOException;

public class AddToDoCommand extends Command {
    private String s;

    public AddToDoCommand(String s) {
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

        tlist.add(new ToDo(s));
        ui.printTodoTask(tlist);

        try {
            storage.save(tlist);
        } catch (IOException e) {
            ui.printError("Failed to save: " + e.getMessage());
        }
    }

}