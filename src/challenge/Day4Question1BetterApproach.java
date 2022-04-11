package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4Question1BetterApproach {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(0,0);
        int result=fibonacci(map,n);
        System.out.println(result);
    }

    private static int fibonacci(Map<Integer, Integer> map, int n) {
        if(map.get(n)!=null)
            return  map.get(n);
        else {
            int sum=fibonacci(map,n-1)+fibonacci(map,n-2);
            map.put(n,sum);
            return map.get(n);
        }

    }
}
