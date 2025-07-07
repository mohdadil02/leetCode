import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        // String s = "cbzxy";
        // System.out.println("Answe is this: " + maxLengthBetweenEqualCharacters(s));

        // Solution sol = new Solution();
        // System.out.println(sol.removeDuplicateLetters("cbacdcbc"));

        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        Solution sb = new Solution();

        String [] arr = sb.divideString(s, k, fill);
        System.out.println(Arrays.toString(arr));


    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    return j - i - 1;
                }
            }
        }
        return -1;
    }

    // =====>  Remove duplicate from a string


    // public String removeDuplicateLetter(String s) {
    //     int[] count = new int[26];  // Count of each character
    //     boolean[] inStack = new boolean[26];  // Track what's in stack

    //     for (char c : s.toCharArray()) {
    //         count[c - 'a']++;
    //     }

    //     Stack<Character> stack = new Stack<>();

    //     for (char c : s.toCharArray()) {
    //         count[c - 'a']--;  // One less occurrence

    //         if (inStack[c - 'a']) continue;

    //         while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
    //             inStack[stack.pop() - 'a'] = false;
    //         }

    //         stack.push(c);
    //         inStack[c - 'a'] = true;
    //     }

    //     // Convert stack to string
    //     StringBuilder result = new StringBuilder();
    //     for (char c : stack) {
    //         result.append(c);
    //     }

    //     return result.toString();
    // }
    
    
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] taken = new boolean[26];

        StringBuilder result = new StringBuilder();
        int n = s.length();

        for(int i = 0; i< n; i++){
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        for(int i= 0; i< n; i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            if(taken[idx]) continue;

            while (result.length() > 0 && ch < result.charAt(result.length() -1)  && lastIndex[result.charAt(result.length()-1) - 'a'] > i) {
                taken[result.charAt(result.length()-1) - 'a'] = false;
                result.deleteCharAt(result.length()-1);
            }

            result.append(ch);
            taken[idx] = true;
        }
        return result.toString();
    }

    //  2138. Divide a String Into Groups of Size k

    public String[] divideString(String s, int k, char fill){
        List<String> result = new ArrayList<>();
        int n = s.length();

        for(int i =0; i<n; i +=k){
            int end = Math.min(i+k, s.length());

            String sb = s.substring(i,end);
           

            if(sb.length() < k){
                int rem = k - sb.length();
                for(int j=0; j<rem; j++){
                  sb += fill;
                }
            }
            result.add(sb);
        }
        return result.toArray(new String[0]);

    } 
}