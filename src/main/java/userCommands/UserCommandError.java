package userCommands;

import utilities.Command;

public class UserCommandError extends UserCommand {
    private String errorMessage;

    public UserCommandError(String errorMessage) {
        super(Command.ERROR);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
