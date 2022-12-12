public class q6 {

    private static Stack duplicateStack(Stack stack) {
        int size = stack.getSize();
        Stack dulStack = new Stack(size);

        for (int i = stack.getTop() + 1; i > 0; i--) {
            dulStack.push(stack.peek(i));
        }
        return dulStack;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Stack dulStack = duplicateStack(stack);

        System.out.println("Original Stack");
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top: " + stack.getTop());
        System.out.print("Elements: ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\n");

        System.out.println("Duplicate Stack");
        System.out.println("Size: " + dulStack.getSize());
        System.out.println("Top: " + dulStack.getTop());
        System.out.print("Elements: ");

        while (!dulStack.isEmpty()) {
            System.out.print(dulStack.pop() + " ");
        }
    }

}
