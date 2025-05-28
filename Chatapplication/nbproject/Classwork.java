package nbproject;

class Student {
    private String name;
    private int age;
    private char grade;

    // Default constructor
    public Student() {
        this.name = "SUJAL";
        this.age = 20;
        this.grade = 'A';
    }

    // Parameterized constructor
    public Student(String name, int age, char grade) {
        this.name = name;
        setAge(age);
        setGrade(grade);
    }

    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        this.grade = other.grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }

    // Setters
    public void setAge(int age) {
        if (age < 0) {
            this.grade = 'D'; // Requirement: set grade to 'D' if age is negative
        } else {
            this.age = age;
        }
    }

    public void setGrade(char grade) {
        if (grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D') {
            this.grade = grade;
        } else {
            this.grade = 'A'; // Default to A if invalid
        }
    }
}

public class Classwork {
    public static void main(String[] args) {
        // Create a Student object with parameterized constructor
        Student student1 = new Student("sujal", 18, 'B');

        // Print initial details
        System.out.println("Initial Student Details:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Grade: " + student1.getGrade());

        // Modify student details using setters
        student1.setAge(10);  // Invalid age — triggers grade = 'D'
        student1.setGrade('Z'); // Invalid grade — defaults to 'A'

        // Print updated details
        System.out.println("\nUpdated Student Details:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Grade: " + student1.getGrade());
    }
}
