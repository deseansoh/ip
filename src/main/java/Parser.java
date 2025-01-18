import exceptions.*;
import userCommands.*;
import utilities.Command;
import utilities.CommandFormats;

public class Parser {
    private Parser() {
        // to prevent instantiation
    }

    public static UserCommand parseInput(String userInput) throws ThoughtBotException {
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
                throw new EmptyDescException(CommandFormats.TODO);
            }
        case "deadline":
            if (!userInput.contains(" /by ")) {
                throw new UnrecognisedKeywordException(CommandFormats.DEADLINE);
            }

            String[] splitSlashBy = userInput.split(" /by ");
            String [] splitDeadline = splitSlashBy[0].split(" ", 2);
            if (splitSlashBy.length != 2 || splitDeadline.length != 2) {
                throw new EmptyDescException(CommandFormats.DEADLINE);
            }

            String deadlineTaskName = splitDeadline[1];
            String deadlineString = splitSlashBy[1];
            return new UserCommandDeadline(deadlineTaskName, deadlineString);
        case "event":
            if (!userInput.contains(" /from ") || !userInput.contains(" /to ")) {
                throw new UnrecognisedKeywordException(CommandFormats.EVENT);
            }

            String[] splitSlashFrom = userInput.split(" /from ");
            String[] splitSlashTo = splitSlashFrom[1].split(" /to ");
            if (splitSlashFrom.length != 2 || splitSlashTo.length != 2) {
                throw new EmptyDescException(CommandFormats.EVENT);
            }

            String eventTaskName = splitSlashFrom[0].split(" ", 2)[1];
            String eventFrom = splitSlashTo[0];
            String eventTo = splitSlashTo[1];
            return new UserCommandEvent(eventTaskName, eventFrom, eventTo);
        case "mark":
            try {
                int markNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
                return new UserCommandMarkUnmark(Command.MARK, markNumber);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new EmptyDescException(CommandFormats.MARK);
            }
        case "unmark":
            try {
                int unmarkNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
                return new UserCommandMarkUnmark(Command.UNMARK, unmarkNumber);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new EmptyDescException(CommandFormats.UNMARK);
            }
        case "delete":
            int deleteNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
            return new UserCommandDelete(deleteNumber);
        default:
            throw new UnrecognisedCmdException();
        }
    }
}
