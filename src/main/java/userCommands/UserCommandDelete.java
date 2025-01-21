package userCommands;

import utilities.Command;

/**
 * Concrete class that encapsulates information about the DELETE command, namely
 * the index of the task to be deleted
 */
public class UserCommandDelete extends UserCommand{
    private int deleteNumber;

    public UserCommandDelete(int deleteNumber) {
        super(Command.DELETE);
        this.deleteNumber = deleteNumber;
    }

    public int getDeleteNumber() {
        return deleteNumber;
    }
}
