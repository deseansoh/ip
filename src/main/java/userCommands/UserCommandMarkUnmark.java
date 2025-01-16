package userCommands;

import utilities.Command;

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
