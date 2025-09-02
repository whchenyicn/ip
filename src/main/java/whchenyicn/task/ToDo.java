package whchenyicn.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toSave() {
        return String.format("T | %d | %s", getDoneFlag(), getDesc());
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
