public class Constructor1{
    public static void main(String[] args){
        Student s1 = new Student("Aadil" , 18);
        Student s2 = new Student(s1);
        System.out.println(s2.name);
        System.out.println(s2.age);
        s1.name = "Rahat";
        s1.age = 24;
        System.out.println(s2.name);
        System.out.println(s2.age);

    }
}


class Student {
    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }
}
