import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }
    public LinkedList(int value) {
        head = new Node(value);
        size = 1;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        Node newNode = new Node(value);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
            } else {
                Node tail = head.prev;
                newNode.next = head;
                newNode.prev = tail;
                tail.next = newNode;
                head.prev = newNode;
                head = newNode;
            }
        }
        else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }


    public boolean contains(int value) {
        Node current = head;
        for(int i = 0; i < size; i++) {
            if(current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int value) {
        Node current = head;
        for(int i = 0; i < size; i++) {
            if(current.value == value) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        Node current = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (current.value == value) {
                lastIndex = i;
            }
            current = current.next;
        }
        return lastIndex;
    }

    public int getFirst() {
        if(head == null) {
            return -1;
        }
        return head.value;
    }

    public int getLast() {
        if(head == null) {
            return -1;
        }
        if(size > 1) {
            return head.prev.value;
        }
        return head.value;
    }

    public int poll(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current == head) {
            if (size == 1) {
                head = null;
            } else {
                Node tail = head.prev;
                head = head.next;
                tail.next = head;
                head.prev = tail;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.value;
    }

    public int pollLast() {
        if (head == null) return -1;

        if (size == 1) {
            int value = head.value;
            head = null;
            size--;
            return value;
        } else {
            Node tail = head.prev;
            int value = tail.value;
            tail.prev.next = head;
            head.prev = tail.prev;
            size--;
            return value;
        }
    }

    public int pollFirst() {
        if (head == null) return -1;

        int value = head.value;
        if (size == 1) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(this);
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }
    }

    private class ListIterator implements Iterator<Integer> {
        private Node current;
        private final int size;
        private int currentIndex;

        public ListIterator(LinkedList list) {
            current = list.head;
            size = list.size;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            if(size == 0) return false;
            Node temp = current;
            int index = currentIndex;
            while(index < size) {
                if(temp.value % 2 == 1) {
                    return true;
                }
                temp = temp.next;
                index++;
            }
            return false;
        }

        @Override
        public Integer next() {
            while(currentIndex < size) {
                if(current.value % 2 == 1) {
                    int value = current.value;
                    current = current.next;
                    currentIndex++;
                    return value;
                }
                current = current.next;
                currentIndex++;
            }
            return null;
        }
    }
}
