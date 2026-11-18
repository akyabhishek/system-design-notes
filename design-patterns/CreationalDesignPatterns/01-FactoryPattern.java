/**
 * Factory Design Pattern Example - Optimized Version
 */

// ===== BAD IMPLEMENTATION (without Factory Pattern) =====

// Product classes with duplicate functionality
class Circle {
    public void draw() { System.out.println("Drawing a Circle"); }
}

class Rectangle {
    public void draw() { System.out.println("Drawing a Rectangle"); }
}

class Triangle {
    public void draw() { System.out.println("Drawing a Triangle"); }
}

// Client code tightly coupled with concrete classes
class BadExample {
    public static void main(String[] args) {
        // Problem 1: Direct instantiation - tight coupling
        String type = "CIRCLE";
        Object shape;
        
        // Problem 2: Complex conditional creation logic
        if (type.equals("CIRCLE")) shape = new Circle();
        else if (type.equals("RECTANGLE")) shape = new Rectangle();
        else if (type.equals("TRIANGLE")) shape = new Triangle();
        else throw new IllegalArgumentException("Unknown shape: " + type);
        
        // Problem 3: Type casting required
        if (shape instanceof Circle) ((Circle) shape).draw();
    }
}

// ===== GOOD IMPLEMENTATION (with Factory Pattern) =====

// Common interface
interface Shape {
    void draw();
}

// Concrete implementations
class CircleGood implements Shape {
    @Override public void draw() { System.out.println("Drawing a Circle"); }
}

class RectangleGood implements Shape {
    @Override public void draw() { System.out.println("Drawing a Rectangle"); }
}

class TriangleGood implements Shape {
    @Override public void draw() { System.out.println("Drawing a Triangle"); }
}

// Factory class centralizes creation logic
class ShapeFactory {
    public Shape createShape(String type) {
        if (type == null) return null;
        
        switch (type.toUpperCase()) {
            case "CIRCLE": return new CircleGood();
            case "RECTANGLE": return new RectangleGood();
            case "TRIANGLE": return new TriangleGood();
            default: return null;
        }
    }
}

// Client code is decoupled from concrete classes
class GoodExample {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        
        // No type casting, no complex conditionals
        Shape circle = factory.createShape("CIRCLE");
        circle.draw();
        
        factory.createShape("RECTANGLE").draw();
    }
}

// Demo class
public class FactoryPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Bad Implementation ===");
        BadExample.main(args);
        
        System.out.println("\n=== Good Implementation ===");
        GoodExample.main(args);
    }
}