#include<stdio.h>
#include<string.h>

int add(char *argv[]) {
  char sys_pass[10] = "Password";
  char user_pass[10];
  char temp_pass[10];
  int auth = 0;

  strcpy(user_pass, argv[1]);
  strcpy(temp_pass, argv[2]);

  if(strcmp(sys_pass, user_pass) == 0) {
     auth = 1;
  }

  printf("\nValue sys_pass: %s", sys_pass);
  printf("\nValue user_pass: %s", user_pass);
  printf("\nValue temp_pass: %s", temp_pass);
  printf("\nValue auth: %d", auth);

  printf("\n\nAddress sys_pass: %p", sys_pass);
  printf("\nAddress usr_pass: %p", user_pass);
  printf("\nAddress tmp_pass: %p", temp_pass);
  printf("\nAddress auth: %p", &auth);
  printf("\n\n");

  if (auth == 1) {
    printf("\n\nPassword Correct!\n\n");
  }
  
  return 0;
}
int main(int argc, char *argv[]) {
  add(argv);
 
  return 0;
}
