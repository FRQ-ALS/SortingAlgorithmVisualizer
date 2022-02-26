public class QuickSort extends Thread {
    int[] numbers;
    static ToolBox toolBox = new ToolBox();

    QuickSort(int[] numbers) {
        this.numbers = numbers;
    }

    static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        try {
            Thread.sleep(toolBox.getDelay());
        } catch (InterruptedException e) {
        }
    }

    static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);
            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    public void run() {
        int n = numbers.length;
        quickSort(numbers, 0, n - 1);
    }

    public int[] getNumbers() {
        return numbers;
    }
}
