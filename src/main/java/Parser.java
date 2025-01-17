import userCommands.*;
import utilities.Command;

public class Parser {
    private Parser() {
        // to prevent instantiation
    }

    public static UserCommand parseInput(String userInput) {
        userInput = userInput.toLowerCase();
        String firstWord = userInput.split(" ")[0];

        switch (firstWord) {
        case "list":
            return new UserCommandList();
        case "todo":
            try {
                String todoTaskName = userInput.split(" ", 2)[1];
                return new UserCommandTodo(todoTaskName);
            } catch (ArrayIndexOutOfBoundsException e) {
                String errorMessage = "The description of todo tasks cannot be empty!";
                return new UserCommandError(errorMessage);
            }
        case "deadline":
            String[] splitSlashBy = userInput.split(" /by ");
            String deadlineTaskName = splitSlashBy[0].split(" ", 2)[1];
            String deadlineString = splitSlashBy[1];
            return new UserCommandDeadline(deadlineTaskName, deadlineString);
        case "event":
            String[] splitSlashFrom = userInput.split(" /from ");
            String eventTaskName = splitSlashFrom[0].split(" ", 2)[1];
            String[] splitSlashTo = splitSlashFrom[1].split(" /to ");
            String eventFrom = splitSlashTo[0];
            String eventTo = splitSlashTo[1];
            return new UserCommandEvent(eventTaskName, eventFrom, eventTo);
        case "mark":
            int markNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
            return new UserCommandMarkUnmark(Command.MARK, markNumber);
        case "unmark":
            int unmarkNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
            return new UserCommandMarkUnmark(Command.UNMARK, unmarkNumber);
        default:
            return new UserCommandNil();
        }
    }
}
