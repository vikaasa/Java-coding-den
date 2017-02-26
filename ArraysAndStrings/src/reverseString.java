import java.util.Stack;

/**
 * Created by Vikaasa on 25/02/2017.
 */
public class reverseString {
    public static String reverseSentence(String ip){
        String[] words = ip.split(" ");
        Stack wordStack = new Stack();
        for (int i = 0; i<words.length; i++){
            wordStack.push(words[i]);
        }
        StringBuilder reversedSentence = new StringBuilder();
        while (1==1){
            reversedSentence.append(wordStack.pop());
            if(!wordStack.empty()){
                reversedSentence.append(" ");
            }
            else{
                break;
            }
        }
        return reversedSentence.toString();
    }
    public static String reverseWordsInPlace(String ip){
        String[] words = ip.split(" ");
        String reversedWordsInPlace="";
        for(int i=0; i<words.length; i++){
            String temp = new StringBuilder(words[i]).reverse().toString();
            reversedWordsInPlace += temp+" ";
        }
        return reversedWordsInPlace;
    }
    public static void main(String[] args){
        String result = reverseSentence("This is a wonderful country");
        String result2 = reverseWordsInPlace("Vikaasa is awesome");
        System.out.println(result2);
    }
}
