#include <stdio.h>

int main(int argc, char const *argv[])
{

    int t, n, x, y, count = 0;
    scanf("%d", &t);

    for (int i = 0; i < t; i++)
    {
        scanf("%d %d %d", &n, &x, &y);
        int arr[n];

        for (int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }

        for (int i = 0; i < n; i++)
        {
            if (arr[i] <= x && arr[i] % y == 0)
            {
                count++;
            }
        }

        printf("%d", count);

        count = 0;
    }
    return 0;
}
