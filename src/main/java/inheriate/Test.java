package inheriate;

/**
 * @author: xiao
 * @date: 2020/4/11
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("inheriate.Child");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
