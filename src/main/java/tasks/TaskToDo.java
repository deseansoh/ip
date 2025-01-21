package tasks;

/**
 * Concrete class that encapsulates information about a normal todo task.
 */
public class TaskToDo extends Task {
    public TaskToDo(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "[T]" + super.getName();
    }
}
