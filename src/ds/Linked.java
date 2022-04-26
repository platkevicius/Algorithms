package ds;

public class Linked<T> {

    public static void main(String[] args) {
        System.out.println("Adding check:");
        Linked<Integer> linked = new Linked<>(new Node<>(10));
        Linked.insert(linked, 5);
        Linked.insert(linked, 4);
        Linked.insert(linked, 2);

        Linked.printOut(linked);

        System.out.println("Inversion check: ");

        Linked.invert(linked);
        Linked.printOut(linked);
        Linked.invert(linked);

        System.out.println("Deletion check: ");
        Linked.delete(linked, 2);
        Linked.delete(linked, 5);
        Linked.printOut(linked);
    }

    private Node<T> head;

    public Linked(Node<T> head) {
        this.head = head;
    }

    public static <T> void insert(Linked<T> list, T value) {
        if (list.head.next == null) {
            list.head.next = new Node<>(value);
            return;
        }

        insert(new Linked<>(list.head.next), value);
    }

    public static <T> void delete(Linked<T> list, T value) {
        Node<T> pred;
        Node<T> pointer = list.head;

        if (list.head.value == value) {
            list.head = list.head.next;
            return;
        }

        while (pointer.next != null) {
            pred = pointer;
            pointer = pointer.next;

            if (pointer.value == value) {
                pred.next = pointer.next;
                break;
            }
        }
    }

    public static <T> void invert(Linked<T> list) {
        Node<T> pointer1 = list.head;

        if (pointer1.next == null)
            return;

        Node<T> pointer2 = pointer1.next;
        pointer1.next = null;

        // inverse all links
        while (pointer2 != null) {
            Node<T> temp = pointer2.next;
            pointer2.next = pointer1;

            pointer1 = pointer2;
            pointer2 = temp;
        }

        // update new head element
        list.head = pointer1;
    }

    public static <T> void printOut(Linked<T> list) {
        if (list.head == null)
            return;

        System.out.println(list.head.value);
        printOut(new Linked<>(list.head.next));
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}
