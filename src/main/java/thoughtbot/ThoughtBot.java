package thoughtbot;

/**
 * The ThoughtBot class is the main class for the chatbot that helps you
 * keep track of tasks.
 */
public class ThoughtBot {
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
