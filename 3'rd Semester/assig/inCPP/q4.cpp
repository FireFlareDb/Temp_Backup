#include <iostream>
#include "Stack.cpp"

int main() {
    int r;
    Stack s = Stack(5);
    int num = 100;

    while (num > 0) {
        r = num % 2;
        s.push(r);
        num = num / 2;
    }

    while (!(s.isEmpty())) {
        cout << s.pop() << endl;
    }
}