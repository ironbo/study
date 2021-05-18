public class TestString {

    public static void main(String[] args) {
        String s1 = new StringBuilder().append("计算机").append("网络").toString();
        System.out.println(s1.intern() == s1);


        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
