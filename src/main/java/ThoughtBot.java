import java.util.Scanner;

public class ThoughtBot {
    public static void main(String[] args) {
        final String SEPARATOR = "________________________________________";

        final String GREETING = "________________________________________\n"
                + "Hello there! I'm ThoughtBot\n"
                + "How may I help you today?\n"
                + SEPARATOR;

        final String GOODBYE = "Goodbye! Have a great week ahead :)\n"
                + SEPARATOR;

        String userInput;
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println(GREETING);

        userInput = userInputScanner.nextLine();
        System.out.println(SEPARATOR);

        while (!userInput.toLowerCase().equals("bye")) {
            System.out.println(userInput + "\n" + SEPARATOR);

            userInput = userInputScanner.nextLine();
            System.out.println(SEPARATOR);
        }

        System.out.println(GOODBYE);
    }
}
