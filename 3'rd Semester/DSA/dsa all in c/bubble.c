#include <stdio.h>

void printArray(int a[], int len)
{
    for (int i = 0; i < len; i++)
    {
        printf("%d ", a[i]);
    }
}

void bubble_sort(int *a, int len)
{
    int flag;

    for (int j = 0; j < len; j++)
    {
        flag = 1;
        for (int i = 0; i < len - 1; i++)
        {
            if (a[i] > a[i + 1])
            {
                flag = 0;
                int temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;
            }
        }

        if (flag)
        {
            break;
        }
    }
}

int main(int argc, char const *argv[])
{
    int a[] = {5, 3, 7, 8, 1};
    int len = sizeof(a) / sizeof(a[0]);

    bubble_sort(a, len);
    printArray(a, len);
    return 0;
}
