
public class q4 {
    public static void main(String[] args) {
        Stack stack = new Stack(20);

        int num = 10;

        while (num > 0) {
            int r = num % 2;
            stack.push(r);
            num = num / 2;
        }

        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
