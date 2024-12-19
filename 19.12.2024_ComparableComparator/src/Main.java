import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> arr = new ArrayList<Student>();

        for(int i = 6; i > 0; i--) {
            arr.add(new Student("A"+i, i, 6.0/i));
        }

        for(Student s : arr) {
            System.out.println(s);
        }
        System.out.println("---------");
        //Collections.sort(arr);
        Collections.sort(arr, new AvgComparator());
        //Collections.sort(arr, new NameComparator());
        for(Student s : arr) {
            System.out.println(s);
        }
    }
}