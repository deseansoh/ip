import java.util.ArrayList;
import static utilities.Constants.SEPARATORNEWLINE;
import static utilities.Constants.INDENT;

public class TaskList {
    private ArrayList<Entry> entries;

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public void addEntry(String entryName) {
        this.entries.add(new Entry(entryName));
        System.out.println("Added task: " + entryName + "\n" + SEPARATORNEWLINE);
    }

    public void markEntry(int number) {
        String printString = INDENT;
        if (number > entries.size()) {
            printString += "This task does not exist!\n" + SEPARATORNEWLINE;
            System.out.println(printString);
            return;
        }

        Entry entryToMark = entries.get(number - 1);
        boolean marked = entryToMark.markDone();
        if (marked) {
            printString += "I have marked this task as done.\n" + INDENT + entryToMark.getName();
        } else {
            printString += "This task has already been marked.";
        }
        printString += "\n" + SEPARATORNEWLINE;
        System.out.println(printString);
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
