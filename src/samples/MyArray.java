package samples;

import java.text.MessageFormat;

public class MyArray {
    private int[] items;
    private int count;

    public MyArray(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        //if array is full resize it
        if (items.length == count) {
            //create a new array
            int[] newItems = new int[count * 2];
            System.out.println("New array length is " + (count * 2));
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException(MessageFormat.format("Index {0} does not exist in the array", index));
        }
        //[10,20,30]
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println("Print array values..");
        for (int v = 0; v < count; v++) {
            System.out.println(items[v]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(2);
        myArray.insert(14);
        myArray.insert(134);
        myArray.insert(18);
        myArray.insert(91);
        myArray.insert(91);
        myArray.print();
        myArray.removeAt(2);
        myArray.print();
        System.out.println(myArray.indexOf(14));
    }
}
