#include <stdio.h>
#include <stdlib.h>

struct stack
{
    int size;
    int top;
    int *arr;
};

int isEmpty(struct stack *ptr)
{
    if (ptr->top == -1)
    {
        return 1;
    }

    return 0;
}

int isFull(struct stack *ptr)
{
    if (ptr->top == ptr->size - 1)
    {
        return 1;
    }

    return 0;
}

void push(struct stack *ptr, int val)
{
    if (isFull(ptr))
    {
        printf("StackOverflow");
    }
    else
    {
        ptr->top++;
        ptr->arr[ptr->top] = val;
    }
}

int pop(struct stack *ptr)
{
    if (isEmpty(ptr))
    {
        printf("StackUnderflow");
        return -1;
    }
    else
    {
        int popInt = ptr->arr[ptr->top];
        ptr->top--;
        return popInt;
    }
}

int peek(struct stack *ptr, int pos)
{
    if (!isEmpty(ptr))
    {
        return ptr->arr[ptr->top - pos + 1];
    }

    return -1;
}

int main(int argc, char const *argv[])
{
    struct stack *s = (struct stack *)malloc(sizeof(struct stack));
    s->size = 5;
    s->top = -1;
    s->arr = (int *)malloc(s->size * sizeof(int));

    push(s, 2);
    push(s, 3);
    push(s, 1);
    push(s, 4);
    push(s, 5);

    printf("\nPeek: %d\n", peek(s, 2));

    printf("isFull: %d\n", isFull(s));
    printf("isEmpty: %d\n", isEmpty(s));

    return 0;
}
