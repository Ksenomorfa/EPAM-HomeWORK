package testing;

public class TestTypeMethod implements Cloneable  {
    Number method() {
        return 1;
    }

    Long method(int a) {
        return 1l;
    }
    public TestTypeMethod clone() throws CloneNotSupportedException {
        TestTypeMethod type = (TestTypeMethod) super.clone();
        return type;
    }
}

class TestTypeMethodChild extends TestTypeMethod {
    Integer method() {

        return  1;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Object object = new Object();
        //Object object2 = object.clone();
        TestTypeMethod type = new TestTypeMethod();
        TestTypeMethod type2   = type.clone();
        System.out.println(type == type2);
    }
}
