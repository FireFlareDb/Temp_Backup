#include <stdio.h>
#include <stdlib.h>

struct student
{
    char *name;
    int age;
    int marks;
}S[5];

int main(int argc, char const *argv[])
{
    S[0].name = "fdfd";
    S[0].marks = 1;
    return 0;
}
