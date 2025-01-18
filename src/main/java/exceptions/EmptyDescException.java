package exceptions;

public class EmptyDescException extends ThoughtBotException{
    public EmptyDescException(String correctFormat) {
        super("The description is empty!\n"
                + "The correct format is here.\n"
                + "Format: " + correctFormat);
    }
}
