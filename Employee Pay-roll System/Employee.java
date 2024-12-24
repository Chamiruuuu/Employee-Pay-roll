public class Employee {
    private String name;
    private int employeeId; 
    private int hoursWork;  
    private double salary;

    public Employee(int employeeId, String name, int hoursWork, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWork = hoursWork;
        this.salary = salary;
    }

    public double calculatePay() {
        double hourlyRate = this.salary / 22 / 8;
        double overtimeRate = hourlyRate * 1.5;
        return this.hoursWork > 8 ? this.salary + ((this.hoursWork - 8) * overtimeRate): this.salary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeId() { 
        return this.employeeId;
    }

    public int getHoursWork() {
        return this.hoursWork;
    }

    public double getSalary() {
        return this.salary;
    }
}
