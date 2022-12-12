// Write a program from scratch that reverses the words in a sentence.

class q2 {
    public static void main(String[] args) {
        String str = "This is me";
        String[] strArr = str.split(" ");

        for (int i = 0; i < strArr.length; i++) {
            char[] word = strArr[i].toCharArray();
            for (int j = word.length - 1; j >= 0; j--) {
                System.out.print(word[j]);
            }
            System.out.print(" ");
        }
    }
}