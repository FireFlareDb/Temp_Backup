public class Stack {
    private static final int ERROR_CODE = -111111;
    private int size;
    private int top;
    private int[] arr;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public int getSize() {
        return size;
    }

    public int getTop() {
        return top;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (!isFull()) {
            arr[++top] = val;
        } else {
            System.out.println("\nStackOverflowed");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return arr[top--];
        } else {
            System.out.println("\nStackUnderflow");
            return ERROR_CODE;
        }
    }

    public int peek(int pos) {
        if (!isEmpty()) {
            return arr[top - pos + 1];
        }
        return ERROR_CODE;
    }
}
