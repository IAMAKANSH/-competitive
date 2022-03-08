package topic.dp;

import java.util.Scanner;

public class ArrangeBuilding {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int [] buildings=new int[n+1];
        int [] spaces=new int[n+1];
        buildings[1]=1;
        spaces[1]=1;
        for (int i=2;i<=n;i++)
        {
            spaces[i]=spaces[i-1]+buildings[i-1];
            buildings[i]=spaces[i-1];
        }

        System.out.println("No of possibility ending with zero is "+((buildings[n]+spaces[n])*(buildings[n]+spaces[n]) ) );
    }
}
