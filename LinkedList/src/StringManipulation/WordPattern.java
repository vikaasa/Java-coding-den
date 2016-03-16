package StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vikaasa on 2/28/2016.
 */
public class WordPattern {
    public static boolean One(String pattern, String str) {

        System.out.println(str);
        System.out.println(str.length());
        String[] strSplit=str.split(" ");

        //System.out.print(str);
        //System.out.println(strSplit[0].length());
        //System.out.println(strSplit.length);
        HashMap<Character,String> map = new HashMap<>();
        int patternLength=pattern.length();
        int strLength = strSplit.length;
        //List<String> temp = Arrays.asList(strSplit);
        if(strLength!=patternLength){
            return false;
        }
        for(int i=0;i<patternLength;i++){
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),strSplit[i]);
            }
        }
        for(int i=0;i<patternLength;i++){
            if(!strSplit[i].equals(map.get(pattern.charAt(i)))){
                return false;
            }
        }
        /*System.out.println(strSplit[0]);
        Arrays.sort(strSplit);
        System.out.println(strSplit[0]);*/
        return true;
    }

    public static void main(String[] args) {
        String pattern = new String();
        String str=new String();

        pattern = "1221";
        str="dog cat cat dog";
        System.out.print(One(pattern, str));
    }
}

