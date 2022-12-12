#include <stdio.h>

void printArray(int a[], int len)
{
    for (int i = 0; i < len; i++)
    {
        printf("%d ", a[i]);
    }
}

void selection_sort(int *a, int len)
{
    for (int i = 0; i < len; i++)
    {
        int min_idx = i;
        for (int j = i + 1; j < len; j++)
        {
            if (a[min_idx] > a[j])
            {
                min_idx = j;
            }
        }
        int temp = a[i];
        a[i] = a[min_idx];
        a[min_idx] = temp;
    }
}

int main(int argc, char const *argv[])
{
    int a[] = {5, 3, 7, 8, 1};
    int len = sizeof(a) / sizeof(a[0]);

    selection_sort(a, len);
    printArray(a, len);
    return 0;
}
