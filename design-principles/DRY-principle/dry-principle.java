// DRY Principle - Don't Repeat Yourself
// Write code once, use it many times

// ======= EXAMPLE 1: DUPLICATE METHODS =======

// BAD - Same code repeated
class BadCalculator {
    public int addTwoNumbers(int a, int b) {
        System.out.println("Adding numbers...");
        int result = a + b;
        System.out.println("Result: " + result);
        return result;
    }
    
    public int addThreeNumbers(int a, int b, int c) {
        System.out.println("Adding numbers...");
        int result = a + b + c;
        System.out.println("Result: " + result);
        return result;
    }
}

// GOOD - No repetition
class GoodCalculator {
    public int add(int... numbers) {
        System.out.println("Adding numbers...");
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        System.out.println("Result: " + result);
        return result;
    }
}

// ======= EXAMPLE 2: DUPLICATE VALIDATION =======

// BAD - Same validation repeated
class BadUserService {
    public void createUser(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        System.out.println("User created with email: " + email);
    }
    
    public void updateUser(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        System.out.println("User updated with email: " + email);
    }
}

// GOOD - Validation extracted to method
class GoodUserService {
    private void validateEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
    
    public void createUser(String email) {
        validateEmail(email);
        System.out.println("User created with email: " + email);
    }
    
    public void updateUser(String email) {
        validateEmail(email);
        System.out.println("User updated with email: " + email);
    }
}

// ======= EXAMPLE 3: DUPLICATE CONSTANTS =======

// BAD - Same values repeated
class BadConstants {
    public void processOrder() {
        double tax = 0.15; // Tax rate repeated
        System.out.println("Processing with tax: " + tax);
    }
    
    public void calculateTotal() {
        double tax = 0.15; // Same tax rate repeated
        System.out.println("Calculating with tax: " + tax);
    }
}

// GOOD - Constant defined once
class GoodConstants {
    private static final double TAX_RATE = 0.15;
    
    public void processOrder() {
        System.out.println("Processing with tax: " + TAX_RATE);
    }
    
    public void calculateTotal() {
        System.out.println("Calculating with tax: " + TAX_RATE);
    }
}

// ======= EXAMPLE 4: DUPLICATE TEXT/STRINGS =======

// BAD - Same error messages repeated
class BadValidationService {
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older to register");
        }
    }
    
    public void checkUserAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older to register");
        }
    }
    
    public void verifyAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older to register");
        }
    }
}

// GOOD - Error messages as constants
class GoodValidationService {
    private static final String AGE_ERROR_MESSAGE = "Age must be 18 or older to register";
    private static final int MIN_AGE = 18;
    
    public void validateAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
    }
    
    public void checkUserAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
    }
    
    public void verifyAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
    }
}

/*
DRY Principle - Simple Summary:

What is DRY?
- Don't Repeat Yourself
- Write code once, use it everywhere
- If you copy-paste code, you're probably doing it wrong

Types of Duplication:
1. Duplicate Methods - Same logic in different methods
2. Duplicate Validation - Same checks repeated
3. Duplicate Constants - Same values written multiple times
4. Duplicate Text/Strings - Same messages repeated
5. Duplicate Error Messages - Same error text everywhere

How to Fix:
- Extract common code into methods
- Use constants for repeated values
- Create helper methods for common operations
- Use loops instead of repeating similar code

Benefits:
- Easier to maintain (change once, fixes everywhere)
- Less bugs (no inconsistent copies)
- Smaller code size
- Easier to understand

Remember: If you change the same thing in multiple places,
you violated DRY principle!
*/