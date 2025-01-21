package userCommands;

import utilities.Command;

/**
 * Concrete class that encapsulates information about the MARK and UNMARK command, including
 * the index of the task to be marked or unmarked
 */
public class UserCommandMarkUnmark extends UserCommand{
    private int markUnmarkNumber;

    public UserCommandMarkUnmark(Command commandType, int markUnmarkNumber) {
        super(commandType);
        this.markUnmarkNumber = markUnmarkNumber;
    }

    public int getMarkUnmarkNumber() {
        return markUnmarkNumber;
    }
}
