package exceptions;

public class OutOfBoundsTaskException extends ThoughtBotException{
    public OutOfBoundsTaskException() {
        super("This task does not exist!");
    }
}
