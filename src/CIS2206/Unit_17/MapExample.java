package CIS2206.Unit_17;

import java.util.HashMap;
import java.util.Map;

/**
 * This is an example of using maps
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class MapExample {

    public static void main(String[] args) {

        // Create a map from Strings (keys) to Person (values)
        Map<String, Person> myMap = new HashMap();

        // Add (key,value) pairs to map
        myMap.put("John", new Person("John", "John", 30));
        if (!myMap.containsKey("Jane")) {
            myMap.put("Jane", new Person("Jane", "Jane", 25));
        }
        myMap.put("Jack", new Person("Jack", "Jack", 40));

        // Loop through the map using keySet()
        for (String key: myMap.keySet()){
            System.out.println("KeySet (key,value): " + key + ", " + myMap.get(key));
        }

        // Replace (key,value) pairs in map
        myMap.replace("Jane", new Person("Jane", "Jane", 50));
        myMap.replace("Jack", new Person("Jack", "Jack", 75));

        // Loop through the map using entrySet()
        for (Map.Entry<String, Person> entry: myMap.entrySet()){
            System.out.println("EntrySet (key,value): " + entry.getKey() + ", " + entry.getValue());
        }

        // Loop through the map using values()
        for (Person value: myMap.values()) {
            System.out.println("Values (value): " + value);
        }

        // Check if map contains specific keys
        System.out.println("Contains key \"John\": " + myMap.containsKey("John"));
        System.out.println("Contains key \"Mike\": " + myMap.containsKey("Mike"));

        // Check if map contains specific values
        System.out.println("Contains value \"Jane\": " + myMap.containsValue(new Person("Jane", "Jane", 50)));
        System.out.println("Contains value \"Mike\": " + myMap.containsValue(new Person("Mike", "Mike", 75)));

        // Remove (key,value) pairs from map
        myMap.remove("Jack", new Person("Jack", "Jack", 75));
        myMap.remove("Jane");

        // Check maps size
        System.out.println("Size: " + myMap.size());

        // Check if map is empty
        System.out.println("Empty: " + myMap.isEmpty());

    }
}
