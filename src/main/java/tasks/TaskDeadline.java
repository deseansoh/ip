package tasks;

public class TaskDeadline extends Task {
    private String deadline;

    public TaskDeadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String getName() {
        return "[D]" + super.getName() + " (by: " + deadline + ")";
    }
}
