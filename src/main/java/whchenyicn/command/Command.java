package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException;
    public boolean isExit() {
        return false;
    }
}
