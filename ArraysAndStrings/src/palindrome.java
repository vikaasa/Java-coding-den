/**
 * Created by Vikaasa on 26/02/2017.
 */
public class palindrome {
    public static void longestPalindromeSubstring(String s){
        int max_count = 0;
        for(double i = 0; i < s.length(); i+=0.5)
        {
            double j = i-0.5;
            double k = i+0.5;
            int count = 0;
            if(j%1 == 0 && k%1 == 0)
            {
                j = (int) j;
                k = (int) k;
            }
            else
            {
                j = j-0.5;
                k = k+0.5;
            }
            while(j >= 0 && k < s.length())
            {
                if(s.charAt((int) j) == s.charAt((int)k))
                {
                    j-=1;
                    k+=1;
                    count+=2;
                }
                else
                    break;
            }
            if(i%1 == 0)
            {
                count+=1;
            }
            if(max_count < count)
            {
                max_count = count;
            }
        }
        System.out.println(max_count);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        longestPalindromeSubstring("aayuyoppocfefc");
    }

}