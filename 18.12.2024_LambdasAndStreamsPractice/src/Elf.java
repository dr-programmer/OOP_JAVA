public class Elf implements Comparable<Elf> {
    private int index;
    private long age;

    public Elf(int index, long age) {
        this.index = index;
        this.age = age;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "index=" + index +
                ", age=" + age +
                '}';
    }

    @Override
    // -1 = less
    // 0 = equal
    // 1 = greater
    public int compareTo(Elf elf) {
        if(this.age > elf.age) return 1;
        else if(this.age < elf.age) return -1;
        else return 0;
    }
}
