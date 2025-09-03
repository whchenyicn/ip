package whchenyicn.ui;

import whchenyicn.command.*;
import whchenyicn.exceptions.whchenyicnExceptions;

public class Parser {
    public static boolean isExit(String input) {
        return input.trim().equalsIgnoreCase("bye");
    }

    public static String getCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        return input.trim().split("\\s+", 2)[0];
    }

    public static String getArg(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length > 1) {
            return parts[1];
        }
        return "";
    }

    public static Command parse(String input) throws whchenyicnExceptions {
        String command = getCommand(input);
        String arg = getArg(input);

        switch (command.toLowerCase()) {

        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(arg);
        case "unmark":
            return new UnmarkCommand(arg);
        case "delete":
            return new DeleteCommand(arg);
        case "todo":
            return new AddToDoCommand(arg);
        case "deadline":
            return new AddDeadlineCommand(arg);
        case "event":
            return new AddEventCommand(arg);
        case "find":
            return new FindCommand(arg);
        default:
            throw new whchenyicnExceptions("Invalid whchenyicn.command: " + command);
        }
    }
}
