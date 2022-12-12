#include <stdio.h>

static int k;

void printArray(int *a, int length)
{
    for (int i = 0; i < length; i++)
    {
        printf("%d ", a[i]);
    }
}


int main(int argc, char const *argv[])
{
    int tmp;
    int a[] = {1, 2, 3, 4, 5};
    int n = sizeof a / sizeof a[0];

    for (int i = 0; i < n / 2; i++)
    {
        tmp = a[i];
        a[i] = a[n - i - 1];
        a[n - i - 1] = tmp;
    }

    printArray(a, n);

    return 0;
}
