public abstract class Command {
    public abstract void execute(TaskList list, Ui ui, Storage storage) throws whchenyicnExceptions;
    public boolean isExit() {
        return false;
    }
}
