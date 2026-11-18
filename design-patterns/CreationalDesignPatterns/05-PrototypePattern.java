/**
 * Prototype Design Pattern Example
 * 
 * This file demonstrates:
 * 1. Bad Example - Not using Prototype pattern (direct creation)
 * 2. Good Example - Using Prototype pattern (cloning pre-configured objects)
 */

// ------------------- BAD EXAMPLE -------------------
// Problem: Creating complex objects from scratch each time

class EmployeeBad {
    private String name;
    private String role;
    private String department;
    private String[] permissions;
    private String emailSignature;
    
    // Creating a fully configured object from scratch each time is inefficient
    public EmployeeBad(String name, String role, String department) {
        System.out.println("Creating employee from scratch (expensive operation)");
        this.name = name;
        this.role = role;
        this.department = department;
        
        // Expensive operations for each new object
        this.setupDefaultPermissions();
        this.generateEmailSignature();
    }
    
    private void setupDefaultPermissions() {
        // Simulating a complex, expensive operation
        System.out.println("  - Setting up default permissions for " + role);
        if (role.equals("Manager")) {
            this.permissions = new String[] {"READ", "WRITE", "UPDATE", "DELETE", "APPROVE"};
        } else if (role.equals("Developer")) {
            this.permissions = new String[] {"READ", "WRITE", "UPDATE"};
        }
    }
    
    private void generateEmailSignature() {
        // Simulating another complex operation
        System.out.println("  - Generating email signature with company logo");
        this.emailSignature = name + " | " + role + " | " + department + " Department";
    }
    
    public void display() {
        System.out.println(name + " - " + role + " in " + department);
    }
}

// ------------------- GOOD EXAMPLE -------------------
// Solution: Create pre-configured objects once, then clone them

class Employee implements Cloneable {
    private String name;
    private String role;
    private String department;
    private String[] permissions;
    private String emailSignature;
    
    // Constructor for creating a fully configured prototype
    public Employee(String role, String department) {
        System.out.println("Creating " + role + " prototype (done once)");
        this.name = "Default";
        this.role = role;
        this.department = department;
        
        // Do the expensive setup once per prototype
        this.setupDefaultPermissions();
        this.generateEmailSignature();
    }
    
    private void setupDefaultPermissions() {
        // Complex operation - only done once per role
        System.out.println("  - Setting up default permissions for " + role);
        if (role.equals("Manager")) {
            this.permissions = new String[] {"READ", "WRITE", "UPDATE", "DELETE", "APPROVE"};
        } else if (role.equals("Developer")) {
            this.permissions = new String[] {"READ", "WRITE", "UPDATE"};
        }
    }
    
    private void generateEmailSignature() {
        // Another complex operation - only done once per role
        System.out.println("  - Generating email signature with company logo");
        this.emailSignature = name + " | " + role + " | " + department + " Department";
    }
    
    public void setName(String name) {
        this.name = name;
        // Just update the name in the signature, not regenerating the whole thing
        this.emailSignature = name + " | " + role + " | " + department + " Department";
    }
    
    public void display() {
        System.out.println(name + " - " + role + " in " + department);
    }
    
    // Clone method - copies the fully configured object quickly
    @Override
    public Employee clone() {
        System.out.println("Cloning " + role + " (fast operation)");
        Employee clone = null;
        try {
            clone = (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

// Client code
public class PrototypePattern {
    public static void main(String[] args) {
        // BAD EXAMPLE - Creating objects from scratch each time
        System.out.println("----- Bad Example -----");
        
        // Each creation runs all the expensive setup
        EmployeeBad manager1 = new EmployeeBad("John", "Manager", "Sales");
        EmployeeBad manager2 = new EmployeeBad("Jane", "Manager", "Marketing");
        EmployeeBad dev1 = new EmployeeBad("Bob", "Developer", "IT");
        
        manager1.display();
        manager2.display();
        dev1.display();
        
        // GOOD EXAMPLE - Create prototypes once, then clone
        System.out.println("\n----- Good Example -----");
        
        // Create fully configured prototypes (done once per role)
        Employee managerPrototype = new Employee("Manager", "Default");
        Employee developerPrototype = new Employee("Developer", "Default");
        
        // Clone the fully configured prototypes (fast operation)
        System.out.println("\nCreating actual employees by cloning:");
        Employee salesManager = managerPrototype.clone();
        salesManager.setName("John");
        
        Employee marketingManager = managerPrototype.clone();
        marketingManager.setName("Jane");
        
        Employee developer = developerPrototype.clone();
        developer.setName("Bob");
        
        // Display the results
        salesManager.display();
        marketingManager.display();
        developer.display();
    }
}