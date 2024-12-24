import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    WorkPlace workPlace = new WorkPlace();

    System.out.println("[1] -  Add Employee");
    System.out.println("[2] -  Delete Employee");
    System.out.println("[3] -  Show Employee");
    System.out.println("[4] -  Exit");

    System.out.println();
    


    while (true) {
        System.out.print("Enter option: ");
        String option = s.nextLine();
    
        try {
            int input = Integer.parseInt(option);
            switch (input) { 
                case 1 -> workPlace.addEmploye();
                case 2 -> workPlace.deleteEmploye();
                case 3 -> workPlace.showEmploye();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter valid number");
        }
            System.out.println();
        }
    }
} 

