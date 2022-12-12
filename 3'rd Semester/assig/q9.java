import java.util.Arrays;

public class q9 {
    public static void main(String[] args) {
        int[] arr = { 20, 20, 30, 40, 50, 50, 50 }; // Array Should Be Sorted
        Arrays.sort(arr);
       
        int n = arr.length;
        int count = 0;
        
        if (n < 2) {
            // return n;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
        }

        count++;
        System.out.println(count);
    }
}