import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.lang.String.valueOf;
import static java.util.Comparator.comparing;

public class ExtraFunction {

    Scanner sc = new Scanner(System.in);
    Menu menu;


    public void numberOfEmployeesWithSalaryAbove() {
        System.out.println("Write salary: ");
        double salaryAbove = sc.nextDouble();
        int id = 0;
        for (Employee x : EmployeeLogic.getListEmployee()) {
            if (x.getSalary() > salaryAbove) {
                id++;
                System.out.println(id + "." + x.getName() + " " + x.getSurname() + " " + x.getGender() + " " + x.getSection() + " " + x.getSalary() +
                        " " + x.getAge() + " " + x.getNumberChild() + " " + x.isMaritalStatus());
            }
        }
    }


    public void averageSalaryInSection() {
        System.out.println("Write section: ");
        int section = sc.nextInt();
        int i = 0;
        double avgSalary = 0;
        for (Employee x : EmployeeLogic.getListEmployee()) {
            if (x.getSection() == section) {
                i++;
                avgSalary = avgSalary + x.getSalary();
            } else {
                System.out.println("Not Found Section");
            }
        }
        System.out.println("Average salary in section "+section+"is: "+(avgSalary/i));
    }

    public double averageSalaryInSection(int section) {
        System.out.println("Write section: ");
        int i = 0;
        double avgSalary = 0;
        for (Employee x : EmployeeLogic.getListEmployee()) {
            if (x.getSection() == section) {
                i++;
                avgSalary = avgSalary + x.getSalary();
            } else {
                System.out.println("Not Found Section");
            }
        }
        return avgSalary/i;
    }

    public void largestSalary() {
        Employee x = EmployeeLogic.getListEmployee().stream().max(comparing(Employee::getSalary)).get();
        System.out.println(x.getName() + " " + x.getSurname() + " " + x.getGender() + " " + x.getSection() + " " + x.getSalary() +
                " " + x.getAge() + " " + x.getNumberChild() + " " + x.isMaritalStatus());

    }

    public void showAllSection() {
        int male = 0;
        int female = 0;
        Set<Integer> list = new HashSet<>();
        for (Employee x : EmployeeLogic.getListEmployee()) {

            String a = valueOf(x.getGender());
            list.add(x.getSection());
            if (a.equals("f") || (a.equals(("F")))) {
                female++;
            } else if (a.equals("m") || (a.equals(("M")))) {
                male++;
            }
        }

        for (Integer i : list) {
            System.out.println("Section: " + i + " " + averageSalaryInSection(i));
        }

        if (male > female) {
            System.out.println("Male are more");
        } else if (female > male) {
            System.out.println("Female are more");
        } else {
            System.out.println("Male and Female it's the same");
        }
    }

    public void averageSalaryMaleToFemale() {
        double maleAvgSalary = 0;
        double femaleAvgSalary = 0;
        int female = 0;
        int male = 0;
        for (Employee x : EmployeeLogic.getListEmployee()) {
            String a = valueOf(x.getGender());
            if (a.equals("f") || (a.equals(("F")))) {
                femaleAvgSalary += x.getSalary();
                female++;
            } else if (a.equals("m") || (a.equals(("M")))) {
                maleAvgSalary += x.getSalary();
                male++;
            }
        }
        System.out.println("Average salary Female is: " + femaleAvgSalary / female + " Male is: " + maleAvgSalary / male);
    }

    public void increaseSalary(double i) {
        for (Employee x : EmployeeLogic.getListEmployee()) {
            x.setSalary(x.getSalary() * i);
        }
    }


    public void increaseSalary() {

        int procentage;
        System.out.println("Write how much % increase salary");
        procentage = sc.nextInt();
        procentage = (procentage / 100) + 1;

        for (Employee x : EmployeeLogic.getListEmployee()) {
            x.setSalary(x.getSalary() * procentage);
        }
    }

    public void sortEmployeeInFileBySurnameOrSalary() {
        int choose;
        System.out.println("1 - Sort surname");
        System.out.println("2 - Sort salary");
        choose = sc.nextInt();

        if(choose==1)
        {
            EmployeeLogic.getListEmployee().parallelStream().sorted().map(Employee::getSurname);
            System.out.println("Sorted surname");
        }
        else if(choose==2)
        {
            EmployeeLogic.getListEmployee().parallelStream().sorted().map(Employee::getSalary);
            System.out.println("Sorted salary");

        }
    }

    private int viewExtraFunctionMenu() {
        int choose;
        System.out.println("1 -- Number of employees with a salary a smaller sallary than...");
        System.out.println("2 -- Average salary in section");
        System.out.println("3 -- Largest salary");
        System.out.println("4 -- Average wages woman to man");
        System.out.println("5 -- Increase salary");
        System.out.println("6 -- Sort employees [surname or salary]");
        System.out.println("7 -- Number man to woman in section");

        System.out.println("Choose option");
        choose = sc.nextInt();
        return choose;
    }

    public void controlExtraFunction() throws IOException {

        int option = viewExtraFunctionMenu();
        menu = new Menu();

        switch (option) {
            case 1:
                numberOfEmployeesWithSalaryAbove();
                menu.controlMenu();
                break;
            case 2:
                averageSalaryInSection();
                menu.controlMenu();
                break;
            case 3:
                largestSalary();
                menu.controlMenu();
                break;
            case 4:
                averageSalaryMaleToFemale();
                menu.controlMenu();
                break;
            case 5:
                increaseSalary();
                menu.controlMenu();
                break;
            case 6:
                sortEmployeeInFileBySurnameOrSalary();
                menu.controlMenu();
                break;
            case 7:
                showAllSection();
                menu.controlMenu();
                break;
            default:
        }


    }
}