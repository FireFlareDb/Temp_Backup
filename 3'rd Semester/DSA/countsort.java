public class countsort {

    public static int max(int[] a) {
        int len = a.length;
        int max = 0;

        for (int i = 0; i < len; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void count_sort(int[] a) {
        int count_arr[] = new int[max(a)];
        int new_arr[] = new int[5000];

        for (int i : a) {
            count_arr[i - 1] = count_arr[i - 1] + 1;
        }

        for (int i = 0; i < count_arr.length; i++) {
            // new_arr[i] = 
        }

        for (int i : count_arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 5, 1, 6, 1, 7 };
        count_sort(arr);
    }
}
