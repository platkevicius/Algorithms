package sorting;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] numbers = new int[]{5, 2, 1, 54, 10, 12};
        int[] sorted = selectionSort.sort(numbers);

        for (int i = 0; i < numbers.length; i++)
            System.out.println(sorted[i]);
    }

    public int[] sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = i;

            while ((j > 0) && (numbers[j] < numbers[j-1])) {
                int temp = numbers[j];
                numbers[j] = numbers[j-1];
                numbers[j-1] = temp;

                j--;
            }
        }

        return numbers;
    }
}
