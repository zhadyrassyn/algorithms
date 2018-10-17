package dataStructure.stringBuilder;

public class MyStringBuilder {

    int max = Integer.MAX_VALUE;

    private char[] arr;

    private int index = 0;
    private int capacity = 16;

    public MyStringBuilder() {
        arr = new char[capacity];
    }

    public void append(Object val) {
        String inputString = String.valueOf(val);
        int N = inputString.length();

        if (index + N >= capacity) {
            capacity = index + N;
            char[] temp = new char[capacity];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }

        for (int i = 0; i < inputString.length(); i++) {
            arr[index++] = inputString.charAt(i);
        }
    }

    public int length() {
        return index;
    }

    public String toString() {
        return new String(arr, 0, index);
    }

    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();

        sb.append("Good morning");

        System.out.println(sb.length());

        sb.append("This is the man's world");

        System.out.println(sb.length());

        System.out.println(sb);
    }
}
