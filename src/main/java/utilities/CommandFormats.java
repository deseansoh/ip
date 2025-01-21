package utilities;

/**
 * Class that contains final String objects of the correct formatting for each command the user
 * can input
 */
public final class CommandFormats {

    private CommandFormats() {
        // to prevent instantiation
    }

    public static final String LIST = "list";
    public static final String TODO = "todo <task description>";
    public static final String DEADLINE = "deadline <task description> /by <due time>";
    public static final String EVENT = "event <task description> /from <from time> /to <to time>";
    public static final String MARK = "mark <task index number>";
    public static final String UNMARK = "unmark <task index number>";
    public static final String DELETE = "delete <task index number>";
    public static final String BYE = "bye";
}
