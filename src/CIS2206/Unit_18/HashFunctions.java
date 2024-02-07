package CIS2206.Unit_18;

import java.math.BigInteger;

/**
 * Implements five hash function methods
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class HashFunctions {

//    static String[] keys = {"algorithms", "data", "structures", "list", "stack", "queue", "tree"};
    static String[] keys = {"research", "collection", "knowledge", "program", "technology", "planning", "analysis"};

    static int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    /**
     * Method 1: Translates the key into string's length
     *
     * @param key Given key
     * @return Corresponding hash value
     */
    public static int hashFunctionMethod1(String key) {
        return key.length();
    }

    /**
     * Method 2: Translates the key into the ASCII code of the string's first character
     *
     * @param key Given key
     * @return Corresponding hash value
     */
    public static int hashFunctionMethod2(String key) {
        return key.charAt(0);
    }

    /**
     * Method 3: Translates the key into the sum of ASCII codes of string's characters
     *
     * @param key Given key
     * @return Corresponding hash value
     */
    public static int hashFunctionMethod3(String key) {
        char[] chars = key.toCharArray();
        int result = 0;
        for (char c : chars) {
            result += c;
        }
        return Math.abs(result);
    }

    /**
     * Method 4: Translates the key into powers of increasing prime numbers,
     * and then computes the product
     *
     * @param key Given key
     * @return Corresponding hash value
     */
    public static BigInteger hashFunctionMethod4(String key) {
        char[] chars = key.toCharArray();
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < chars.length; i++) {
            BigInteger prime = BigInteger.valueOf(primeNumbers[i]);
            BigInteger power = prime.pow(chars[i]);
            result = result.multiply(power);
        }
        return result.abs();
    }

    /**
     * Method 5: Translates the key based on Java's hash function
     *
     * @param key Given key
     * @return Corresponding hash value
     */
    public static int hashFunctionMethod5(String key) {
        return Math.abs(key.hashCode());
    }

    public static void main(String[] args) {

        System.out.println("***** Raw hash values *****\n");

        int hashValue;
        int trimmedValue;
        int size = 7;

        System.out.println("Size of hashtable: " + size);

        System.out.println("\n//////////////////////////////////\n");

        for (String key : keys) {
            hashValue = hashFunctionMethod1(key);
            trimmedValue = hashValue % size;
            System.out.println("Method 1:\n\tkey: '" + key + "'\n\traw hash value: " +
                    hashValue + "\n\ttrimmed (hash % " + size + "): " + trimmedValue);
        }

        System.out.println("\n//////////////////////////////////\n");

        for (String key : keys) {
            hashValue = hashFunctionMethod2(key);
            trimmedValue = hashValue % size;
            System.out.println("Method 2:\n\tkey: '" + key + "'\n\traw hash value: " +
                    hashValue + "\n\ttrimmed (hash % " + size + "): " + trimmedValue);
        }

        System.out.println("\n//////////////////////////////////\n");

        for (String key : keys) {
            hashValue = hashFunctionMethod3(key);
            trimmedValue = hashValue % size;
            System.out.println("Method 3:\n\tkey: '" + key + "'\n\traw hash value: " +
                    hashValue + "\n\ttrimmed (hash % " + size + "): " + trimmedValue);
        }

        System.out.println("\n//////////////////////////////////\n");

        for (String key : keys) {
            BigInteger bighHashValue = hashFunctionMethod4(key);
            trimmedValue = bighHashValue.remainder(BigInteger.valueOf(size)).intValue();
            System.out.println("Method 4:\n\tkey: '" + key + "'\n\traw hash value: " +
                    bighHashValue + "\n\ttrimmed (hash % " + size + "): " + trimmedValue);
        }

        System.out.println("\n//////////////////////////////////\n");

        for (String key : keys) {
            hashValue = hashFunctionMethod5(key);
            trimmedValue = hashValue % size;
            System.out.println("Method 5:\n\tkey: '" + key + "'\n\traw hash value: " +
                    hashValue + "\n\ttrimmed (hash % " + size + "): " + trimmedValue);
        }
    }
}
