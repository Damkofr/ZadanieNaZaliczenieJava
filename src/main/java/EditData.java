import java.io.IOException;
import java.util.Scanner;

public class EditData {

    Scanner scanner = new Scanner(System.in);
    Menu menu;


    public void listEmployee() {
        int id = 0;
        for (Employee x : EmployeeLogic.getListEmployee()) {
            id++;
            System.out.println(id + "." + x.getName() + " " + x.getSurname() + " " + x.getGender() + " " + x.getSection() + " " + x.getSalary() +
                    " " + x.getAge() + " " + x.getNumberChild() + " " + x.isMaritalStatus());
        }
    }


    public void chooseEmployee() throws IOException {
        int chooseEmploye;
        int chooseData;
        Scanner sc = new Scanner(System.in);
        menu = new Menu();

        System.out.println("Write id employee to edit");
        chooseEmploye = sc.nextInt();

        String gender = String.valueOf(EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getGender());
        System.out.println("1.Name: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getName());
        System.out.println("2.Surname: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getSurname());
        System.out.println("3.Gender: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getGender());
        System.out.println("4.Section: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getSection());
        System.out.println("5.Salary: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getSalary());
        System.out.println("6.Age: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getAge());
        System.out.println("7.Number Child: " + EmployeeLogic.getListEmployee().get(chooseEmploye - 1).getNumberChild());
        System.out.println("8.Marital Status: " + ((EmployeeLogic.getListEmployee().get(chooseEmploye - 1).isMaritalStatus()
        ) ? "yes" : "No"));
        System.out.println("9 - EXIT TO MENU");


        do {
            chooseData = sc.nextInt();
            if (chooseData == 1 || chooseData == 6) {
                System.out.println("This Data is not editable!!!!");

            } else if (chooseData == 2 && !gender.equals("f")) {
                System.out.println("This Data is not editable!!!!");
            }

        } while (chooseData == 1 || chooseData == 6 || (chooseData == 2 && !gender.equals("f")));

        switch (chooseData) {
            case 3:
                System.out.println("You edit Gender, write new:");
                EmployeeLogic.getListEmployee().get(chooseEmploye - 1).setGender(sc.next().charAt(0));
                toNextChoose();
                break;
            case 4:
                System.out.println("You edit section, write new:");
                EmployeeLogic.getListEmployee().get(chooseEmploye - 1).setSection(sc.nextInt());
                toNextChoose();
                break;
            case 5:
                System.out.println("You edit salary, write new:");
                EmployeeLogic.getListEmployee().get(chooseEmploye - 1).setSalary(sc.nextInt());
                toNextChoose();
                break;
            case 7:
                System.out.println("You edit number child, write new:");
                EmployeeLogic.getListEmployee().get(chooseEmploye - 1).setNumberChild(sc.nextInt());
                toNextChoose();
                break;
            case 8:
                System.out.println("You edit marital status, write new:");
                EmployeeLogic.getListEmployee().get(chooseEmploye - 1).setMaritalStatus(sc.nextBoolean());
                toNextChoose();
                break;
            case 9:
                menu.controlMenu();
                break;
            default:
                System.out.println("There is no option!!");
                menu.controlMenu();
        }
    }

    private void toNextChoose() throws IOException {

        int choose;
        menu = new Menu();
        System.out.println("EDITED");
        System.out.println("1 - Edit data employee");
        System.out.println("2 - Exit to menu");
        choose = scanner.nextInt();
        if (choose == 1) {
            chooseEmployee();
        }
        else if(choose==2)
        {
            menu.controlMenu();
        }
        else
        {
            System.out.println("Incorrect choose. Movin to menu");
            menu.controlMenu();
        }

    }
}





