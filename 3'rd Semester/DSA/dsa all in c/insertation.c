#include <stdio.h>

void printArray(int a[], int len)
{
    for (int i = 0; i < len; i++)
    {
        printf("%d ", a[i]);
    }
}

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

// int main(int argc, char const *argv[])
// {
//     int a[] = {5, 3, 7, 8, 1};
//     int len = sizeof(a) / sizeof(a[0]);

//     insertion_sort(a, len);
//     printArray(a, len);
//     return 0;
// }
