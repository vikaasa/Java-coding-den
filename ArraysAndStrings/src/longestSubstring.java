import java.util.HashMap;

/**
 * Created by Vikaasa on 25/02/2017.
 */
public class longestSubstring {
    public static String longestSubstringWithoutRepeats(String s){
        String longestString = "";
        int startIndex = 0;
        int maxLen = 0;
        String outputLongestSubstring = "";
        HashMap<Character,Integer>hashMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if (hashMap.containsKey(s.charAt(i))){
                if (hashMap.size()>maxLen) {
                    maxLen = hashMap.size();
                    outputLongestSubstring = s.substring(startIndex+1, i);
                }
                startIndex = hashMap.get(s.charAt(i));
                hashMap.clear();
                i = startIndex;
            }
            else{
                hashMap.put(s.charAt(i),i);
            }
        }
        if (hashMap.size()>maxLen) {
            maxLen = hashMap.size();
            outputLongestSubstring = s.substring(startIndex + 1);
        }
        return outputLongestSubstring;
    }
    public static void main(String[] args){
        String s = "aabacdjsbydqwertyu";
        String maxLen = longestSubstringWithoutRepeats(s);
        System.out.print(maxLen);
    }
}
