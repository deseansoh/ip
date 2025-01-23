package tasks;

import java.time.LocalDateTime;

/**
 * Concrete class that encapsulates information about an event task. It has the
 * additional variables fromTime and toTime to keep track of this.
 */
public class TaskEvent extends Task {
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

    public TaskEvent(String name, LocalDateTime fromTime, LocalDateTime toTime) {
        super(name);
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    @Override
    public String getFullName() {
        return "[E]" + super.getFullName() + " (from: " + fromTime + " | to: " + toTime + ")";
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }
}
