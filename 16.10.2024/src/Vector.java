public class Vector {
    private int[] vector;
    private int capacity;
    public Vector() {
        vector = new int[10];
        capacity = 10;
    }
    public Vector(int capacity) {
        vector = new int[capacity];
        this.capacity = capacity;
    }
    public void insert(int index, int value) {
        if(index >= capacity) {
            System.out.println("Index out of bounds");
            return;
        }
        vector[index] = value;
    }
    public void append(int value) {
        if(vector.length >= capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            System.arraycopy(vector, 0, temp, 0, vector.length);
            vector = temp;
        }
        vector[vector.length - 1] = value;
    }
    public int get(int index) {
        if(index >= capacity) return -1;
        return vector[index];
    }
    public void remove(int index) {
        if(index >= capacity) return;
        vector[index] = 0;
    }

    public static void main(String[] args) {
        Vector vector = new Vector(2);
        vector.insert(0, 1);
        vector.insert(1, 2);
        vector.append(5);
        System.out.println(vector.get(0));
        vector.remove(2);
        System.out.println(vector.get(0));
    }
}
