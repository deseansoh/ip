package utilities;

public final class Constants {

    private Constants() {
        // to prevent instantiation
    }

    public static final String INDENT = "    ";
    public static final String SEPARATOR = INDENT + "________________________________________";
    public static final String SEPARATORNEWLINE = INDENT + "________________________________________\n";

    public static final String GREETING = SEPARATORNEWLINE
            + INDENT + "Hello there! I'm ThoughtBot\n"
            + INDENT + "How may I help you today?\n"
            + SEPARATORNEWLINE;

    public static final String GOODBYE = INDENT + "Goodbye! Have a great week ahead :)\n"
            + SEPARATOR;
}
