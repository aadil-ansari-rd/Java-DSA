public class Constructor2{
    public static void main(String[] args){
        Student s1 = new Student("Aadil" , 18);
        s1.marks[0]=70;
        s1.marks[1]=80;
        s1.marks[2]=90;

        Student s2 = new Student(s1);
        System.out.println(s2.name);
        for(int num : s2.marks){
            System.out.print(num + " ");
        }
        System.out.println();

        s1.name = "Rahat";
        s1.marks[0]=40;
        s1.marks[1]=50;
        s1.marks[2]=60;

        System.out.println(s2.name);
        System.out.println(s2.name);
        for(int num : s2.marks){
            System.out.print(num + " ");
        }
    }
}


class Student {
    String name; int age;
    int[] marks;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        marks = new int[3];
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        marks = new int[3];
        this.marks = s.marks;
    }
}
