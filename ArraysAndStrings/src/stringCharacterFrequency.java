import java.util.*;
import java.util.Map.Entry;


/**
 * Created by Vikaasa on 25/02/2017.
 */
public class stringCharacterFrequency {
    public static void findFrequency(String str)
    {
        HashMap<Character, Integer> myHashMap = new HashMap<Character, Integer>();
        for (char c : str.toCharArray())
        {
            int count = myHashMap.getOrDefault(c, 0)+1;
            myHashMap.put(c, count);
        }
        Set entry = myHashMap.entrySet();
        Comparator<Entry<Character, Integer>> valueComparator = new Comparator<Entry<Character,Integer>>()
        {
            @Override
            public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2)
            {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v2.compareTo(v1);
            }
        };
        List<Entry<Character, Integer>> listOfEntries = new ArrayList<Entry<Character, Integer>>(entry);
        Collections.sort(listOfEntries, valueComparator);


        LinkedHashMap<Character, Integer> sortedByValue = new LinkedHashMap<Character, Integer>(listOfEntries.size());

        for(Entry<Character, Integer> entries : listOfEntries)
        {
            System.out.println(entries.getKey() + "->"+ entries.getValue());
            //sortedByValue.put(entries.getKey(), entries.getValue());
        }

        //If we need to put it back in the map
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<Character, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
        for(Entry<Character, Integer> mapping : entrySetSortedByValue)
        {
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        findFrequency("sanjana");
    }

}
