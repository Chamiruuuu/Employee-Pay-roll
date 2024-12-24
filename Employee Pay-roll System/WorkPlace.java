import java.util.*;

public class WorkPlace {
    private ArrayList<Employee> employes;
    private ArrayList<Integer> employesId;

    public WorkPlace() {
        this.employes = new ArrayList<>();
        this.employesId = new ArrayList<>();
    }

    public void addEmploye() {
        Scanner s = new Scanner(System.in);
        String type;

        while (true) {
            System.out.print("What type of employee you want to add (Part time - Full time): ");
            type = s.nextLine().trim().toLowerCase();

            if (type.equals("parttime") || type.equals("fulltime")) {
                break;
            } else {
                System.out.println("Error: Invalid input. Please enter 'Part time' or 'Full time'.");
            }
        }

        System.out.println();

        switch (type) {
            case "parttime" -> {
                Employee employe;
                System.out.print("Enter employee name: ");
                String name = s.nextLine();

                while (true) {
                    System.out.print("Enter employee ID: ");
                    int employeId = s.nextInt();

                    if (employesId.contains(employeId)) {
                        System.out.println("Employee ID already exists. Please try again.");
                    } else {
                        employesId.add(employeId);
                        System.out.print("Enter employee Hours Worked: ");
                        int hours = s.nextInt();

                        System.out.print("Enter employee salary: ");
                        double salary = s.nextDouble();

                        employe = new PartTimeEmploye(name, employeId, hours, salary);
                        employes.add(employe);
                        System.out.println("Employee successfully added!");
                        break;
                    }
                }
            }

            case "fulltime" -> {
                Employee employe;
                System.out.print("Enter employee name: ");
                String name = s.nextLine();

                while (true) {
                    System.out.print("Enter employee ID: ");
                    int employeId = s.nextInt();

                    if (employesId.contains(employeId)) {
                        System.out.println("Employee ID already exists. Please try again.");
                    } else {
                        employesId.add(employeId);
                        System.out.print("Enter employee Hours Worked: ");
                        int hours = s.nextInt();

                        System.out.print("Enter employee salary: ");
                        double salary = s.nextDouble();

                        employe = new FullTimeEmploye(name, employeId, hours, salary);
                        employes.add(employe);
                        System.out.println("Employee successfully added!");
                        break;
                    }
                }
            }
        }
    }

    public void deleteEmploye() {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter ID to remove employee: ");
                int employeeId = s.nextInt();

                for (Employee employe : employes) {

                    if (employe.getEmployeeId() == employeeId) {
                        employes.remove(employe);
                        employesId.remove(Integer.valueOf(employeeId));
                        System.out.println("Employee successfully removed!");
                        return;
                    }
                }

                System.out.println("Employe Id not found");

            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid ID.");
            }
    }
}

    public void showEmploye() {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("What type of employee you want to show (All - Part time - Full time): ");
            String type = s.nextLine().trim().toLowerCase();
            boolean employeeFound = false;

            System.out.println();

            switch (type) {
                case "all" -> {
                    if (employes.isEmpty()) {
                        System.out.println("No employees found.");
                        return;
                    }

                    for (Employee employe : employes) {
                        System.out.println("Employee Details:");
                        System.out.println();
                        System.out.println("Employee ID: " + employe.getEmployeeId());
                        System.out.println("Employee Name: " + employe.getName());
                        System.out.println("Employee Hours Worked: " + employe.getHoursWork() + "hrs");
                        System.out.printf("Employee Salary: $%.2f%n", employe.getSalary());
                        System.out.printf("Employee Total Salary (With Overtime): $%.2f%n", employe.calculatePay());
                        System.out.println("---------------------------");
                    }
                    return;
                }

                case "parttime" -> {
                    for (Employee employe : employes) {
                        if (employe instanceof PartTimeEmploye) {
                            employeeFound = true;
                            System.out.println("Employee Details:");
                            System.out.println();
                            System.out.println("Employee ID: " + employe.getEmployeeId());
                            System.out.println("Employee Name: " + employe.getName());
                            System.out.println("Employee Hours Worked: " + employe.getHoursWork() + "hrs");
                            System.out.printf("Employee Salary: $%.2f%n", employe.getSalary());
                            System.out.printf("Employee Total Salary (With Overtime): $%.2f%n", employe.calculatePay());
                            System.out.println("---------------------------");
                        }
                    }
                    if (!employeeFound) {
                        System.out.println("No part-time employees found.");
                    }
                    return;
                }

                case "fulltime" -> {
                    for (Employee employe : employes) {
                        if (employe instanceof FullTimeEmploye) {
                            employeeFound = true;
                            System.out.println("Employee Details:");
                            System.out.println();
                            System.out.println("Employee ID: " + employe.getEmployeeId());
                            System.out.println("Employee Name: " + employe.getName());
                            System.out.println("Employee Hours Worked: " + employe.getHoursWork() + "hrs");
                            System.out.printf("Employee Salary: $%.2f%n", employe.getSalary());
                            System.out.printf("Employee Total Salary (With Overtime): $%.2f%n", employe.calculatePay());
                            System.out.println("---------------------------");
                        }
                    }
                    if (!employeeFound) {
                        System.out.println("No full-time employees found.");
                    }
                    return;
                }

                default -> System.out.println("Error: Invalid input. Please enter 'All', 'Part time', or 'Full time'.");
            }
        }
    }
}
