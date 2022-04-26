package ds;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

    private List<Integer> heap;

    public BinaryHeap() {
        this(1);
    }

    public BinaryHeap(int size) {
        heap = new ArrayList<>(size);
    }

    public void add(int value) {
        heap.add(value);

        int index = heap.size()-1;
        siftUp(index);
    }

    public boolean remove(int value) {
        for (int i = 0; i < heap.size(); i++) {
            if (value == heap.get(i)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private int removeAt(int i) {
        if (heap.isEmpty()) return -1;

        int index = heap.size()-1;
        int remove = heap.get(i);
        swap(i, index);

        heap.remove(index);

        if (i == index) return remove;
        int elem = heap.get(i);

        siftDown(i);

        if (heap.get(i).equals(elem)) siftDown(i);
        return remove;
    }

    private boolean less(int i, int j) {
        int val1 = heap.get(i);
        int val2 = heap.get(j);
        return val1 - val2 <= 0;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void siftUp(int index) {
        int parent = (index-1)/2;

        while (index > 0 && less(index, parent)) {
            swap(parent, index);
            index = parent;

            parent = (index - 1 ) / 2;
        }
    }

    private void siftDown(int index) {

        while (true) {
            int left = 2*index+1;
            int right = 2*index+2;
            int smallest = left;

            if (right < heap.size() && less(right, left)) smallest = right;

            if (left >= heap.size() || less(index, smallest)) break;

            swap(smallest, index);
            index = smallest;
        }
    }

}
