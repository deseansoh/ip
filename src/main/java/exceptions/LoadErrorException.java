package exceptions;

/**
 * Concrete class that is thrown when there is some error in loading the file. The message depends on what it
 * is given
 */
public class LoadErrorException extends ThoughtBotException{
    public LoadErrorException(String errorMessage) {
        super(errorMessage);
    }
}
