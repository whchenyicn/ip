import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private static final DateTimeFormatter PRINT_FMT = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static final DateTimeFormatter SAVE_FMT  = DateTimeFormatter.ISO_LOCAL_DATE;

    private LocalDate by;

    /**
     * Deadline Task
     * @param description description of the tasks
     * @param by when the task must be done by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parseToLocalDate(by);
    }

    private LocalDate parseToLocalDate(String s) {
        s = s.trim();
        try {
            return LocalDate.parse(s);
        }
        catch (DateTimeParseException e) {
            System.out.println("Error Parsing: " + e.getMessage());
        }

        throw new IllegalArgumentException("Invalid Date Format");
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