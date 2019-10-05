import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    EmployeeLogic employeeLogic = new EmployeeLogic();
    ScannerEmployee scannerEmployee = new ScannerEmployee();
    Scanner sc = new Scanner(System.in);
    SerializesEmployees serializesEmployees = new SerializesEmployees();
    EditData editData = new EditData();
    static int numberChooseMainMenu = 9;


    public static void viewMenu(){
        System.out.println("1 -- Show all employees");
        System.out.println("2 -- Add new employee");
        System.out.println("3 -- Export to file");
        System.out.println("4 -- Delete employee");
        System.out.println("5 -- Edit employee");
        System.out.println("6 -- Extra function");
        System.out.println("7 -- Function files");
        System.out.println("8 -- About program");
        System.out.println("9 -- Exit program");

    }

    public  void controlMenu() throws IOException {

            viewMenu();
            int option = scannerEmployee.chooseMenuScanner("Write omenu optiom",0,numberChooseMainMenu);
            String tittle = "You selected " + option;
            switch (option) {
                case 1:

                    System.out.println(tittle);
                    employeeLogic.showMinInfoAllEmployees();
                    scannerEmployee.chooseScanner("Write any key to exit menu");
                    controlMenu();
                    break;

                case 2:
                    System.out.println(tittle);
                    int choose;
                    do {
                        employeeLogic.add();
                        System.out.println("1 - Add next employee");
                        System.out.println("2 - Exit to menu");
                        choose = scannerEmployee.chooseScanner("");
                        if ((choose == 2)) {
                            controlMenu();
                        }
                        else if(choose==1){
                            System.out.println("Add next employee");
                        }
                        else {
                            System.out.println("Nie poprawna liczba");
                        }
                    }while(choose==1);

                    break;
                case 3:
                    int chooseSerial;
                    do {
                        System.out.println("1 - Import Employees");
                        System.out.println("2 - Export Employees");
                        System.out.println("3 - Exit to menu");
                        chooseSerial = scannerEmployee.chooseScanner("");
                        if (chooseSerial == 3) {
                            controlMenu();
                        } else if (chooseSerial == 1) {
                            serializesEmployees.ImportSerializesEmployees();
                        } else if (chooseSerial == 2) {
                            serializesEmployees.ExportSerializesEmployees();
                        } else {
                            System.out.println("Niepoprawna liczba");
                        }
                    }while(chooseSerial!=3);

                    break;
                case 4:
                    System.out.println(tittle);
                    int choose1;
                    do {
                        employeeLogic = new EmployeeLogic();
                        employeeLogic.deleteEmployee();
                        System.out.println("1 - Delete next employee");
                        System.out.println("2 - Exit to menu");
                        choose1 = sc.nextInt();
                        if ((choose1 == 2)) {
                            controlMenu();
                        } else {
                            System.out.println("Incorrect number ");
                        }
                    }while(choose1==1);
                    break;
                case 5:
                    System.out.println(tittle);
                    editData.listEmployee();
                    editData.chooseEmployee();

                    break;
                case 6:
                    System.out.println(tittle);
                    ExtraFunction extraFunction = new ExtraFunction();
                    extraFunction.controlExtraFunction();
                    controlMenu();
                    break;
                case 7:
                    System.out.println(tittle);
                    employeeLogic = new EmployeeLogic();
                    employeeLogic.exportToFile();
                    System.out.println("Save to file");
                    controlMenu();
                    break;
                case 8:
                    System.out.println(tittle);
                    break;
                case 9:
                    System.out.println(tittle);
                    break;
                case 0:
                    System.out.println(tittle);
                    System.exit(1);
                    break;

                default: {
                    System.out.println("default");
                }
            }

    }



}
