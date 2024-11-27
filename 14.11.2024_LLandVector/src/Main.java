import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Number of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        LinkedList ll = new LinkedList();
        Vector v = new Vector();

        for(int i = 0; i < n; i++) {
            if(!ll.contains(arr[i])) {
                ll.addLast(arr[i]);
            }
            if(!v.contains(arr[i])) {
                v.pushBack(arr[i]);
            }
        }

        for(int i: ll) {
            System.out.println("ll: " + i + " ");
        }

        for(int i: v) {
            System.out.println("v: " + i + " ");
        }
    }
}