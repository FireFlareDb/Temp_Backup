#include <stdio.h>
#include <stdlib.h>

void type_one() {
    int size = 5;
    int *arr;

    arr = (int *)malloc(size * sizeof(int));

    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    printf("\n\n");

    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
}

void type_two() {
    int size = 5;
    int *arr;

    arr = (int *)malloc(size * sizeof(int));

    for (int i = 0; i < size; i++) {
        scanf("%d", arr + i);
    }

    printf("\n\n");

    for (int i = 0; i < size; i++) {
        printf("%d ", *(arr + i));
    }
}

int main(int argc, char const *argv[]) {
    // type_one();
    // type_two();
    return 0;
}

/*

Anybody please can explain what the difference between these two ways of taking array inputs.

And, Which one is the right way to do? I've been using type_one till now but now i think it should have been the second `type_two` way.

*/