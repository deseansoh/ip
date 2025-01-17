package exceptions;

public class UnrecognisedCmdException extends ThoughtBotException{
    public UnrecognisedCmdException() {
        super("Sorry, I do not understand the command!\n"
                + "Do ensure the command is valid\n");
    }
}
