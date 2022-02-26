public class MergeSort extends Thread {

    int[] numbers;
    ToolBox toolBox = new ToolBox();

    MergeSort(int[] numbers)
    {
        this.numbers = numbers;
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];  try {
            Thread.sleep(toolBox.getDelay());
        } catch (InterruptedException e) {
        }
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        try {
            Thread.sleep(toolBox.getDelay());
        } catch (InterruptedException e) {
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                try {
                    Thread.sleep(toolBox.getDelay());
                } catch (InterruptedException e) {
                }
                i++;
            } else {
                arr[k] = R[j];
                j++;
                try {
                    Thread.sleep(toolBox.getDelay());
                } catch (InterruptedException e) {
                }
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            try {
                Thread.sleep(toolBox.getDelay());
            } catch (InterruptedException e) {
            }
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
        try {
            Thread.sleep(toolBox.getDelay());
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        int n = numbers.length;
        sort(numbers, 0, n - 1);
    }

    public int[] getNumbers() {
        return numbers;
    }
}
