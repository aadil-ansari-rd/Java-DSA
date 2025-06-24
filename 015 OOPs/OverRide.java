
class Parent {

    public void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    public void print() {
        System.out.println("Child");
    }
}

public class OverRide {

    public static void main(String[] args) {
        Parent ref = new Child();
        ref.print();

        Parent ref2 = new Parent();
        ref2.print();

        Child ref3 = new Child();
        ref3.print();

    }

}
