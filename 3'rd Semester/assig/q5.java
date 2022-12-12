public class q5 {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        Stack temp = new Stack(10);
        int removeCounter = 0;

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        while (!stack.isEmpty()) {
            int ele = stack.pop();
            if (ele % 2 != 0) {
                temp.push(ele);
            } else {
                removeCounter++;
            }
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.println("After Removing Even Integers");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\nTotal Even Integers Removed: " + removeCounter);
    }
}
