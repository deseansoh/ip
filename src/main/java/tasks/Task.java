package tasks;

/**
 * Abstract parent class of all Task classes, used to encapsulate information about
 * a specific task that a user has added. Every task has a name and needs to keep
 * track of whether it is done.
 */
public abstract class Task {
    private String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    /**
     * Marks a task as done if it is currently undone. If the operation is successful, return true.
     * If the task was already marked in the first place, return false
     *
     * @return True if changed from unmarked to marked, false if remain as marked
     */
    public boolean markDone() {
        if (!done) {
            this.done = true;
            return true;
        }

        return false;
    }

    /**
     * Unmarks a task as done if it is currently done. If the operation is successful, return true.
     * If the task was already unmarked in the first place, return false
     *
     * @return True if changed from marked to unmarked, false if remain as unmarked
     */
    public boolean unmarkDone() {
        if (done) {
            this.done = false;
            return true;
        }

        return false;
    }

    public String getName() {
        if (done) {
            return "[X] " + this.name;
        }

        return "[ ] " + this.name;
    }
}
