import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private String surname;
    private char gender;
    private int section;
    private double salary;
    private int age;
    private int numberChild;
    private boolean maritalStatus;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberChild(int numberChild) {
        this.numberChild = numberChild;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getGender() {
        return gender;
    }

    public int getSection() {
        return section;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getNumberChild() {
        return numberChild;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public Employee(String name, String surname, char gender, int section, double salary, int age, int numberChild, boolean maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.section = section;
        this.salary = salary;
        this.age = age;
        this.numberChild = numberChild;
        this.maritalStatus = maritalStatus;
    }

    public Employee(){

    }

    public void viewFullInformation(){
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("Gender: "+gender);
        System.out.println("Section: "+section);
        System.out.println("Salary: "+salary);
        System.out.println("Age: "+ age);
        System.out.println("Number Child: "+numberChild);
        System.out.println((maritalStatus==true)?"Yes":"No");
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", section=" + section +
                ", salary=" + salary +
                ", age=" + age +
                ", numberChild=" + numberChild +
                ", maritalStatus=" + maritalStatus +
                '}';
    }
}
