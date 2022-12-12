#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Node *front = NULL;
struct Node *rear = NULL;

struct Node
{
    int data;
    struct Node *next;
};

void traverse()
{
    struct Node *temp = front;
    while (temp)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

void enQueue(int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        printf("Queue is full");
        return;
    }
    else
    {
        newNode->data = value;
        newNode->next = NULL;

        if (front == NULL)
        {
            rear = front = newNode;
        }
        else
        {
            rear->next = newNode;
            rear = newNode;
        }
    }
}

int deQueue()
{
    if (front == NULL)
    {
        printf("Queue is empty\n");
        return -1;
    }

    struct Node *temp = front;
    int value;

    front = temp->next;
    value = temp->data;
    free(temp);
    return value;
}

int main(int argc, char const *argv[])
{
    enQueue(1);
    enQueue(11);

    traverse();

    return 0;
}