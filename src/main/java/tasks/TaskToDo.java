package tasks;

public class TaskToDo extends Task {
    public TaskToDo(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "[T]" + super.getName();
    }
}
