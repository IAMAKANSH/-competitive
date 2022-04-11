package challenge;

import java.util.*;

public class Day7Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Integer n=sc.nextInt();
        String[] arr=new String[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        List<List<String>> response=getAnagram(arr);
        System.out.println(response);
    }

    private static List<List<String>> getAnagram(String[] arr) {
        List<List<String>> finalList=new ArrayList<>();
        Map<String,List<String>> seen=new HashMap<>();

        for (int i=0;i< arr.length;i++)
        {
            List<String> list=new ArrayList<>();
            char[] ch=arr[i].toCharArray();
            Arrays.sort(ch);
            String sortedStr=new String(ch);
            if(seen.get(sortedStr)!=null)
            {
                seen.get(sortedStr).add(arr[i]);
            }else
            {
                List<String> str=new ArrayList<>();
                str.add(arr[i]);
                seen.put(sortedStr,str);
            }
        }
        for(Map.Entry<String,List<String>> entry:seen.entrySet())
        {
            finalList.add(entry.getValue());
        }


        return finalList;
    }
}
