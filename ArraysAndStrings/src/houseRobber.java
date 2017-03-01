/**
 * Created by Vikaasa on 28/02/2017.
 */
public class houseRobber {
    //Adjacent houses should not be robbed, find max money that can be robbed from given array.
    public int maxRobberyCollection(int[] houses){
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i<houses.length; i++){
            if (i%2==0){
                evenSum = Math.max(evenSum+houses[i],oddSum);
            }
            else{
                oddSum = Math.max(oddSum+houses[i],evenSum);
            }
        }
        return Math.max(oddSum,evenSum);
    }
    public static void main(String[] args){
        houseRobber h1 = new houseRobber();
        int[] houses = {4,1,2,1,5,8,10};
        int maxCollection = h1.maxRobberyCollection(houses);
        System.out.println("Max collection is: "+maxCollection);
    }
}
