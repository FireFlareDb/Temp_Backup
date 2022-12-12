#include <stdio.h>

int main(int argc, char const *argv[])
{
    int a[] = {3, 1, 5, 3, 1, 6};
    int n = sizeof a / sizeof a[0];
    int toFind = 5;
    int flag = 0, i = 0;

    for (i = 0; i < n; i++) {
        if (a[i] == toFind) {
            flag = 1;
            break;
        }
    }

    if (flag) {
        printf("Index: %d\n", i);
    } else {
        printf("Element Not Found");
    }

    return 0;
}
