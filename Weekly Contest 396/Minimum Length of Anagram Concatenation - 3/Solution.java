import java.util.*;

class Solution {
    public boolean func(String s, int len, int n) {
        //this function will check if the anagram till 0...index-1 is repeating for throughout the string
        Map<Character, Integer> mp1 = new HashMap<>();
        //store the anagram values
        for(int i = 0; i < len; i++) {
            char x = s.charAt(i);
            mp1.put(x, mp1.getOrDefault(x,0) + 1);
        }
        //check if the anagram is repeated
        for(int i = len; i < n; i += len) {
            Map<Character, Integer> mp2 = new HashMap<>();
            for(int j = i; j < i + len; j++) {
                mp2.put(s.charAt(j), mp2.getOrDefault(s.charAt(j), 0) + 1);
            }
            if(!mp1.equals(mp2)) {
                return false;
            }  
        }
        return true;
    }
    public int minAnagramLength(String s) {
        int n = s.length();
        for(int i = 1; i <= n; i++) {
            if(n%i == 0 && func(s,i,n) == true) {
                return i;
            }
        }
        return n;
    }
}

//TC : O(N * sqrt(N))
//SC : O(N)