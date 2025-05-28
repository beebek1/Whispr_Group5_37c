package nbproject;
class Employee {
private String name;

public String getName() {
    return name;
  
}
public void setName(String name) {
    this.name = name;
}
private int age;
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}


public Employee (String name, int age) {
    this.name = name;
    this.age = age;
}
//default constructor or no-arg constructor
public Employee() {
    this.name = "sujal purbey";
    this.age = 20;
}
//copy constructor
public Employee(Employee e1) {
    this.name = e1.name;
    this.age = e1.age;
}
}
