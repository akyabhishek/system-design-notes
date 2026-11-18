/**
 * Simple Abstract Factory Pattern Example
 * 
 * Problem: Create furniture sets (Chair + Table) for different styles (Modern, Victorian)
 * without mixing styles.
 */

// ===== WITHOUT ABSTRACT FACTORY (BAD WAY) =====

// Furniture classes
class ModernChair {
    void sitOn() { System.out.println("Sitting on Modern Chair"); }
}

class ModernTable {
    void putOn() { System.out.println("Putting items on Modern Table"); }
}

class VictorianChair {
    void sitOn() { System.out.println("Sitting on Victorian Chair"); }
}

class VictorianTable {
    void putOn() { System.out.println("Putting items on Victorian Table"); }
}

// Bad approach - client knows all concrete classes
class BadFurnitureClient {
    public static void createFurniture(String style) {
        // Problems:
        // 1. Client needs to know all concrete classes
        // 2. Can accidentally mix styles (Modern Chair + Victorian Table)
        // 3. Adding new style requires changing client code
        
        if (style.equals("modern")) {
            ModernChair chair = new ModernChair();
            ModernTable table = new ModernTable();
            chair.sitOn();
            table.putOn();
        }
        else if (style.equals("victorian")) {
            VictorianChair chair = new VictorianChair();
            VictorianTable table = new VictorianTable();
            chair.sitOn();
            table.putOn();
        }
    }
}

// ===== WITH ABSTRACT FACTORY (GOOD WAY) =====

// Abstract products
interface Chair {
    void sitOn();
}

interface Table {
    void putOn();
}

// Concrete products
class ModernChairGood implements Chair {
    @Override public void sitOn() { System.out.println("Sitting on Modern Chair"); }
}

class ModernTableGood implements Table {
    @Override public void putOn() { System.out.println("Putting items on Modern Table"); }
}

class VictorianChairGood implements Chair {
    @Override public void sitOn() { System.out.println("Sitting on Victorian Chair"); }
}

class VictorianTableGood implements Table {
    @Override public void putOn() { System.out.println("Putting items on Victorian Table"); }
}

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

// Concrete Factories
class ModernFurnitureFactory implements FurnitureFactory {
    @Override public Chair createChair() { return new ModernChairGood(); }
    @Override public Table createTable() { return new ModernTableGood(); }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override public Chair createChair() { return new VictorianChairGood(); }
    @Override public Table createTable() { return new VictorianTableGood(); }
}

// Client uses abstract types only - Pure Abstract Factory pattern implementation

// Client uses abstract types only - Example without factory provider (Option 2)
// This shows the pure Abstract Factory pattern without a factory provider
class GoodFurnitureClient {
    // Client receives the factory directly - no need for a provider
    public static void createFurniture(FurnitureFactory factory) {
        // Create furniture using the factory
        Chair chair = factory.createChair();
        Table table = factory.createTable();
        
        // Use the furniture (guaranteed to match styles)
        chair.sitOn();
        table.putOn();
    }
}

// Demo class
public class AbstractFactoryExample {
    public static void main(String[] args) {
        System.out.println("=== Without Abstract Factory (Bad approach) ===");
        BadFurnitureClient.createFurniture("modern");
        
        System.out.println("\n=== With Abstract Factory (Modern) ===");
        // Client works with factory directly - pure Abstract Factory pattern
        GoodFurnitureClient.createFurniture(new ModernFurnitureFactory());
        
        System.out.println("\n=== With Abstract Factory (Victorian) ===");
        // Client works with factory directly - pure Abstract Factory pattern
        GoodFurnitureClient.createFurniture(new VictorianFurnitureFactory());
    }
}