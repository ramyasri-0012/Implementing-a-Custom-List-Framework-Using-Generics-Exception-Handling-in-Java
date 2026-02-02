package Assignment4;

public class Task5 {
    interface MyList<T> {
        void add(T element);

        void insert(T element, int index);

        T get(int index);

        void delete(int index);

        int size();

        boolean isEmpty();
    }

    static class MyArrayList<T> implements MyList<T> {

        private Object[] data = new Object[1];
        private int size = 0;

        public void add(T element) {
            grow();
            data[size++] = element;
        }

        public void insert(T element, int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index out of range");

            grow();
            for (int i = size; i > index; i--)
                data[i] = data[i - 1];

            data[index] = element;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (isEmpty())
                throw new IllegalStateException("List is empty");

            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index out of range");

            return (T) data[index];
        }

        public void delete(int index) {
            if (isEmpty())
                throw new IllegalStateException("List is empty");

            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index out of range");

            for (int i = index; i < size - 1; i++)
                data[i] = data[i + 1];

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

    static class MyLinkedList<T> implements MyList<T> {

        private class Node {
            T data;
            Node next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node head;
        private int size = 0;

        public void add(T element) {
            Node n = new Node(element);
            if (head == null)
                head = n;
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = n;
            }
            size++;
        }

        public void insert(T element, int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index out of range");

            Node n = new Node(element);

            if (index == 0) {
                n.next = head;
                head = n;
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++)
                    temp = temp.next;
                n.next = temp.next;
                temp.next = n;
            }
            size++;
        }

        public T get(int index) {
            if (isEmpty())
                throw new IllegalStateException("List is empty");

            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index out of range");

            Node temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;

            return temp.data;
        }

        public void delete(int index) {
            if (isEmpty())
                throw new IllegalStateException("List is empty");

            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index out of range");

            if (index == 0)
                head = head.next;
            else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++)
                    temp = temp.next;
                temp.next = temp.next.next;
            }
            size--;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void displayList(MyList<?> list) {
        try {
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operation Completed\n");
        }
    }

    public static void main(String[] args) {

        MyList<Integer> list1 = new MyArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.insert(15, 1);

        MyList<String> list2 = new MyLinkedList<>();
        list2.add("A");
        list2.add("B");
        list2.delete(0);

        displayList(list1);
        displayList(list2);

        try {
            list2.get(5);
        } catch (Exception e) {
            System.out.println("Handled Exception: " + e);
        }
    }

}
