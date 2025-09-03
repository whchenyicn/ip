package whchenyicn.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A Deadline Task with a date representing deadline.
 */
public class Deadline extends Task {
    private static final DateTimeFormatter PRINT_FMT = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static final DateTimeFormatter SAVE_FMT  = DateTimeFormatter.ISO_LOCAL_DATE;

    private LocalDate by;

    /**
     * Creates a Deadline Task.
     *
     * @param description Description of the tasks.
     * @param by When the task must be done by.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parseToLocalDate(by);
    }

    /**
     * Parses String into LocalDate.
     *
     * @param s Input string.
     * @return Parsed LocalDate.
     */
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