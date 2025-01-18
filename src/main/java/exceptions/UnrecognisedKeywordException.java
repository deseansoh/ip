package exceptions;

public class UnrecognisedKeywordException extends ThoughtBotException{
    public UnrecognisedKeywordException(String correctFormat) {
        super("A keyword has been typed wrongly or omitted!\n"
                + "The correct format is here.\n"
                + "Format: " + correctFormat);
    }
}
