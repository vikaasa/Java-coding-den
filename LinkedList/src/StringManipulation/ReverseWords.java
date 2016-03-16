package StringManipulation;

import java.util.*;
import java.lang.Math;

/**
 * Created by Vikaasa on 2/29/2016.
 */
public class ReverseWords {
    public static void reverse(String str) {
        StringBuilder reverseStr = new StringBuilder();
        reverseStr.append(str);
        reverseStr.reverse();
        System.out.println(reverseStr);
        int len = reverseStr.length();
        ArrayList<Integer> startPtr = new ArrayList<Integer>();
        ArrayList<Integer> endPtr = new ArrayList<Integer>();
        startPtr.add(0);
        int i;
        for(i=0;i<len;i++){
            char tmp= reverseStr.charAt(i);
            if (tmp == ' '){
                endPtr.add(i-1);
                startPtr.add(i+1);
            }
        }
        endPtr.add(i-1);

        System.out.println("Start ptr "+ startPtr);
        System.out.println("End ptr "+ endPtr);
        int len2=startPtr.size();
        for (int j=0;j<len2;j++){
            System.out.println("swap call "+ startPtr.get(j)+ " "+ endPtr.get(j));
            swap(reverseStr, startPtr.get(j), endPtr.get(j));
        }
        System.out.println(reverseStr);
    }
    public static void swap(StringBuilder str, int start, int end){
        char tmp;
        for(int i=start,j=end;i<=Math.ceil((double)(end + start) / 2)&&j>=Math.ceil((double)(end+start)/2);i++,j--){
            System.out.println(Math.ceil((double)(end + start) / 2));
            tmp=str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j,tmp);
        }
    }

    public static void main(String[] args) {
        String str = "this is a stupid dog";
        reverse(str);

    }
}