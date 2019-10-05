import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerEmployee {
    Scanner scanner = new Scanner(System.in);
    private static int numberOptions = 9;


    public Employee dataEmployee(){


        System.out.println("Write name");
        String name = scanner.nextLine();
        System.out.println("Write surname");
        String surname = scanner.nextLine();
        System.out.println("Write gender");
        char gender = scanner.next().charAt(0);
        System.out.println("Write section");
        int section = scanner.nextInt();
        System.out.println("Write salary");
        double salary = scanner.nextDouble();
        System.out.println("Write age");
        int age = scanner.nextInt();
        System.out.println("Write Number Child");
        int child = scanner.nextInt();
        System.out.println("Write Marital Status (true / false)");
        boolean isMarital = scanner.nextBoolean();
        System.out.println();

        return new Employee(name,surname,gender,section,salary,age,child,isMarital);

    }

    public int chooseScanner(String text){
        int choose;
        System.out.println(text);
        choose = scanner.nextInt();
        return choose;
    }

    public int chooseMenuScanner(String text, int from, int to){
        int choose;
        boolean flag = false;

        do {
            System.out.println(text);
            choose = scanner.nextInt();


            if (choose >= from && choose <= to) {
                System.out.println("Selected " + choose);

            } else {
                System.out.println("Write number " + from + " to " + to);
                flag = true;
            }


        }while(flag);

        return choose;
    }


}
