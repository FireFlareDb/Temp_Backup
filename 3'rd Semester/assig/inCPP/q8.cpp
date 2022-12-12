#include "Stack.cpp"
#include <iostream>

using namespace std;

bool findpl(string plStr, int i) {
    if (i > plStr.size() / 2) {
        return true;
    }
    return plStr[i] == plStr[plStr.size() - i - 1] && findpl(plStr, i + 1);
}

int main() {
    char plStr[] = "noon";
    if(findpl(plStr, 0)) {
        cout << "Yes";
    } else {
        cout << "No";
    }
}