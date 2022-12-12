#include "iostream"
#include "Stack.cpp"

int main() {
    Stack stack = Stack(10);
    Stack temp = Stack(10);
    int removeCounter = 0, ele;

    stack.push(7);
    stack.push(8);
    stack.push(9);
    stack.push(10);

    while (!stack.isEmpty()) {
        ele = stack.pop();
        if (ele % 2 != 0) {
            temp.push(ele);
        } else {
            removeCounter++;
        }
    }

    while (!temp.isEmpty()) {
        stack.push(temp.pop());
    }

    cout << "Total Even Integers Removed: " << removeCounter << endl;

    cout << "After Removing Even Integers" << endl;
    while (!stack.isEmpty()) {
        cout << stack.pop() << " ";
    }

}