import java.io.*;
import java.util.List;
import java.util.Scanner;

public class SerializesEmployees  {

    Scanner scanner = new Scanner(System.in);


    public void  ExportSerializesEmployees() {

        System.out.println("Write file name to export employees");
        String nameFile = scanner.nextLine();

        String fileName = nameFile+".obj";


        try(
                var fs = new FileOutputStream(fileName);
                var os = new ObjectOutputStream(fs)
        ) {
            for(Employee x: EmployeeLogic.getListEmployee()){
                os.writeObject(x);
            }
            System.out.println("Saved objects to file");

        } catch (
                IOException e) {
            System.err.println("Error saving the file " + fileName);
            e.printStackTrace();
        }
    }

    public void ImportSerializesEmployees() throws IOException {

        List<Employee> list = EmployeeLogic.getListEmployee();
        System.out.println("Write file name to import employees");
        String nameFile = scanner.nextLine();
        String fileName = nameFile + ".obj";


        ObjectInputStream input = null;
        try {
            FileInputStream fout = new FileInputStream(fileName);
            input = new ObjectInputStream(fout);


            Object obj = null;
            do {
                obj = input.readObject();
                if (obj != null) {
                    list.add((Employee) obj);
                }

            } while (obj != null);


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

        }

    }

}
