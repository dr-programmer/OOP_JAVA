import java.util.List;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private String question;
    private List<String> answers;
    private int score;
    private int answer_index;

    public Task(String question, List<String> answers, int score, int answer_index) {
        this.question = question;
        this.answers = answers;
        this.score = score;
        this.answer_index = answer_index;
    }

    public String getCorrectAnswer() {
        return answers.get(answer_index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(question, task.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answers, score);
    }

    @Override
    public int compareTo(Task o) {
        int this_answers_count = this.answers.size();
        int other_answers_count = o.answers.size();
        if (this_answers_count < other_answers_count) {
            return -1;
        }
        if (this_answers_count > other_answers_count) {
            return 1;
        }
        return 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAnswer_index() {
        return answer_index;
    }

    public void setAnswer_index(int answer_index) {
        this.answer_index = answer_index;
    }
}
