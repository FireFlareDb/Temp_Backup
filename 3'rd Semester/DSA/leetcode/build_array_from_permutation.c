#include <stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int nums[] = {0, 2, 1, 5, 3, 4};
    int numsSize = 6;
    int *ans = (int *)malloc(numsSize * sizeof(int));

    for (int i = 0; i < numsSize; i++)
    {
        ans[i] = nums[nums[i]];
    }

    return ans;
}
