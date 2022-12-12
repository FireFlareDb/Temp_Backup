#include<stdio.h>
#include<string.h>

int exploitIP(char *argv[]) {
  int auth = 0;
  char sys_pass[10] = "Password";
  char user_pass[10];
  char temp_pass[10];

  strcpy(user_pass, argv[1]);
  strcpy(temp_pass, argv[2]);

  if(strcmp(sys_pass, user_pass) == 0 && strcmp(temp_pass, "ABDC") == 0) {
     auth = 1;
  }


  if (auth == 1) {
    printf("\n\nPassword Correct!\n\n");
  } else {
    printf("\n\nPassword Incorrect!\n\n");
  }
  
  return 0;
}
int main(int argc, char *argv[]) {
  exploitIP(argv);
  return 0;
}
