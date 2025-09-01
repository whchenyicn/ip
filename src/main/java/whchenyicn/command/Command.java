package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.whchenyicnExceptions;
import whchenyicn.task.TaskList;

public abstract class Command {
    public abstract void execute(TaskList list, Ui ui, Storage storage) throws whchenyicnExceptions;
    public boolean isExit() {
        return false;
    }
}
