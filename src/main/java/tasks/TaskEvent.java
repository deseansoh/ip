package tasks;

public class TaskEvent extends Task {
    private String fromTime;
    private String toTime;

    public TaskEvent(String name, String fromTime, String toTime) {
        super(name);
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    @Override
    public String getName() {
        return "[E]" + super.getName() + " (from: " + fromTime + " | to: " + toTime + ")";
    }
}
