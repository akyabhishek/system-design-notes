/**
 * Singleton Design Pattern Example
 * 
 * This file demonstrates:
 * 1. Bad Example - Not using Singleton pattern (multiple instances)
 * 2. Good Example - Proper Singleton implementation (single instance)
 */

// ------------------- BAD EXAMPLE -------------------
// Problem: Multiple instances can be created, wasting resources
// and potentially causing inconsistent behavior

class DatabaseConnection {
    private String connectionUrl;
    
    public DatabaseConnection(String url) {
        // Assume this is an expensive operation (opening a connection)
        System.out.println("Creating a new database connection to: " + url);
        this.connectionUrl = url;
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on connection: " + connectionUrl);
    }
}

// ------------------- GOOD EXAMPLE -------------------
// Solution: Singleton pattern ensures only one instance exists

class SingletonDatabaseConnection {
    // The single instance is stored in a static variable
    private static SingletonDatabaseConnection instance;
    
    private String connectionUrl;
    
    // Private constructor prevents instantiation from outside
    private SingletonDatabaseConnection(String url) {
        System.out.println("Creating the singleton database connection to: " + url);
        this.connectionUrl = url;
    }
    
    // Public static method to get the single instance
    public static SingletonDatabaseConnection getInstance(String url) {
        // Create the instance only if it doesn't exist
        if (instance == null) {
            instance = new SingletonDatabaseConnection(url);
        }
        return instance;
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on singleton connection: " + connectionUrl);
    }
}

// ------------------- THREAD-SAFE SINGLETON -------------------
// A more robust implementation for multi-threaded environments

class ThreadSafeSingletonDatabaseConnection {
    // volatile ensures visibility across threads
    private static volatile ThreadSafeSingletonDatabaseConnection instance;
    
    private String connectionUrl;
    
    private ThreadSafeSingletonDatabaseConnection(String url) {
        System.out.println("Creating the thread-safe singleton connection to: " + url);
        this.connectionUrl = url;
    }
    
    // Double-checked locking pattern
    public static ThreadSafeSingletonDatabaseConnection getInstance(String url) {
        // Check 1 (no lock)
        if (instance == null) {
            // Synchronize only when instance might be null
            synchronized (ThreadSafeSingletonDatabaseConnection.class) {
                // Check 2 (with lock)
                if (instance == null) {
                    instance = new ThreadSafeSingletonDatabaseConnection(url);
                }
            }
        }
        return instance;
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on thread-safe singleton connection: " + connectionUrl);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println("\n----- Bad Example (Non-Singleton) -----");
        // Problem: Creating multiple instances
        DatabaseConnection conn1 = new DatabaseConnection("jdbc:mysql://localhost/db");
        DatabaseConnection conn2 = new DatabaseConnection("jdbc:mysql://localhost/db");
        
        // These are two different objects consuming resources
        conn1.executeQuery("SELECT * FROM users");
        conn2.executeQuery("SELECT * FROM products");
        
        System.out.println("Are connections the same object? " + (conn1 == conn2));
        
        System.out.println("\n----- Good Example (Singleton) -----");
        // Solution: Only one instance is created
        SingletonDatabaseConnection singleConn1 = SingletonDatabaseConnection.getInstance("jdbc:mysql://localhost/db");
        SingletonDatabaseConnection singleConn2 = SingletonDatabaseConnection.getInstance("jdbc:mysql://localhost/db");
        
        // These are the same object, conserving resources
        singleConn1.executeQuery("SELECT * FROM users");
        singleConn2.executeQuery("SELECT * FROM products");
        
        System.out.println("Are singleton connections the same object? " + (singleConn1 == singleConn2));
    }
}
