package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.task.TaskList;

/**
 * A command to list all tasks in TaskList.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks);
    }
}
