import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueGame {
    private Queue<Integer> queue;
    private int step;

    public QueueGame(int size, int step) {
        queue = new LinkedList<Integer>();
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }
        this.step = step;
    }

    public void showPops() {
        for(int i = 1; !queue.isEmpty(); i++) {
            if(i % step == 0) {
                System.out.println(queue.poll());
            }
            else {
                queue.add(queue.poll());
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Size and step: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int step = sc.nextInt();
        sc.close();
        QueueGame game = new QueueGame(size, step);
        game.showPops();
    }
}
