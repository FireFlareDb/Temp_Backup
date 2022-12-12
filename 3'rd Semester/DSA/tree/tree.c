#include <stdio.h>

int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

void inOrder(int idx)
{
    // L N R
    int len = sizeof(arr) / sizeof(int);
    if (idx >= len)
    {
        return;
    }
    inOrder(2 * idx + 1);
    printf("%d", arr[idx]);
    inOrder(2 * idx + 2);
}

void preOrder(int idx)
{
    // N L R
    int len = sizeof(arr) / sizeof(int);
    if (idx >= len)
    {
        return;
    }
    printf("%d", arr[idx]);
    preOrder(2 * idx + 1);
    preOrder(2 * idx + 2);
}

void postOrder(int idx)
{
    // L R N
    int len = sizeof(arr) / sizeof(int);
    if (idx >= len)
    {
        return;
    }
    postOrder(2 * idx + 1);
    postOrder(2 * idx + 2);
    printf("%d", arr[idx]);
}

int main(int argc, char const *argv[])
{
    inOrder(0);
    printf("\n");
    preOrder(0);
    printf("\n");
    postOrder(0);
    return 0;
}
