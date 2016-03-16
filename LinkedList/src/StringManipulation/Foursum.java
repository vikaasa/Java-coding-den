package StringManipulation;

import java.util.*;

/**
 * Created by Vikaasa on 2/28/2016.
 */
public class Foursum {
    public static List<List<Integer>> findFoursum(int[] inputArray, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = inputArray.length;
        Arrays.sort(inputArray);
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(inputArray[i])) {
                map.put(inputArray[i], 1);
            }
            else{
                int count=map.get(inputArray[i]);
                count++;
                map.put(inputArray[i],count);
            }
        }
        for(int i=0;i<length;i++){

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        return result;
    }
    public static void main(String[] args) {
        int[] input = {1,0,-1,0,-2,2};
        int tr=0;
        List<List<Integer>> res = new ArrayList<>();
        res=findFoursum(input, tr);

    }
}
