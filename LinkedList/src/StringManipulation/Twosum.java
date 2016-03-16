package StringManipulation;

import java.util.*;

/**
 * Created by Vikaasa on 2/29/2016.
 */
public class Twosum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] defaultResult = {0, 0};
        for (int i = 0; i < nums.length; i++) {

            if (map.get(target-nums[i]) != null ) {
                int[] result = {map.get(target-nums[i]) + 1, i + 1 };
                return result;
            }
            map.put(nums[i], i);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }

        return defaultResult;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,0,-2,-1};
        int tr=-2;
        int[] res = twoSum(input, tr);
        int len=res.length;
        for(int i=0;i<len;i++){
            System.out.println(res[i]);
        }
    }
}

/*
int check;
int[] a= new int[2];
for(int i=0;i<nums.length;i++)
        {
        check = target- nums[i];
        for(int j=0;j<nums.length;j++)
        {
        if(i!=j && nums[j]== check) {
        a[0] = i;
        a[1] = j;
        break;
        }
        }
        }
        return a;*/
