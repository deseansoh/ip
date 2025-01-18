package userCommands;

import utilities.Command;

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
