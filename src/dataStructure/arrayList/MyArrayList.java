package dataStructure.arrayList;

public class MyArrayList<E> {

    private int N = 2;
    private Object[] arr = new Object[N];
    private int index = 0;

    public void add(E element) {
        if(index + 1 == N) {
            N *= 2;
            Object[] temp = new Object[N];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[index++] = element;
    }

    public E get(int i) {
        if (i >= index) {
            throw new IndexOutOfBoundsException();
        }

        return (E)arr[i];
    }

    public int size() {
        return arr.length;
    }

    public void print() {
        int i = 0;
        while(i < index) {
            System.out.print(arr[i] + ",");
            ++i;
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(8);
        myArrayList.print();

        System.out.println(myArrayList.get(2));
//        System.out.println(myArrayList.get(3));
    }
}
