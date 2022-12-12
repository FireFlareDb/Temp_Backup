#include "iostream"
#include "Stack.cpp"

Stack duplicateStack(Stack stack) {
    int size = stack.getSize();
    Stack dulStack = Stack(size);

    for (int i = stack.getTop() + 1; i > 0; i--) {
        dulStack.push(stack.peek(i));
    }
    return dulStack;
}

int main() {
    Stack stack = Stack(10);

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    Stack dulStack = duplicateStack(stack);

    cout << "Original Stack" << endl;
    cout << "Size: " << stack.getSize() << endl;
    cout << "Top: " << stack.getTop() << endl;
    cout << "Elements: ";

    while (!stack.isEmpty()) {
        cout << stack.pop() << " ";
    }

    cout << "\n\n";

    cout << "Duplicate Stack" << endl;
    cout << "Size: " << dulStack.getSize() << endl;
    cout << "Top: " << dulStack.getTop() << endl;
    cout << "Elements: ";

    while (!dulStack.isEmpty()) {
        cout << dulStack.pop() << " ";
    }
}