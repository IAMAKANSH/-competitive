package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        Boolean result=isomorphic(s1,s2);
        System.out.println(result);
    }

    private static Boolean isomorphic(String s1, String s2) {

        if(s1.length()!=s2.length())
            return false;

        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();

        for (int i=0;i<s1.length();i++)
        {
            Character c1=s1.charAt(i);
            Character c2=s2.charAt(i);
            if(map1.get(c1)==null)
            {
                map1.put(c1,c2);
            }
            if(map2.get(c2)==null)
            {
                map2.put(c2,c1);
            }
            if(c1==map2.get(c2) && c2==map1.get(c1))
                continue;
            else
                return false;

        }
        return true;
    }
}
