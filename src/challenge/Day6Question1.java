package challenge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Day6Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char ch=nonReaptingCharacter(str);
        System.out.println(ch);
    }

    private static char nonReaptingCharacter(String str) {

        Map<Character,Integer> map=new LinkedHashMap<>();

        for (int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.get(c)!=null)
            {
                map.put(c,map.get(c)+1);
            }
            else
            {
                map.put(c,1);
            }
        }
        for (Map.Entry<Character,Integer> m:map.entrySet())
        {
            if(m.getValue()==1)
                return m.getKey();
        }
        return '0';
    }
}
