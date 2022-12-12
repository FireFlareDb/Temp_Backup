#include <stdio.h>

void linearSearch(int *a, int len, int search) {
    for (int i = 0; i < len; i++) {
        if (*(a + i) == search) {
            printf("%d found at index %d\n", search, i);
            break;
        }
    }
}
