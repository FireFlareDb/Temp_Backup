#include <stdio.h>

int main(int argc, char const *argv[])
{
    int n, counter = 0;
    scanf("%d", &n);

    int x[n];
    int y[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &x[i]);
        scanf("%d", &y[i]);
    }

    int xd = x[0] - x[1];
    int yd = y[0] - y[1];

    if (xd < 0)
    {
        xd = 0 - xd;
    }

    if (yd < 0)
    {
        yd = 0 - yd;
    }

    for (int j = 0; j < n; j++)
    {
        if (((x[0] - x[j]) % xd == 0) && ((y[0] - y[j]) % yd == 0))
        {
            counter++;
        }
    }

    printf("%d", counter);
    return 0;
}
