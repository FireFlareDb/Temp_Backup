#include "Stack.cpp"
#include <iostream>
using namespace std;

void insertion_sort(int *a, int len)
{
    for (int i = 1; i < len; i++)
    {
        int current = a[i];
        int j = i - 1;
        while (a[j] > current && j >= 0)
        {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = current;
    }
}


int main() {
    int arr[] = { 20, 20, 30, 40, 50, 50, 50 };
    int n = sizeof arr / sizeof(int);
    int count = 0;

    insertion_sort(arr, n);

    for (int i = 0; i < n - 1; i++) {
        if (arr[i] != arr[i + 1]) {
            count++;
        }
    }

    count++;
    cout << count ;
}