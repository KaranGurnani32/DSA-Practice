package arrayleetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
    * Checking frequency map first adding all letters of first string to hashmap and provide counting then
    * deleting all letters one by one if size is zero then it is anagram
    * */
    public static void main(String[] args) {
        String first = "anagram"; // Creating first String for input
        String second = "nagaram"; // Creating second String for input

        Boolean result = checkAnagram(first, second); // Returning the method as boolean
        System.out.println("result = " + result);
    }

    private static Boolean checkAnagram(String first, String second) {
        if (first.length() != second.length()) { // If both string have different length then they can't
            // be anagram hence return false
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(); // Creating map

        for (int i = 0; i < first.length(); i++) {
            // Every letter gets converted to character ch
            // In getOrDefault method, it is used to get the value mapped with specific key. If no value
            // is mapped with the provided key then default value is returned
            char ch = first.charAt(i);
            // We take letters as key and put number
            // of time, it appeared on string as value
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);

            // If map doesn't contain any letter from second string then
            // it means that letter is not in first string, and it can't be anagram hence we return false
            if (map.get(ch) == null) {
                return false;
            }

            // If a letter appears one time then we remove it from map
            if (map.get(ch) == 1) {
                map.remove(ch);
                // If a letter appears more than one time then we remove its one instance from map
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }

}
