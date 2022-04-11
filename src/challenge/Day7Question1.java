package challenge;

import java.util.*;

public class Day7Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        Integer response=getLongestUniqueSubString(str);
        System.out.println(response);
    }

    private static Integer getLongestUniqueSubString(String str) {
        Map<Character,Integer> seen=new HashMap<>();
        int i=0;
        int start=0;
        int max=0;
        while(i<str.length())
        {
            if(seen.get(str.charAt(i))!=null)
            {
                start=Math.max(start,seen.get(str.charAt(i))+1);
                int finalI = i;
                seen.computeIfPresent(str.charAt(i),(character, integer) -> finalI);
            }
            else
            {
                seen.put(str.charAt(i),i);
            }
            max=Math.max(max,i-start+1);
            i++;
        }
        return max;
    }
}
