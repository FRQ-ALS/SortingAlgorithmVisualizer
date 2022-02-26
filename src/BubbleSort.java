public class BubbleSort extends Thread {
    int[] numbers;
    ToolBox toolbox = new ToolBox();

    BubbleSort(int[] numbers) {
        this.numbers = numbers;
    }
    public void run() {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    try {
                        Thread.sleep(toolbox.getDelay());
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
    public int[] getNumbers() {
        return numbers;
    }
}
