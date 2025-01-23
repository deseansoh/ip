package tasks;

/**
 * Concrete class that encapsulates information about a normal todo task.
 */
public class TaskToDo extends Task {
    public TaskToDo(String name) {
        super(name);
    }

    @Override
    public String getFullName() {
        return "[T]" + super.getFullName();
    }
}
