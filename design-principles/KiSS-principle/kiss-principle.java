// KISS Principle - Keep It Simple, Stupid
// Simple code is better than complex code

// ======= EXAMPLE 1: SIMPLE VS COMPLEX LOGIC =======

// BAD - Unnecessarily complex
class BadAgeChecker {
    public String checkAge(int age) {
        return age >= 18 ? 
            (age >= 65 ? "Senior Adult" : "Adult") : 
            (age >= 13 ? "Teenager" : "Child");
    }
}

// GOOD - Simple and clear
class GoodAgeChecker {
    public String checkAge(int age) {
        if (age >= 65) return "Senior Adult";
        if (age >= 18) return "Adult";
        if (age >= 13) return "Teenager";
        return "Child";
    }
}

// ======= EXAMPLE 2: SIMPLE VS COMPLEX CALCULATION =======

// BAD - Complex one-liner
class BadCalculator {
    public int calculate(int a, int b, int c) {
        return ((a * 2) + (b * 3) - c) > 0 ? 
            ((a * 2) + (b * 3) - c) : 
            Math.abs((a * 2) + (b * 3) - c);
    }
}

// GOOD - Step by step
class GoodCalculator {
    public int calculate(int a, int b, int c) {
        int result = (a * 2) + (b * 3) - c;
        if (result < 0) {
            result = Math.abs(result);
        }
        return result;
    }
}

// ======= EXAMPLE 3: SIMPLE VS COMPLEX CONDITIONS =======

// BAD - Complex boolean logic
class BadValidator {
    public boolean isValid(String name, int age, String email) {
        return !(name == null || name.isEmpty()) && 
               !(age < 18 || age > 100) && 
               !(email == null || !email.contains("@"));
    }
}

// GOOD - Clear separate checks
class GoodValidator {
    public boolean isValid(String name, int age, String email) {
        if (name == null || name.isEmpty()) return false;
        if (age < 18 || age > 100) return false;
        if (email == null || !email.contains("@")) return false;
        return true;
    }
}

/*
KISS Principle - Simple Summary:

What is KISS?
- Keep It Simple, Stupid
- Simple code is easier to read, understand, and maintain
- Don't try to be clever if simple works

Why Simple is Better?
- Easier to understand
- Fewer bugs
- Easier to maintain
- Other developers can read it

How to Keep It Simple?
- Use clear variable names
- Break complex logic into steps
- Avoid nested ternary operators
- Use simple if-else instead of complex boolean logic
- Don't optimize until you need to

Remember: Code is written once but read many times.
Make it easy to read!
*/