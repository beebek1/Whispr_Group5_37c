package nbproject;

public class Main {
    public static void main(String[] args) {
        
        Employee e1 = new Employee("sujal purbey", 20);
        System.out.println("Employee Name: " + e1.getName());
        System.out.println("Employee Age: " + e1.getAge());

      
        Employee e2 = new Employee();
        System.out.println("Employee Name: " + e2.getName());
        System.out.println("Employee Age: " + e2.getAge());

    }
    
}
