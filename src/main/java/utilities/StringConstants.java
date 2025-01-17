package utilities;

public final class StringConstants {

    private StringConstants() {
        // to prevent instantiation
    }

    public static final String INDENT = "    ";
    public static final String SEPARATORNEWLINE = "________________________________________\n";

    public static final String GREETING = INDENT + SEPARATORNEWLINE
            + INDENT + "Hello there! I'm ThoughtBot\n"
            + INDENT + "How may I help you today?\n"
            + INDENT + SEPARATORNEWLINE;

    public static final String GOODBYE = INDENT + SEPARATORNEWLINE
            + INDENT + "Goodbye! Have a great week ahead :)\n"
            + INDENT + SEPARATORNEWLINE;
}
