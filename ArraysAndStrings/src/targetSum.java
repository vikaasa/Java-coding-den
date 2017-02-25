import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Vikaasa on 25/02/2017.
 */
public class targetSum {
    public int[] twoSum(int[] nums, int target){
        if(nums.length > 2) {
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i<nums.length; i++){
                if (hashMap.containsKey(nums[i])){
                    int result[] = {nums[i], nums[hashMap.get(nums[i])]};
                    return result;
                }
                else{
                    int diff = target-nums[i];
                    //System.out.println("trace: " +diff+ ", " +i);
                    hashMap.put(target-nums[i],i);
                }
            }

        }
        return null;
    }
    public static void main(String[] args){
        int [] nums = {2,5,4,6,4};
        targetSum ts = new targetSum();
        int[] twoSumResult=ts.twoSum(nums,8);
        for(int i = 0; i<twoSumResult.length; i++){
            System.out.print(twoSumResult[i]+" ");
        }
    }
}
