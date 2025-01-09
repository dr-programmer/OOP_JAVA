import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private String date;
    private String group;
    List<Task> tasks;

    public Test(String date, String group, List<Task> tasks) {
        this.date = date;
        this.group = group;
        this.tasks = tasks.stream().distinct().sorted().collect(Collectors.toList());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
