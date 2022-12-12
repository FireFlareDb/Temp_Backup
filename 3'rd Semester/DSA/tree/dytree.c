#include <stdio.h>
#include <stdlib.h>

struct Node *root;

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node *newNode(int data)
{
    struct Node *node = (struct Node *)malloc(sizeof(struct Node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

struct Node *insertNode(struct Node *parent, int data)
{
    if (parent == NULL)
    {
        return newNode(data);
    }

    if (parent->data > data)
    {
        // left
        parent->left = insertNode(parent->left, data);
    }
    else
    {
        // right
        parent->right = insertNode(parent->right, data);
    }

    return parent;
}

struct Node *minValue(struct Node *root)
{
    struct Node *tmp = root;
    while (tmp->left != NULL)
    {
        tmp = tmp->left;
    }
    return tmp;
}

struct Node *maxValue(struct Node *root)
{
    struct Node *tmp = root;
    while (tmp->right != NULL)
    {
        tmp = tmp->right;
    }
    return tmp;
}

struct Node *deleteNode(struct Node *root, int data)
{
    if (root == NULL)
    {
        return root;
    }

    if (root->data > data)
    {
        root->left = deleteNode(root->left, data);
    }
    else if (root->data < data)
    {
        root->right = deleteNode(root->right, data);
    }
    else
    {
        // 0 child
        if (root->left == NULL && root->right == NULL)
        {
            free(root);
            return NULL;
        }

        // 1 child

        // 1 child left
        if (root->left != NULL && root->right == NULL)
        {
            struct Node *tmp = root->left;
            free(root);
            return tmp;
        }

        // 1 child right
        if (root->left == NULL && root->right != NULL)
        {
            struct Node *tmp = root->right;
            free(root);
            return tmp;
        }

        // 2 child
        if (root->left != NULL && root->right != NULL)
        {
            int min = minValue(root->right)->data; // use this value to free
            root->data = min;
            root->right = deleteNode(root->right, min);
            return root;
        }
    }
}

void inOrder(struct Node *root)
{
    if (root == NULL)
    {
        return;
    }
    inOrder(root->left);
    printf("%d", root->data);
    inOrder(root->right);
}

int main(int argc, char const *argv[])
{
    root = (struct Node *)malloc(sizeof(struct Node));
    root->data = 5;
    root->left = NULL;
    root->right = NULL;

    insertNode(root, 6);
    insertNode(root, 1);
    insertNode(root, 8);

    inOrder(root);

    deleteNode(root, 8);

    printf("\n");
    inOrder(root);

    return 0;
}

// 5, 6, 1, 8   -> L N R

//      5
//    1   6
//          8
