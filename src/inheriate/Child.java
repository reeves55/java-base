package inheriate;

/**
 * @author: xiao
 * @date: 2020/4/11
 */
public class Child extends Parent{
    String address;

    static {
        System.out.println("加载 Child 类");
    }

    void getParentProp() {
        System.out.println(name);
    }
}
