package dataStructures.hashing;

import java.util.HashMap;

public class ValidAnagrams {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        HashMap<Character, Integer> frequency = new HashMap();

        for(Character character : s1.toCharArray()) {
            if(frequency.containsKey(character)) {
                int currentFrequency = frequency.get(character);
                frequency.put(character, currentFrequency + 1);
            } else {
                frequency.put(character, 1);
            }
        }

        boolean success = true;

        for(Character character : s2.toCharArray()) {
            if(!frequency.containsKey(character)) {
                success = false;
                System.out.println("Two strings are not anagram.");
                break;
            }
            int updatedFrequency = frequency.get(character) - 1;
            frequency.put(character, updatedFrequency);
        }


        for(char c : frequency.keySet()) {
            if(frequency.containsKey(c) && frequency.get(c) != 0) {
                success = false;
                System.out.println("Two strings are not anagram.");
            }
        }

        if(success) {
            System.out.println("Two string are anagrams");
        }
    }
}

