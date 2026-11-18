// Liskov Substitution Principle (LSP)
// Objects of a superclass should be replaceable with objects of its subclasses
// without breaking the application

// BAD EXAMPLE - Violates Liskov Substitution Principle
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        // Penguins can't fly! This violates LSP
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
}

// GOOD EXAMPLE - Follows Liskov Substitution Principle
abstract class BirdBase {
    public abstract void move();
    public abstract void eat();
}

class FlyingBird extends BirdBase {
    public void fly() {
        System.out.println("Flying bird is soaring");
    }
    
    @Override
    public void move() {
        fly();
    }
    
    @Override
    public void eat() {
        System.out.println("Bird is eating seeds");
    }
}

class SwimmingBird extends BirdBase {
    public void swim() {
        System.out.println("Swimming bird is diving");
    }
    
    @Override
    public void move() {
        swim();
    }
    
    @Override
    public void eat() {
        System.out.println("Bird is eating fish");
    }
}

class GoodEagle extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Eagle soars majestically");
    }
}

class GoodPenguin extends SwimmingBird {
    @Override
    public void swim() {
        System.out.println("Penguin swims gracefully underwater");
    }
}

// Demo class to show the principle in action
public class LiskovSubstitutionPrincipleDemo {
    // This method works with any BirdBase and its subclasses
    public static void makeBirdMove(BirdBase bird) {
        bird.move(); // Works correctly for all subclasses
        bird.eat();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle Demo ===\n");
        
        System.out.println("Flying birds:");
        BirdBase eagle = new GoodEagle();
        makeBirdMove(eagle);
        
        System.out.println("\nSwimming birds:");
        BirdBase penguin = new GoodPenguin();
        makeBirdMove(penguin);
        
        // Both subclasses can be used interchangeably
        // without breaking the application
    }
}

/*
Key Points of Liskov Substitution Principle:

1. DEFINITION: Subtypes must be substitutable for their base types
   - Child classes should be able to replace parent classes without issues
   - The behavior of the program should remain correct

2. BAD EXAMPLE ANALYSIS:
   - Penguin extends Bird but cannot fly
   - Replacing Bird with Penguin breaks the application (throws exception)
   - Violates the contract that all Birds can fly

3. GOOD EXAMPLE ANALYSIS:
   - BirdBase defines common behavior (move, eat)
   - FlyingBird and SwimmingBird specialize the movement
   - All subclasses can be used interchangeably in makeBirdMove()
   - No unexpected exceptions or broken behavior

4. Benefits of following LSP:
   - Ensures reliable inheritance hierarchies
   - Prevents unexpected runtime errors
   - Makes code more predictable and maintainable
   - Enables true polymorphism

5. How to achieve LSP:
   - Design base classes with appropriate abstractions
   - Ensure subclasses don't weaken preconditions
   - Ensure subclasses don't strengthen postconditions
   - Avoid throwing new exceptions in overridden methods
   - Make sure substitutions work in all contexts

LSP ensures that inheritance is used correctly and that polymorphism
works as expected without surprises.
*/