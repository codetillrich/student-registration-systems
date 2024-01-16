// Declare an abstract class named User
abstract class User {

    // Declare protected member variables for username and password
    protected String username;
    protected String password;

    // Constructor to initialize username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check login credentials
    public boolean login(String providedUsername, String providedPassword) {
        // Check if provided username and password match the object's credentials
        return username.equals(providedUsername) && password.equals(providedPassword);
    }

    // Override the equals method for comparing User objects
    @Override
    public boolean equals(Object obj) {
        // Check if the objects are the same reference
        if (this == obj) {
            return true;
        }
        // Check if the provided object is null or of a different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Cast the object to User and compare username and password
        User user = (User) obj;
        return username.equals(user.username) && password.equals(user.password);
    }

    // Override the toString method to provide a string representation of the User object
    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}
