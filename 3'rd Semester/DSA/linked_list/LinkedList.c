#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

void traverse(struct Node *head)
{
    while (head != NULL)
    {
        printf("%d -> ", head->data);
        head = head->next;
    }
}

struct Node *insertAtFirst(struct Node *head, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = head;
    return newNode;
}

void insertAtLast(struct Node *head, int value)
{
    int i = 0;
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    struct Node *temp = head;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    newNode->data = value;
    newNode->next = NULL;
    temp->next = newNode;
}

void insertAtIndex(struct Node *head, int index, int value)
{
    int i = 0;
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    struct Node *temp = head;

    while (i != index - 1)
    {
        temp = temp->next;
        i++;
    }
    newNode->data = value;
    newNode->next = temp->next;
    temp->next = newNode;
}


int mainn(int argc, char const *argv[])
{
    struct Node *head = (struct Node *)malloc(sizeof(struct Node));
    head->data = 10;
    head->next = NULL;

    head = insertAtFirst(head, -10);
    printf("\n");
    traverse(head);

    insertAtIndex(head, 1, 20);
    printf("\n");
    traverse(head);


    insertAtLast(head, 50);
    printf("\n");
    traverse(head);

    return 0;
}
