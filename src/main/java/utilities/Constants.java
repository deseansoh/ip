package utilities;

public final class Constants {

    private Constants() {
        // to prevent instantiation
    }

    public static final String SEPARATOR = "    ________________________________________";
    public static final String SEPARATORNEWLINE = "    ________________________________________\n";

    public static final String GREETING = SEPARATORNEWLINE
            + "    Hello there! I'm ThoughtBot\n"
            + "    How may I help you today?\n"
            + SEPARATORNEWLINE;

    public static final String GOODBYE = "    Goodbye! Have a great week ahead :)\n"
            + SEPARATOR;
}
