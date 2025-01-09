import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    private int number;
    private String name;
    Test test;
    List<String> answers;

    public Student(int number, String name, Test test, List<String> answers) {
        this.number = number;
        this.name = name;
        this.test = test;
        this.answers = answers;
    }

    public int calculateScore() {
        int score = 0;
        for(int i = 0; i < answers.size(); i++) {
            Task task = test.getTasks().get(i);
            if(answers.get(i).equals(task.getCorrectAnswer())) {
                score += task.getScore();
            }
        }

        return score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public int compareTo(Student o) {
        int this_score = calculateScore();
        int other_score = o.calculateScore();
        if(this_score > other_score) {
            return 1;
        }
        else if(this_score < other_score) {
            return -1;
        }
        return new CompareByName().compare(this, o);
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", test=" + test +
                ", answers=" + answers +
                ", score=" + calculateScore() +
                '}';
    }

    class CompareByName implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
