import java.util.ArrayList;
import java.util.List;

public class MyDeque {
    private List<Integer> list =  new ArrayList<Integer>();

    public MyDeque() {}

    public void addFirst(int x) {
        list.addFirst(x);
    }
    public void addLast(int x) {
        list.addLast(x);
    }

    public int removeFirst() {
        return list.removeFirst();
    }
    public int removeLast() {
        return list.removeLast();
    }

    public int peekFirst() {
        return list.getFirst();
    }
    public int peekLast() {
        return list.getLast();
    }
}
