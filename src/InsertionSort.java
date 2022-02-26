public class InsertionSort extends Thread {
    int[] numbers;
    ToolBox toolBox = new ToolBox();

    InsertionSort(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        int n = numbers.length;
        for (int i = 1; i < n; ++i) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
                try {
                    Thread.sleep(toolBox.getDelay());
                } catch (InterruptedException e) {
                }
            }
            numbers[j + 1] = key;
        }
    }
    public int[] getNumbers() {
        return numbers;
    }
}
