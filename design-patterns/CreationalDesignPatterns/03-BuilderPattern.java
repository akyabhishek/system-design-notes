/**
 * Builder Design Pattern Example
 * 
 * The Builder pattern separates the construction of a complex object from its 
 * representation, allowing the same construction process to create different
 * representations.
 */

/**
 * Bad Example: Class with complex constructor
 * Problems:
 * 1. Too many parameters make the constructor difficult to read and use
 * 2. Hard to remember the order of parameters
 * 3. Some parameters might be optional, leading to many constructor variations
 */
class PizzaWithoutBuilder {
    private String crust;
    private String sauce;
    private String cheese;
    private boolean pepperoni;
    private boolean mushroom;
    private boolean olive;
    private boolean onion;
    
    // Complex constructor with too many parameters
    public PizzaWithoutBuilder(String crust, String sauce, String cheese, 
                            boolean pepperoni, boolean mushroom, 
                            boolean olive, boolean onion) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushroom = mushroom;
        this.olive = olive;
        this.onion = onion;
    }
    
    @Override
    public String toString() {
        return "Pizza [crust=" + crust + ", sauce=" + sauce + ", cheese=" + cheese + 
               ", pepperoni=" + pepperoni + ", mushroom=" + mushroom + 
               ", olive=" + olive + ", onion=" + onion + "]";
    }
}

/**
 * Good Example: Class with Builder pattern
 * Benefits:
 * 1. Clear and readable code
 * 2. No need to remember parameter order
 * 3. Can set only the parameters we need, others use default values
 * 4. Immutable objects can be created easily
 */
class Pizza {
    // All final fields - immutable object
    private final String crust;
    private final String sauce;
    private final String cheese;
    private final boolean pepperoni;
    private final boolean mushroom;
    private final boolean olive;
    private final boolean onion;
    
    // Private constructor only accessible by Builder
    private Pizza(Builder builder) {
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushroom = builder.mushroom;
        this.olive = builder.olive;
        this.onion = builder.onion;
    }
    
    @Override
    public String toString() {
        return "Pizza [crust=" + crust + ", sauce=" + sauce + ", cheese=" + cheese + 
               ", pepperoni=" + pepperoni + ", mushroom=" + mushroom + 
               ", olive=" + olive + ", onion=" + onion + "]";
    }
    
    // Builder static class
    public static class Builder {
        // Required parameters
        private final String crust;
        
        // Optional parameters - initialized with default values
        private String sauce = "Tomato";
        private String cheese = "Mozzarella";
        private boolean pepperoni = false;
        private boolean mushroom = false;
        private boolean olive = false;
        private boolean onion = false;
        
        // Constructor with required parameters
        public Builder(String crust) {
            this.crust = crust;
        }
        
        // Methods to set optional parameters
        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }
        
        public Builder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }
        
        public Builder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }
        
        public Builder mushroom(boolean mushroom) {
            this.mushroom = mushroom;
            return this;
        }
        
        public Builder olive(boolean olive) {
            this.olive = olive;
            return this;
        }
        
        public Builder onion(boolean onion) {
            this.onion = onion;
            return this;
        }
        
        // build method to create the Pizza object
        public Pizza build() {
            return new Pizza(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Example ===");
        
        // Bad Example - Without Builder Pattern
        System.out.println("\n=== BAD EXAMPLE (Without Builder Pattern) ===");
        
        // Creating a pizza without builder - messy constructor with many parameters
        PizzaWithoutBuilder pizzaBad1 = new PizzaWithoutBuilder("Thin", "Tomato", "Mozzarella", 
                                                             true, true, false, true);
        System.out.println(pizzaBad1);
        
        // Hard to remember parameter order, prone to errors
        PizzaWithoutBuilder pizzaBad2 = new PizzaWithoutBuilder("Thick", "White Sauce", "Cheddar", 
                                                             false, true, true, false);
        System.out.println(pizzaBad2);
        
        // Good Example - With Builder Pattern
        System.out.println("\n=== GOOD EXAMPLE (With Builder Pattern) ===");
        
        // Creating a pizza with builder - clear, readable, and flexible
        Pizza pizzaGood1 = new Pizza.Builder("Thin")
                .sauce("Tomato")
                .cheese("Mozzarella")
                .pepperoni(true)
                .mushroom(true)
                .olive(false)
                .onion(true)
                .build();
        System.out.println(pizzaGood1);
        
        // Easy to understand what each parameter means
        // Can set only the parameters we need
        Pizza pizzaGood2 = new Pizza.Builder("Thick")
                .sauce("White Sauce")
                .cheese("Cheddar")
                .mushroom(true)
                .olive(true)
                .build(); // Pepperoni and onion will be false by default
        System.out.println(pizzaGood2);
    }
}
