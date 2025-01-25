package utilities;

/**
 * Class that contains final String objects of commonly used Strings by the chatbot
 */
public final class StringConstants {
    public static final String INDENT = "    ";
    public static final String SEPARATORNEWLINE = "________________________________________\n";

    public static final String GREETING = INDENT + SEPARATORNEWLINE
            + INDENT + "Hello there! I'm ThoughtBot\n"
            + INDENT + "How may I help you today?\n"
            + INDENT + SEPARATORNEWLINE;

    public static final String GOODBYE = INDENT + SEPARATORNEWLINE
            + INDENT + "Goodbye! Have a great week ahead :)\n"
            + INDENT + SEPARATORNEWLINE;

    private StringConstants() {
        // to prevent instantiation
    }
}
