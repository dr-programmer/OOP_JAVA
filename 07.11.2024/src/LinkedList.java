import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {

    class Node {
        private int data;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void print() {
            System.out.println("data: " + data);
        }
    }

    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public int insert(int index, int value) {
        Node newNode = new Node(value);
        if(index == 0) {
            newNode.setNext(head);
            head = newNode;
            length++;
            return index;
        }
        Node currentNode = head;
        for(int i = 1; i < index && currentNode != null; i++) {
            currentNode = currentNode.getNext();
        }
        if(currentNode == null) {
            return -1;
        }
        Node nextNode = currentNode.getNext();
        currentNode.setNext(newNode);
        newNode.setNext(nextNode);
        if(nextNode == null) {
            tail = newNode;
        }
        length++;
        return index;
    }

    public int remove(int index) {
        Node temp = head;
        if(index == 0) {
            head = temp.getNext();
            length--;
            return index;
        }
        for(int i = 1; i < index && temp != null; i++) {
            temp = temp.getNext();
        }
        if(temp != null && temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
            if(temp.getNext() == null) {
                tail = temp;
            }
        }
        else if(temp != null) {
            temp.setNext(null);
            tail = temp;
        }
        else {
            return -1;
        }
        length--;
        return index;
    }

    public Object getHead() {
        return head;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            temp.print();
            temp = temp.getNext();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(this);
    }
}


class ListIterator implements Iterator<Integer> {

    private LinkedList.Node current;

    public ListIterator(LinkedList list) {
        current = list.head;
    }

    @Override
    public boolean hasNext() {
        if(current == null) {
            return false;
        }
        return true;
    }

    @Override
    public Integer next() {
        Integer i = current.getData();
        current = current.getNext();
        return i;
    }
}
