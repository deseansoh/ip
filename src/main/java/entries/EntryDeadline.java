package entries;

public class EntryDeadline extends Entry {
    private String deadline;

    public EntryDeadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String getName() {
        return "[D]" + super.getName() + " (by: " + deadline + ")";
    }
}
