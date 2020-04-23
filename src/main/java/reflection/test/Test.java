package reflection.test;

import java.util.List;

public class Test extends Parent implements Interface{
    private String param1;
    private int param2;
    private List<Object> param3;

    private Test() { }
    public Test(String param) { }
    public Test(int param) { }

    private void privateMethod1() {}
    void protectMethod1(){}

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    public List<Object> getParam3() {
        return param3;
    }

    public void setParam3(List<Object> param3) {
        this.param3 = param3;
    }
}
