package airtelxlabs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestSubStringLength {
    //The questions was to find the length of the shortest substring which contains all the unique characters contained in the string
    //dabbcabcd -> last 4 characters abcd contains all the unique characters hence answer is 4
    public static void main(String[] args) {
        System.out.println(shortestSubstring("dabbcabcd"));
        System.out.println(shortestSubstring("bab"));
        System.out.println(shortestSubstring("bcaacbc"));

        System.out.println(shortestSubstring("abcd"));
        System.out.println(shortestSubstring("aaaa"));
        System.out.println(shortestSubstring("a"));
        System.out.println(shortestSubstring("abcdabcd"));
        System.out.println(shortestSubstring("dcbccbccbccba"));
        System.out.println(shortestSubstring("aabbacdccdd"));
        //System.out.println(shortestSubstring("bab"));
    }

    public static int shortestSubstring(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for(Character c : set) {
            map.put(c, 0);
        }

        count = substringCount(arr, set, map);

        return count;
    }

    public static int substringCount(char[] arr, Set<Character> set, Map<Character, Integer> map) {
        int start = 0;
        int end = 0;
        int count = Integer.MAX_VALUE;
        boolean found;
        map.put(arr[start], 1);

        while(start < arr.length - 1) {
            found = true;

            for(Character c : set) {
                int val = map.get(c);
                if(val == 0) {
                    found = false;
                    break;
                }
            }

            if(found) {
                if(count > end - start + 1)
                    count = end - start + 1;

                int val = map.get(arr[start]);
                map.put(arr[start], val - 1);

                start = start + 1;
            } else {
                if(end < arr.length - 1) {
                    end = end + 1;
                    int val = map.get(arr[end]);
                    map.put(arr[end], val + 1);
                } else {
                    break;
                }
            }
        }

        if(count == Integer.MAX_VALUE)
            return 1;

        return count;
    }
}