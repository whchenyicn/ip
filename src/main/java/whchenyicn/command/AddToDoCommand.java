package whchenyicn.command;

import java.io.IOException;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.whchenyicnExceptions;
import whchenyicn.task.TaskList;
import whchenyicn.task.ToDo;

/**
 * A command to add ToDo task to tasklist.
 */
public class AddToDoCommand extends Command {
    private String s;

    /**
     * Creates a command to add event task.
     *
     * @param s User input text after "todo".
     */
    public AddToDoCommand(String s) {
        this.s = s;
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