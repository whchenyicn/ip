package whchenyicn.task;

public class Task {
    private String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    protected String getDesc() {
        return desc;
    }

    protected int isDone() {
        if (this.isDone) {
            return 1;
        }
        else {
            return 0;
        }
    }


    public String getStatus() {
        return (isDone ? "X" : " ");
    }

    public void markDone() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String toSave() {
        return String.format("? | %d | %s", isDone(), desc);
    }

    public String toString() {
        return "[" + this.getStatus() + "] " + desc;
    }
}
