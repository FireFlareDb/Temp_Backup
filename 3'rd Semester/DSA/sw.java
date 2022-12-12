import java.util.Scanner;

class sw {
    public static void bubble(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selection(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertsion(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Length: ");
        final int arr_len = sc.nextInt();
        int arr[] = new int[arr_len];
        System.out.println("");

        for (int i = 0; i < arr_len; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("");

        boolean flag = true;
        // int arr[] = { 5, 3, 5, 1, 6, 1, 7 };

        while (flag) {
            System.out.println("");
            System.out.println("""
                    1. Bubble Sort
                    2. Selection Sort
                    3. Insertion Sort
                    4. Quick Sort
                    0. Exit
                    """);
            System.out.print("> ");
            final int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bubble(arr);
                    printArray(arr, arr.length);
                    break;
                case 2:
                    selection(arr);
                    printArray(arr, arr.length);
                    break;
                case 3:
                    insertsion(arr);
                    printArray(arr, arr.length);
                    break;
                case 4:
                    quickSort(arr, 0, arr.length - 1);
                    printArray(arr, arr.length);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("\nSolved By Default");
                    bubble(arr);
                    printArray(arr, arr.length);
                    break;
            }
        }
        sc.close();
    }
}
