import java.util.ArrayList;

public class TaskList {
    private ArrayList<Entry> entries;

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public void addEntry(String entryName) {
        this.entries.add(new Entry(entryName));
    }

    public String displayTaskList() {
        String stringForm = "";
        int currentNumber = 1;

        for (Entry e: entries) {
            String numberString = String.valueOf(currentNumber);
            currentNumber++;

            stringForm = stringForm + (numberString + ". " + e.getName() + "\n");
        }

        return stringForm;
    }
}
