package exceptions;

/**
 * Abstract parent class of all ThoughtBot exceptions that can be thrown by the program
 */
public class ThoughtBotException extends Exception{
    public ThoughtBotException(String errorMessage) {
        super(errorMessage);
    }
}
