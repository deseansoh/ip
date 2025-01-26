package thoughtbot;

/**
 * The ThoughBot class is the main class for the chatbot that helps you
 * keep track of tasks.
 */
public class ThoughtBot {
    /**
     * Entry point for the ThoughtBot program
     * @param args Additional arguments to be supplied
     */
    public static void main(String[] args) {
        boolean canContinue = true;
        TaskList myList = SaveLoad.load();
        Ui myUi = new Ui();

        myUi.greet();

        while (canContinue) {
            canContinue = myUi.getUserInputAndContinue(myList);
        }

        SaveLoad.save(myList);
        myUi.goodbye();
    }
}
