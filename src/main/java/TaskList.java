import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(int limit) {
        this.taskList = new ArrayList<>(100);
    }

    public TaskList(List<Task> tlist) {
        this.taskList = tlist;
    }

    public int size() {
        return this.taskList.size();
    }

    public Task get(int index) {
        return this.taskList.get(index);
    }

    public void add(Task t) {
        this.taskList.add(t);
    }

    public void clear() {
        this.taskList.clear();
    }

    public void addAll(List<Task> tlist) {
        this.taskList.addAll(tlist);
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public List<Task> asList() {
        return taskList;
    }

    public Task remove(int index) {
        return this.taskList.remove(index);
    }
}
