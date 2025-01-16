public class ThoughtBot {
    public static void main(String[] args) {
        final String SEPARATOR = "________________________________________";

        final String GREETING = "________________________________________\n"
                + "Hello there! I'm ThoughtBot\n"
                + "How may I help you today?\n"
                + SEPARATOR;

        final String GOODBYE = "Goodbye! Have a great week ahead :)\n"
                + SEPARATOR;

        System.out.println(GREETING);
        System.out.println(GOODBYE);
    }
}
