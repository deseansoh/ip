import userCommands.*;
import utilities.Command;

public class Parser {
    private Parser() {
        // to prevent instantiation
    }

    public static UserCommand parseInput(String userInput) {
        String firstWord = userInput.split(" ")[0];
        int markUnmarkNumber;

        switch (firstWord.toLowerCase()) {
        case "list":
            return new UserCommandList();
        case "mark":
            markUnmarkNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
            return new UserCommandMarkUnmark(Command.MARK, markUnmarkNumber);
        case "unmark":
            markUnmarkNumber = Integer.parseInt(userInput.split(" ", 2)[1]);
            return new UserCommandMarkUnmark(Command.UNMARK, markUnmarkNumber);
        default:
            return new UserCommandNil();
        }
    }
}
