#include <stdlib.h>
#include <stdio.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *insertAtFirst(struct Node *head, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = head;
    return newNode;
}

void insertAtLast(struct Node *head, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->data = value;
    newNode->next = NULL;
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

struct Node *removeAtFirst(struct Node *head)
{
    struct Node *temp = head;
    head = head->next;
    free(temp);
    return head;
}

void traverse(struct Node *head)
{
    while (head != NULL)
    {
        printf("%d ", head->data);
        head = head->next;
    }
}

int main(int argc, char const *argv[])
{
    struct Node *head = (struct Node *)malloc(sizeof(struct Node));
    head->data = 10;
    head->next = NULL;
    head = insertAtFirst(head, 20);
    insertAtLast(head, 30);
    insertAtIndex(head, 1, 55);
    traverse(head);

    printf("\n\n");
    head = removeAtFirst(head);
    traverse(head);
}
