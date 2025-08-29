public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toSave() {
        return String.format("T | %d | %s", isDone(), getDesc());
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
