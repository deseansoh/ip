package exceptions;

public class DateTimeFormatException extends ThoughtBotException{
    public DateTimeFormatException() {
        super("The date and time are formatted wrongly.\n"
                + "The correct format is as follows:\n"
                + "YYYY-MM-DD HH:MM");
    }
}
