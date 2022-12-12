public class q8 {

    public static boolean findpl(String pl) {
        int len = pl.length();

        if (len < 2) {
            return true;
        }

        if (pl.charAt(0) != pl.charAt(len - 1)) {
            return false;
        }

        return findpl(pl.substring(1, len - 1));
    }

    public static void main(String[] args) {
        String pl = "noon";
        System.out.println(findpl(pl));
    }
}
