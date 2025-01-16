import java.util.ArrayList;
import static utilities.StringConstants.SEPARATORNEWLINE;
import static utilities.StringConstants.INDENT;

public class TaskList {
    private ArrayList<Entry> entries;

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public String addEntry(String entryName) {
        this.entries.add(new Entry(entryName));
        return "Added task: " + entryName + "\n" + SEPARATORNEWLINE;
    }

    public String markEntry(int number) {
        String printString = INDENT;
        if (number > entries.size()) {
            printString += "This task does not exist!\n" + SEPARATORNEWLINE;
            return printString;
        }

        Entry entryToMark = entries.get(number - 1);
        boolean marked = entryToMark.markDone();
        if (marked) {
            printString += "I have marked this task as done.\n" + INDENT + entryToMark.getName();
        } else {
            printString += "This task has already been marked.";
        }
        printString += "\n" + SEPARATORNEWLINE;
        return printString;
    }

    public String getTaskList() {
        String stringForm = "";
        int currentNumber = 1;

        for (Entry e: entries) {
            String numberString = String.valueOf(currentNumber);
            currentNumber++;

            stringForm = stringForm + (numberString + ". " + e.getName() + "\n");
        }

        stringForm = stringForm + SEPARATORNEWLINE;

        return stringForm;
    }
}
