//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Primitive types: byte, short, int, long
        // Class types: Byte, Short, Integer, Long
        // Primitive types: char, float, double
        // Class types: Char, Float, Double
        byte a = 12; // -127 <-> 128
        short b = 12;
        int c = 12;
        long d = 12L;
        Integer e =12;
        e.compareTo(13);

        // Garbage collection, String vs StringBuilder vs Buffer
        // Immutable vs Mutable classes

        // String - immutable class
        String str = "Hello";
        String str1 = "World";
        str.concat(str1);

        boolean isEmpty = str.isEmpty();
        String empty = " ";
        System.out.println(empty.isEmpty());
        System.out.println(empty.isBlank());
        boolean isBlank = str.isBlank();
        System.out.println(str);

        // StringBuilder - mutable class
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str1);
        System.out.println(stringBuilder);

        // StringBuffer - Mutable class
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append("World");
        System.out.println(stringBuffer);

        String s1 = "";
        StringBuilder s2 = new StringBuilder(s1);
        StringBuffer s3 = new StringBuffer(s1);

        long startTime1 = System.currentTimeMillis();
        System.out.println("Start time: " + startTime1);

        for(int i = 0; i < 100_000; i++) {
            s1 += i;
        }

        System.out.println("End time: " + (int)(System.currentTimeMillis() - startTime1));

        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < 100_000; i++) {
            s2.append(i);
        }

        System.out.println("End time: " + (int)(System.currentTimeMillis() - startTime2));

        long startTime3 = System.currentTimeMillis();
        for(int i = 0; i < 100_000; i++) {
            s3.append(i);
        }

        System.out.println("End time: " + (int)(System.currentTimeMillis() - startTime3));

        // s1, s2, s3
        s1 = null;
        String s = new String("Hello");

        // Garbage collection
        System.gc();

        Integer l = 12;
        Integer k = l;
        l = null;
    }
}