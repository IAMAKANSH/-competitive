package topic.dp;

import java.util.Scanner;

public class CountABC {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input=sc.next();

        int a=0;
        int ab=0;
        int abc=0;

        for (int i=0;i<input.length();i++)
        {
            char ch=input.charAt(i);
            if(ch=='a')
            {
                a=2*a+1;
            }
            else if(ch=='b')
            {
                ab=2*ab+a;
            }
            else if(ch=='c')
            {
                abc=2*abc+ab;
            }
        }
        System.out.println(abc);

    }
}
