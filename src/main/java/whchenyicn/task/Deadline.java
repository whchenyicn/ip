package whchenyicn.task;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    private LocalDate by;

    /**
     * whchenyicn.task.Deadline whchenyicn.task.Task
     * @param description description of the tasks
     * @param by when the whchenyicn.task must be done by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parseToLocalDate(by);
    }

    private LocalDate parseToLocalDate(String s) {
        s = s.trim();
        try {
            return LocalDate.parse(s);
        } catch (DateTimeParseException e) {
            System.out.println("Error Parsing: " + e.getMessage());
        }

        throw new IllegalArgumentException("Invalid Date Format");
    }

    @Override
    public String toSave() {
        return String.format("D | %d | %s | %s", getDoneFlag(), getDesc(), by);
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}