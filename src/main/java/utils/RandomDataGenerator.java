package utils;

import java.util.Random;

/**
 * RandomDataGenerator is a utility class for generating random data such as emails and passwords.
 * This class provides methods for creating random strings that can be used as test data, ensuring
 * unique and dynamic input values for each test run.
 */
public class RandomDataGenerator {

    // Constant string of characters to be used for generating random alphanumeric strings
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // Random instance for generating random values
    private static final Random random = new Random();

    /**
     * Generates a random email address.
     * @return String - a randomly generated email address with a random prefix.
     * The domain is set to "example.com" but can be changed as needed.
     */
    public static String generateRandomEmail() {
        String prefix = generateRandomString(8); // Generate an 8-character random prefix
        return prefix + "@example.com"; // Append domain to create a valid email
    }

    /**
     * Generates a random password of specified length.
     * @param length - the desired length of the password.
     * @return String - a randomly generated alphanumeric password.
     */
    public static String generateRandomPassword(int length) {
        return generateRandomString(length); // Use helper method to generate the random string
    }

    /**
     * Helper method to generate a random alphanumeric string of a given length.
     * Used internally by other methods to generate random values.
     * @param length - the desired length of the random string.
     * @return String - a randomly generated alphanumeric string.
     */
    private static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // Append a random character from CHARACTERS to the string builder
            builder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return builder.toString(); // Convert StringBuilder to String and return
    }
}
