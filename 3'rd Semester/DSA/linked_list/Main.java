public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(1);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertLast(12);
        list.insert(4, 3);

        list.display();
    }
}