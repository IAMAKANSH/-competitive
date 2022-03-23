package topic.dp;

import java.util.Scanner;

public class PaintKFench {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();

        int same=c*1;
        int different=c*(c-1);
        int sum=same+different;
        for (int i=3;i<=n;i++)
        {
            same=different*1;
            different=sum*2;
            sum=same+different;
        }
        System.out.println(sum);
    }
}
