import java.util.ArrayList;
import static utilities.Constants.SEPARATORNEWLINE;

public class TaskList {
    private ArrayList<Entry> entries;

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public void addEntry(String entryName) {
        this.entries.add(new Entry(entryName));
        System.out.println("Added task: " + entryName + "\n" + SEPARATORNEWLINE);
    }

    public void displayTaskList() {
        String stringForm = "";
        int currentNumber = 1;

        for (Entry e: entries) {
            String numberString = String.valueOf(currentNumber);
            currentNumber++;

            stringForm = stringForm + (numberString + ". " + e.getName() + "\n");
        }

        stringForm = stringForm + SEPARATORNEWLINE;

        System.out.println(stringForm);
    }
}
