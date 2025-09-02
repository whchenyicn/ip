package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.task.TaskList;

/**
 * A command to terminate the bot.
 */
public class ExitCommand extends Command{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
