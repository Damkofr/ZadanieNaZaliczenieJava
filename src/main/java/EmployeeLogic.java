import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeLogic {

    private Scanner sc =new Scanner(System.in);
    ScannerEmployee se = new ScannerEmployee();

    private static List<Employee> listEmployee = new ArrayList<>();


    public static List<Employee> getListEmployee() {
        return listEmployee;
    }

    public static void setListEmployee(List<Employee> listEmployee) {
        EmployeeLogic.listEmployee = listEmployee;
    }

    public  void add(){

        listEmployee.add(se.dataEmployee());
    }

    public void showMinInfoAllEmployees(){
        for(Employee x:listEmployee)
        {
            System.out.println("Name: "+x.getName());
            System.out.println("Surname: "+x.getSurname());
            System.out.println("Salary: "+x.getSalary());
        }
    }

    public void exportToFile(){
        System.out.println("Write name file");
        String fileName = sc.nextLine();



        try (
                var fileWriter = new FileWriter(fileName);
                var writer = new BufferedWriter(fileWriter);
        ) {
            for(Employee x:listEmployee)
            {
                writer.write("Name: "+x.getName());
                writer.newLine();
                writer.write("Surname: "+x.getSurname());
                writer.newLine();
                writer.write("Gender: "+x.getGender());
                writer.newLine();
                writer.write("Section: "+x.getSection());
                writer.newLine();
                writer.write("Salary: "+x.getSalary());
                writer.newLine();
                writer.write("Age: "+ x.getAge());
                writer.newLine();
                writer.write("Number Child: "+x.getNumberChild());
                writer.newLine();
                writer.write("Marital Status"+((x.isMaritalStatus())?"Yes":"No"));
                writer.newLine();
                System.out.println("--------------------");
            }

        } catch (IOException e) {
            System.err.println("Save failed " + fileName);
        }

    }

    public void deleteEmployee(){
        int id = 0;
        int chooseId;
        for(Employee x:listEmployee){
            id++;
            System.out.println(id+"."+x.getName()+" "+x.getSurname());
        }

        System.out.println("Choose id to delete");
        chooseId = sc.nextInt();

        listEmployee.remove(chooseId-1);
    }

}
