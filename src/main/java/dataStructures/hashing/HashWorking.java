package dataStructures.hashing;

import java.util.HashMap;

public class HashWorking {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "First");
        hashMap.put("1", "Second");
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.containsValue("First"));
    }
}
