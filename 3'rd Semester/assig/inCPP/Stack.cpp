#include <iostream>

using namespace std;

class Stack {
public:
    int top;
    int size;
    int *arr;

    Stack(int size) {
        this->top = -1;
        this->size = size;
        this->arr = new int[size];
    }

    bool isEmpty() {
        if (this->top == -1) {
            return true;
        }

        return false;
    }

    bool isFull() {
        if (this->top == this->size - 1) {
            return true;
        }

        return false;
    }

    void push(int val) {
        if (isFull()) {
            printf("StackOverflowed");
        } else {
            this->arr[++top] = val;
        }
    }

    int pop() {
        if (isEmpty()) {
            cout << "StackUnderflow" << endl;
            return -1;
        }
        return this->arr[top--];
    }

    int getSize() {
        return this->size;
    }

    int peek (int pos) {
        if (isEmpty()) {
            return -1;
        }
        return this->arr[this->top - pos + 1];
    }

    int getTop() {
        return this->top;
    }
};

//int main(int argc, char const *argv[]) {
//    Stack s = Stack(5);
//    s.push(1);
//    s.push(1);
//    s.push(1);
//    s.push(1);
//    s.push(1);
//    while (!s.isEmpty()) {
//        cout << s.pop() << endl;
//    }
//    return 0;
//}
