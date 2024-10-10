import java.util.Objects;

public class Student {
    int number;
    String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student() {

    }
    Student(int number, String name) {
        this.number = number;
        this.name = name;
    }
    Student(Student s) {
        this.number = s.number;
        this.name = s.name;
    }

    public void initStudent(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Gosho";
        s1.number = 10;

        System.out.println("Number of student: " + s1.number);
        System.out.println("Name of student: " + s1.name);

        s1.initStudent("Pesho", 20);

        Student s2 = new Student();
        s2.initStudent("Pesho", 20);

        System.out.println(s1.equals(s2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return number == student.number && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
