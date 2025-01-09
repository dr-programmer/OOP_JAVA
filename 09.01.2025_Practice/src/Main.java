import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        List<Task> tasks = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            tasks.add(new Task("Question " + i + 1,
                    List.of("asd", "fgh", "ghj", "zxc"), i + 10, 0));
        }

        for(int i = 0; i < 10; i++) {
           students.add(new Student(i + 1, i + " name",
                   new Test(String.valueOf(i + 3), String.valueOf(i + 1), tasks),
                   List.of("asd", "fgh", "ghj", "zxc", "asd", "fgh", "ghj", "zxc", "ghj", "zxc")));
        }

        students.sort(null);
        System.out.println(students);
    }
}