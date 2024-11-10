package data;

/**
 * UserData is a Data Transfer Object (DTO) class to hold user data for use in tests.
 * This class stores essential user attributes such as email and password, providing
 * a simple structure for passing user data in test scenarios.
 */
public class UserData {

    // Private fields to store user email and password
    private String password;
    private String email;

    /**
     * Constructor to initialize UserData with an email and password.
     * @param email    The user's email address.
     * @param password The user's password.
     */
    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Getter for the password.
     * @return String - the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the email.
     * @return String - the user's email address.
     */
    public String getEmail() {
        return email;
    }
}

