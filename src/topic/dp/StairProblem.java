package topic.dp;

import java.util.Scanner;

public class StairProblem {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int noOfStairs=sc.nextInt();
        int[] previousSolvedSol=new int[noOfStairs+1];
        int combinations=sumOfPossibilityToReachJumpingOneTwoThree(noOfStairs,previousSolvedSol);
        System.out.println("No of combinations :"+combinations);
    }

    private static int sumOfPossibilityToReachJumpingOneTwoThree(int noOfStairs,int[] previousSolvedSol) {
        if(noOfStairs==0)
            return 1;

        if(noOfStairs<0)
            return 0;

        if(previousSolvedSol[noOfStairs]>0)
            return previousSolvedSol[noOfStairs];
        int oneStep=sumOfPossibilityToReachJumpingOneTwoThree(noOfStairs-1,previousSolvedSol);
        int twoStep=sumOfPossibilityToReachJumpingOneTwoThree(noOfStairs-2,previousSolvedSol);
        int thirdStep=sumOfPossibilityToReachJumpingOneTwoThree(noOfStairs-3,previousSolvedSol);

        int sum=oneStep+twoStep+thirdStep;
        previousSolvedSol[noOfStairs]=sum;
        return sum ;

    }
}
