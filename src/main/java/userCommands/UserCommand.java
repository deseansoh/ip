package userCommands;

import utilities.Command;

public abstract class UserCommand {
    private Command commandType;

    public UserCommand(Command commandType) {
        this.commandType = commandType;
    }

    public Command getCommandType() {
        return this.commandType;
    }
}
