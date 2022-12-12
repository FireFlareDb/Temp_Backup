#include <stdio.h>
#include <stdlib.h>
#include "insertation.c"
#include "linear_search.c"

int main()
{
    int *A;
    int k = 5;
    A = (int *)malloc(k * sizeof(int));

    for (int i = 0; i < k; i++)
    {
        scanf("%d ", A + i);
    }

    // insertion_sort(A, k);
    linearSearch(A, k, 2);

    // for (int i = 0; i < k; i++)
    // {
    //     printf("%d \n", *A + i);
    // }
    return 0;
}


/*
Why Size = 5; Arr[Size] is not really needed when using malloc;
*/