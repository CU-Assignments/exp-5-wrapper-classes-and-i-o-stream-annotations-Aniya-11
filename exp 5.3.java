import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int employeeId;
    private String employeeName;
    private String designation;
    private double salary;

    
    public Employee(int employeeId, String employeeName, String designation, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.salary = salary;
    }

    
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeManagementSystem {

    private static final String FILE_NAME = "employees.ser";

    
    public static void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(employeeId, employeeName, designation, salary);

        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            oos.writeObject(newEmployee);
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    
    public static void displayAllEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Employee Details:");
            while (true) {
                Employee employee = (Employee) ois.readObject();
                employee.displayEmployeeDetails();
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employees found.");
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(); 
                    break;
                case 2:
                    displayAllEmployees(); 
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    System.exit(0);   
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
