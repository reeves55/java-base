package method_invoke_bytecode;

/**
 * @author: xiao
 * @date: 2020/3/6
 */
public class Demo extends Parent implements MyInterface{
    private String param1;
    private static String staticParam;

    Demo(String param1) {
        this.param1 = param1;
    }

    public static void main(String[] args) {
        int flag = 1;
        switch (flag) {
            case 1:
                System.out.println("this is 1");
                break;
            case 2:
                System.out.println("this is 2");
                break;
            default:
                break;
        }



        int a = 0x00000000;
        System.out.println(a);
        a = 0x80000000;
        System.out.println(a);

        MyInterface x = () -> {
            System.out.println(staticParam);
        };

        String arg = "arg";
        Demo demo = new Demo("haha");
        staticMethod();

        demo.parentProperty = "parentProperty";

        demo.superParent();

        demo.privateMethod();

        demo.parentMethod(arg);

        MyInterface myInterface = demo;
        myInterface.interfaceMethod();
    }



    public static void staticMethod() {
        System.out.println("我是静态方法");
    }

    private void privateMethod() {
        System.out.println("我是私有方法");
    }

    @Override
    public void parentMethod(String arg) {
        System.out.println("我是重写的子类方法" + arg);
    }

    @Override
    public void interfaceMethod() {
        System.out.println("我是接口实现方法");
    }
}

class Parent extends SuperParent{
    protected String parentProperty;

    public void parentMethod(String arg) {
        System.out.println("我是父方法");
    }
}


class SuperParent {
    public void superParent() {
        System.out.println("我是超级父类方法");
    }
}

interface MyInterface {
    public void interfaceMethod();
}
