// Noncompliant Example: Violates Single Responsibility Principle
class Employee {
    private String name;
    private String email;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void saveToDatabase() {
        // Code to save employee to database
    }

    public void sendEmail() {
        // Code to send email to employee
    }
}

// Compliant Example: Follows Single Responsibility Principle
class EmployeeData {
    private String name;
    private String email;

    public EmployeeData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
}

class EmployeeRepository {
    public void save(EmployeeData employee) {
        // Code to save employee to database
    }
}

class EmailService {
    public void sendEmail(EmployeeData employee) {
        // Code to send email to employee
    }
}

/*
Key Points of Single Responsibility Principle (SRP):

1. DEFINITION: A class should have only one reason to change
   - Each class should have only one job or responsibility

2. BAD EXAMPLE ANALYSIS:
   - Employee class handles data, database operations, and email operations
   - Has multiple reasons to change (data structure, database logic, email logic)

3. GOOD EXAMPLE ANALYSIS:
   - EmployeeData: Only responsible for holding employee data
   - EmployeeRepository: Only responsible for database operations
   - EmailService: Only responsible for email operations

4. Benefits of following SRP:
   - Easier to maintain, test, and modify code
   - Changes to one responsibility don't affect others
   - Better code organization and reusability

5. How to achieve SRP:
   - Break down large classes into smaller, focused classes
   - Identify different responsibilities within a class
   - Use composition to combine different responsibilities
   - Follow the "Do one thing and do it well" philosophy

This principle helps create clean, maintainable code where each class
has a single, well-defined purpose.
*/
