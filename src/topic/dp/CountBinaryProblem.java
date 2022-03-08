package topic.dp;

import java.util.Scanner;

public class CountBinaryProblem {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int [] arrOfZero=new int[n+1];
        int [] arrOfOne=new int[n+1];
        arrOfZero[1]=1;
        arrOfOne[1]=1;
        for (int i=2;i<=n;i++)
        {
                arrOfOne[i]=arrOfOne[i-1]+arrOfZero[i-1];
                arrOfZero[i]=arrOfOne[i-1];
        }

        System.out.println("No of possibility ending with zero is "+(arrOfZero[n]+arrOfOne[n]) );
    }

}
