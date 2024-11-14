import java.util.Iterator;

public class Vector implements Iterable<Integer> {
    private int[] vector;
    private int size;
    private int capacity;

    public Vector() {
        vector = new int[5];
        capacity = 5;
        size = 0;
    }
    public Vector(int value) {
        vector = new int[5];
        this.capacity = 5;
        vector[0] = value;
        size = 1;
    }

    public void insert(int index, int value) {
        if(index >= capacity) {
            System.out.println("Index out of bounds");
            return;
        }
        vector[index] = value;
        size++;
    }
    public void pushBack(int value) {
        if(size == 0) {
            vector[0] = value;
            size++;
            return;
        }
        if(size >= capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            System.arraycopy(vector, 0, temp, 0, size);
            vector = temp;
        }
        vector[size++] = value;
    }
    public int get(int index) {
        if(index >= capacity) return -1;
        return vector[index];
    }
    public int remove(int index) {
        if(index >= capacity) return -1;
        int value = vector[index];
        vector[index] = 0;
        size--;
        return value;
    }
    public int pop() {
        if(size <= 0) return -1;
        int value = vector[size - 1];
        vector[size - 1] = 0;
        size--;
        return value;
    }

    public int at(int index) {
        if(index >= size) return -1;
        return vector[index];
    }

    public boolean contains(int value) {
        if(size <= 0) return false;
        for(int i = 0; i < size; i++) {
            if(vector[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Vector vector = new Vector(2);
        vector.insert(0, 1);
        vector.insert(1, 2);
        vector.pushBack(5);
        System.out.println(vector.get(0));
        vector.remove(2);
        System.out.println(vector.get(0));

        for(int i: vector) {
            System.out.println("Data: " + i);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new VectorIterator(this);
    }

    private class VectorIterator implements Iterator<Integer> {
        int[] v;
        int index;

        public VectorIterator(Vector vector) {
            this.v = vector.vector;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            for(int i = index; i < size; i++) {
                if(v[i] % 2 == 0) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            for(; index < size; index++) {
                if(v[index] % 2 == 0) {
                    int value = v[index];
                    index++;
                    return value;
                }
            }
            return null;
        }
    }
}