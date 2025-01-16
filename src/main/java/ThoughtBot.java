import java.util.Scanner;

public class ThoughtBot {
    static final String SEPARATOR = "    ________________________________________";
    static final String SEPARATORNEWLINE = "    ________________________________________\n";

    static final String GREETING = SEPARATORNEWLINE
            + "    Hello there! I'm ThoughtBot\n"
            + "    How may I help you today?\n"
            + SEPARATORNEWLINE;

    static final String GOODBYE = "    Goodbye! Have a great week ahead :)\n"
            + SEPARATOR;

    public static void main(String[] args) {
        String userInput;
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println(GREETING);

        userInput = getUserInput(userInputScanner);

        while (!userInput.equalsIgnoreCase("bye")) {
            System.out.println(userInput + "\n" + SEPARATORNEWLINE);

            userInput = getUserInput(userInputScanner);
        }

        System.out.println(GOODBYE);
    }

    public static String getUserInput(Scanner userInputScanner) {
        String userInput = userInputScanner.nextLine();
        System.out.println(SEPARATOR);
        return userInput;
    }
}
