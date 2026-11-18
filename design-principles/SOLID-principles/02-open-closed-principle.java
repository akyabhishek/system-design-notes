// Open-Closed Principle (OCP)
// Classes should be open for extension but closed for modification
// This means you should be able to add new functionality without changing existing code

// BAD EXAMPLE - Violates Open-Closed Principle
class BadShapeCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width * rectangle.height;
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        // Adding new shapes requires modifying this method
        return 0;
    }
}

// GOOD EXAMPLE - Follows Open-Closed Principle
// Abstract base class that defines the contract
abstract class Shape {
    public abstract double calculateArea();
    //this class could be an interface as well
}

// Concrete implementations
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// New shape can be added without modifying existing code
class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Calculator class that works with any Shape
class GoodShapeCalculator {
    public double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

// Demo class to show the principle in action
public class OpenClosedPrincipleDemo {
    public static void main(String[] args) {
        System.out.println("=== Open-Closed Principle Demo ===\n");
        
        // Shape calculation example
        System.out.println("Shape Area Calculations:");
        Shape[] shapes = {
            new Rectangle(5, 3),
            new Circle(4),
            new Triangle(6, 4)
        };
        
        GoodShapeCalculator calculator = new GoodShapeCalculator();
        System.out.println("Total area: " + calculator.calculateTotalArea(shapes));
    }
}

/*
Key Points of Open-Closed Principle:

1. OPEN FOR EXTENSION: You can add new functionality by creating new classes
   - New shapes can be added by extending the Shape abstract class

2. CLOSED FOR MODIFICATION: Existing code doesn't need to be changed
   - GoodShapeCalculator doesn't need modification when adding Triangle

3. Benefits:
   - Reduces risk of breaking existing functionality
   - Makes code more maintainable and flexible
   - Enables polymorphism and runtime behavior selection

4. How to achieve OCP:
   - Use abstract classes and interfaces
   - Apply inheritance and polymorphism
   - Design with extension points in mind

This principle helps create robust, extensible systems that can grow
without requiring changes to existing, tested code.
*/