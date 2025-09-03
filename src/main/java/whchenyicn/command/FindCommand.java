package whchenyicn.command;

import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;
import whchenyicn.task.Task;
import whchenyicn.task.TaskList;

/**
 * A command that finds the task with the given keyword.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Creates a command to find tasks in tasklist containing the keyword.
     *
     * @param keyword Keyword to be searched for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tlist, Ui ui, Storage storage) {
        String k = keyword.trim().toLowerCase();
        TaskList matchList = new TaskList();
        for (int i = 0; i < tlist.size(); i++) {
            Task t = tlist.get(i);
            if (t.toString().toLowerCase().contains(k)) {
                matchList.add(t);
            }
        }
        ui.printFind(matchList);
    }

}
