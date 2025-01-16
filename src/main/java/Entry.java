public class Entry {
    private String name;
    private boolean done;

    public Entry(String name) {
        this.name = name;
        this.done = false;
    }

    public String getName() {
        if (done) {
            return "[X] " + this.name;
        }

        return "[ ] " + this.name;
    }

    public boolean markDone() {
        if (!done) {
            this.done = true;
            return true;
        }

        return false;
    }

    public boolean markUndone() {
        if (done) {
            this.done = false;
            return true;
        }

        return false;
    }
}
