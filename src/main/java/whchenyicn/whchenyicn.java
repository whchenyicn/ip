package whchenyicn;

import whchenyicn.exceptions.whchenyicnExceptions;
import whchenyicn.task.TaskList;
import whchenyicn.command.Command;
import whchenyicn.ui.Parser;
import whchenyicn.ui.Storage;
import whchenyicn.ui.Ui;

public class whchenyicn {
    private TaskList tlist = new TaskList(100);
    private Storage storage = new Storage();
    private static Ui ui = new Ui();

    private void start() {
        ui.printWelcome();
        TaskList load = storage.load();
        if (!load.isEmpty()) {
            tlist.clear();
            tlist.addAll(load.asList());
            ui.printLoad(tlist);
        }
    }

    public void run() {
        start();
        boolean isExit = false;
        while (!isExit) {
            try {
                String s = ui.readCommand();
                Command c = Parser.parse(s);
                c.execute(tlist, ui, storage);
                isExit = c.isExit();
            }
            catch (whchenyicnExceptions e){
                ui.printError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new whchenyicn().run();

        }
    }


