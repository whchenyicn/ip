package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.exceptions.WhchenyicnException;
import whchenyicn.task.TaskList;

/**
 * A command class with execute function.
 */
public abstract class Command {

    /**
     * Executes the command using provided fields.
     *
     * @param tlist TaskList to execute on.
     * @param ui UI to interact with user.
     * @param storage Storage to store data from interaction.
     * @throws WhchenyicnException Throws error if encounter any issue.
     */
    public abstract void execute(TaskList tlist, Ui ui, Storage storage) throws WhchenyicnException;

    /**
     * Returns whether application is terminating.
     *
     * @return True if terminating, false if not.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Checks if list is full.
     *
     * @param tlist List to be checked.
     * @throws WhchenyicnException Throws error if list is full.
     */
    public void checkFull(TaskList tlist) throws WhchenyicnException {
        if (tlist.size() >=100) {
            throw new WhchenyicnException("List is full, max 100");
        }
    }
}
