import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private double avg;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", avg=" + avg +
                '}';
    }

    public Student(String name, int id, double avg) {
        this.name = name;
        this.id = id;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public int compareTo(Student o) {
        if(this.id > o.id) return 1;
        else if(this.id < o.id) return -1;
        return 0;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AvgComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAvg() > o2.getAvg()) return 1;
        else if(o1.getAvg() < o2.getAvg()) return -1;
        return 0;
    }
}
