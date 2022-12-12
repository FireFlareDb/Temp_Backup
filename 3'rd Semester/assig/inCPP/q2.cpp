#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main() {
   char str[] = "Hello World CPP";

   char *word = strtok(str, " ");

   while (word != NULL) {
       for (int i = strlen(word); i > 0; --i) {
           cout << word[i - 1];
       }
       cout << " ";
       word = strtok(NULL, " ");
   }
}