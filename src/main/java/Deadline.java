public class Deadline extends Task {

    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    @Override
    public String toSave() {
        return String.format("D | %d | %s | %s", isDone(), getDesc(), by);
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}