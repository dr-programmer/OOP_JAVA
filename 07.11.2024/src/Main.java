public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        // ll.print();
        ll.push(12);
        ll.push(13);
        ll.push(14);

        ll.insert(4, 33);

//        ll.remove(4);

        ll.push(123);

        ll.print();

        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i: arr) {
            System.out.println(i);
        }

        for(int i: ll) {
            System.out.println(i);
        }
    }
}