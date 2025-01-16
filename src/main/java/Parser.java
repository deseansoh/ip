import userCommands.*;
import utilities.Command;

public class Parser {
    private Parser() {
        // to prevent instantiation
    }

    public static UserCommand parseInput(String userInput) {
        String firstWord = userInput.split(" ")[0];

        switch (firstWord.toLowerCase()) {
        case "list":
            return new UserCommandList();
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
