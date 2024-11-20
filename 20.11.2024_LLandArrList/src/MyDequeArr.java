public class MyDequeArr {
    private int[] arr;
    private int size;

    public MyDequeArr() {
        arr = new int[10];
        size = 0;
    }

    private void resize() {
        if(size >= arr.length) {
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    public void addFront(int x) {
        size++;
        resize();
        for(int i = size-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = x;
    }
    public void addBack(int x) {
        size++;
        resize();
        arr[size-1] = x;
    }

    public int removeFront() {
        int returnValue = arr[0];
        for(int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return returnValue;
    }
    public int removeBack() {
        int returnValue = arr[--size];
        arr[size] = 0;
        return returnValue;
    }

    public int peekFront() {
        return arr[0];
    }
    public int peekBack() {
        return arr[size-1];
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyDequeArr deque = new MyDequeArr();
        deque.addFront(1);
        deque.addBack(2);
        deque.addBack(3);
        deque.addBack(4);
        deque.addBack(5);
        deque.addFront(6);
        deque.addFront(8);

        deque.print();

        System.out.println(deque.removeFront());
        System.out.println(deque.removeBack());
        System.out.println(deque.removeFront());
        System.out.println(deque.removeBack());
        System.out.println(deque.peekFront());
        System.out.println(deque.peekBack());

        deque.print();
    }
}
