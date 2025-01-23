package tasks;

/**
 * Concrete class that encapsulates information about a task with deadline. It has the
 * additional variable deadline to keep track of this.
 */
public class TaskDeadline extends Task {
    private String deadline;

    public TaskDeadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String getFullName() {
        return "[D]" + super.getFullName() + " (by: " + deadline + ")";
    }

    public String getDeadline() {
        return deadline;
    }
}
