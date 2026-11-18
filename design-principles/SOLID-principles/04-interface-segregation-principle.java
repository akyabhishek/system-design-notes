// Interface Segregation Principle (ISP)
// Clients should not be forced to depend on interfaces they do not use

// BAD EXAMPLE - Violates Interface Segregation Principle
interface BadPrinter {
    void print();
    void scan();
    void fax();
}

class BadSimplePrinter implements BadPrinter {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
    
    @Override
    public void scan() {
        // Simple printer can't scan!
        throw new UnsupportedOperationException("Cannot scan");
    }
    
    @Override
    public void fax() {
        // Simple printer can't fax!
        throw new UnsupportedOperationException("Cannot fax");
    }
}

// GOOD EXAMPLE - Follows Interface Segregation Principle
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

class GoodSimplePrinter implements Printable {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
}

class GoodMultiFunctionPrinter implements Printable, Scannable, Faxable {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
    
    @Override
    public void scan() {
        System.out.println("Scanning document");
    }
    
    @Override
    public void fax() {
        System.out.println("Faxing document");
    }
}

/*
Key Points of Interface Segregation Principle (ISP):

1. DEFINITION: Clients should not be forced to depend on interfaces they do not use
   - Split large interfaces into smaller, more specific ones

2. BAD EXAMPLE ANALYSIS:
   - BadPrinter interface forces all printers to have print(), scan(), and fax()
   - BadSimplePrinter must implement methods it doesn't support

3. GOOD EXAMPLE ANALYSIS:
   - Separate interfaces: Printable, Scannable, Faxable
   - GoodSimplePrinter only implements what it can do
   - GoodMultiFunctionPrinter implements all interfaces it supports

4. Benefits of following ISP:
   - Classes only implement methods they actually use
   - Easier to maintain and extend
   - No forced implementation of unused methods

5. How to achieve ISP:
   - Break large interfaces into smaller, focused interfaces
   - Each interface should have a single responsibility
   - Use multiple interfaces when classes need multiple capabilities

This principle ensures interfaces are focused and don't force
unnecessary dependencies on implementing classes.
*/