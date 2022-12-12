class q10 {
    public static void main(String[] args) {
        int[][] mat1 = { { 1, 2, 3, 6 },
                { 4, 5, 6, 4 },
                { 4, 5, 6, 4 } };

        int[][] mat2 = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 6, 7, 8 } };
        // { 1, 2, 3 } };

        if (mat1[0].length != mat2.length) {
            System.out.println("Impossible For Computers");
            // return -1
        }

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < mat2.length; k++) {
                    // System.out.println(mat1[i][k] + " - " + mat2[k][j]);
                    // System.out.println(i + " " + k + " - " + k + " " + j);
                    sum = sum + mat1[i][k] * mat2[k][j];
                }
                System.out.print(sum + " ");
            }
            // break;
            System.out.println();
        }
    }
}

