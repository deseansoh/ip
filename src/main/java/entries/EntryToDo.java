package entries;

public class EntryToDo extends Entry{
    public EntryToDo(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "[T]" + super.getName();
    }
}
