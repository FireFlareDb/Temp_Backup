#include <stdio.h>

void merge(int Arr[], int lb, int mid, int ub)
{
    int i = lb;
    int j = mid + 1;
    int k = lb;
    int Brr[200];

    while (i <= mid && j <= ub)
    {
        if (Arr[i] < Arr[j])
        {
            Brr[k] = Arr[i];
            i++;
            k++;
        }
        else
        {
            Brr[k] = Arr[j];
            j++;
            k++;
        }
    }

    while (i <= mid)
    {
        Brr[k] = Arr[i];
        k++;
        i++;
    }

    while (j <= ub)
    {
        Brr[k] = Arr[j];
        k++;
        j++;
    }

    for (int i = lb; i <= ub; i++)
    {
        Arr[i] = Brr[i];
    }
}

void mergesort(int Arr[], int lb, int ub)
{
    if (lb < ub)
    {
        int mid = (lb + ub) / 2;
        mergesort(Arr, lb, mid);
        mergesort(Arr, mid + 1, ub);
        merge(Arr, lb, mid, ub);
    }
}

void printArray(int *A, int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}

int main(int argc, char const *argv[])
{
    int arr[5] = {5, 3, 7, 1, 7};
    mergesort(arr, 0, 4);
    printArray(arr, 5);
    return 0;
}
