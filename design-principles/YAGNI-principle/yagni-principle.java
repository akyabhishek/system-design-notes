// YAGNI Principle - You Aren't Gonna Need It
// Don't build features until you actually need them

// ======= EXAMPLE 1: OVER-ENGINEERING =======

// BAD - Building features not needed yet
class BadUserManager {
    private String name;
    private String email;
    private String phone;        // Not needed yet
    private String address;      // Not needed yet
    private String companyName;  // Not needed yet
    private int creditScore;     // Not needed yet
    
    public BadUserManager(String name, String email) {
        this.name = name;
        this.email = email;
        // All other fields remain unused
    }
    
    // Methods for features not requested
    public void updateCreditScore(int score) { }
    public void setCompanyInfo(String company) { }
    public void addAddress(String addr) { }
}

// GOOD - Only what's needed now
class GoodUserManager {
    private String name;
    private String email;
    
    public GoodUserManager(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Only methods actually needed
    public String getName() { return name; }
    public String getEmail() { return email; }
}

// ======= EXAMPLE 2: PREMATURE OPTIMIZATION =======

// BAD - Complex caching not needed yet
class BadCalculator {
    private Map<String, Integer> cache = new HashMap<>();
    
    public int add(int a, int b) {
        String key = a + "+" + b;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result = a + b;
        cache.put(key, result);
        return result;
    }
}

// GOOD - Simple addition (caching not needed)
class GoodCalculator {
    public int add(int a, int b) {
        return a + b;
    }
}



/*
YAGNI Principle - Simple Summary:

What is YAGNI?
- You Aren't Gonna Need It
- Don't build features before you need them
- Focus on current requirements only

Why Follow YAGNI?
- Less code to maintain
- Faster development
- Avoid wasted effort
- Keep code simple

Common YAGNI Violations:
- Adding "future-proof" features
- Over-engineering simple solutions
- Adding unused parameters or methods

How to Follow YAGNI?
- Build only what's requested
- Add features when actually needed
- Start simple, then evolve
- Ask "Do I need this NOW?"

Remember: It's easier to add features later than to remove
unused code that's already tangled with the rest!
*/