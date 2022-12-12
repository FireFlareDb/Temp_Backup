public class dup {
  public static void du(int a[], int len) {

    // ------------- MAX -----------------

    int max = 0;
    
    for (int i = 0; i < len; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    // ------------- MAX Done -----------------

    int b[] = new int[max];

    for (int i = 0; i < len; i++) {
      b[a[i] - 1]++;
    }

    for (int i = 0; i < b.length; i++) {
      System.out.println(b[i]);
    }

  }

  public static void main(String args[]) {
    int a[] = { 7, 4, 2, 4, 1, 2 };
    int len = a.length;
    du(a, len);
  }
}
