package reflection;

import reflection.test.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Test test = new Test("");
        Class testClass = test.getClass();

        // 1. 获取一个类的所有声明的构造方法，private,protect,public 都能获取到
        Constructor<?>[] constructors = testClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toGenericString());
        }

        System.out.println("================================================");

        // 2. 获取类声明的所有方法，private,protect,public 都能获取到
        // 但是不会获取继承的父类的方法 也不会获取到 实现的接口的方法（接口允许有 default方法，这个时候实现类是不一定需要声明接口方法实现）
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toGenericString());
        }

        System.out.println("父类方法: ");
        for (Method method : testClass.getSuperclass().getDeclaredMethods()) {
            System.out.println(method.toGenericString());
        }

        System.out.println("接口方法: ");
        for (Class interfaceClass : testClass.getInterfaces()) {
            System.out.println(interfaceClass.getName() + "接口: ");
            for (Method method : interfaceClass.getDeclaredMethods()) {
                System.out.println(method.toGenericString());
            }
        }


    }
}
