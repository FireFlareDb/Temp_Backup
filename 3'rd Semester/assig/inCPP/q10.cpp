#include "Stack.cpp"
#include <iostream>

using namespace std;

int main() {
    int mat1[3][4] = {{1, 2, 3, 6},
                    {4, 5, 6, 4},
                    {4, 5, 6, 4}};

    int mat2[3][3] = {{1, 2, 3},
                    {4, 5, 6},
                    {6, 7, 8}};


    int r1 = sizeof(mat1) / sizeof (mat1[0]);
    int r2 = sizeof(mat2) / sizeof (mat2[0]);
    int c2 = sizeof(mat2[0]) / sizeof(mat2[0][0]);

    if (r1 != c2) {
        cout << "Impossible, Even For Super Computers" << endl;
        exit(1);
    }

    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            int sum = 0;
            for (int k = 0; k < r2; k++) {
                sum = sum + mat1[i][k] * mat2[k][j];
            }
            cout << sum << " ";
        }
        cout << "\n";
    }
}