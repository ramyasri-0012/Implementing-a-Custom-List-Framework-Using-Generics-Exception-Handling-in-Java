package Assignment4;

public class genericsT1 {
    public interface MyList<T> {

    void add(T element);

    void insert(T element, int index);

    T get(int index);

    void delete(int index);

    int size();

    boolean isEmpty();
}

    class MyArrayList<T> implements MyList<T> {

    private Object[] data = new Object[1]; 
    private int size = 0;

    public void add(T element) {
        grow();
        data[size++] = element;
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        grow();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
    }
}

public static void main(String[] args) {

    genericsT1 outer = new genericsT1();
    genericsT1.MyList<Integer> list = outer.new MyArrayList<>();

    list.add(10);
    list.add(20);
    list.insert(15, 1);

    System.out.println(list.get(1)); // 15
    list.delete(1);

    System.out.println("Size: " + list.size());
    System.out.println("Empty? " + list.isEmpty());
}
}
