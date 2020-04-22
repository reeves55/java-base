package math_util;

/**
 * @author: xiao
 * @date: 2020/3/13
 */
public class MathUtil extends Parent{
    MathUtil() {
        super();
    }

    public void child() {
        super.parent();
    }

    public static void main(String[] args) {
        int b = 1069547520;
        System.out.printf("%x", b);

        float f = 1.5f;
        int a = Math.round(f);
        System.out.println(a);
    }
}

class Parent {
    public void parent() {

    }
}
