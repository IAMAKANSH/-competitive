package challenge;

import java.util.Scanner;

public class Day9Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int column=sc.nextInt();
        int target= sc.nextInt();
        int[][] matrix=new int[row][column];

        for (int i=0;i<row;i++)
        {
            for (int j=0;j<column;j++)
            {
                matrix[i][j]= sc.nextInt();
            }
        }
        int left=0;
        int right=row-1;
        Boolean result=false;
        System.out.println(findSpecificRow(matrix,target,left,right,result));
    }

    private static boolean findSpecificRow(int[][] matrix, int target, int left, int right, Boolean result) {

        if(left>right)
            return false;

        int  middle= (int) Math.floor((left+right)/2);

        if(target>=matrix[middle][0] && target<=matrix[middle][matrix[0].length-1])
        {
            int mLeft=0;
            int mRight=matrix[0].length-1;
            int mMiddle;
            while (mLeft<=mRight)
            {
                mMiddle=(int)Math.floor((mLeft+mRight)/2);
                if(matrix[middle][mMiddle]==target)
                {
                    return true;
                }
                else if(target>matrix[middle][mMiddle])
                {
                    mLeft=mMiddle+1;
                }
                else
                {
                    mRight=middle-1;
                }
            }

        }
        else if (target>matrix[middle][matrix[0].length-1])
        {
            findSpecificRow(matrix,target,middle+1,right,result);
        }
        else
        {
            findSpecificRow(matrix,target,left,middle-1,result);
        }
        return false;
    }

    private static void checkWhetherExists(int[][] matrix,int row, int target, Boolean result, int left, int right) {

        if(left>right)
            return;

        int middle= (int) Math.floor((left+right)/2);

        if(matrix[row][middle]==target)
        {
            result=Boolean.TRUE;
        }
        else if (target>matrix[row][middle])
        {
            checkWhetherExists(matrix,row,target,result,middle+1,right);
        }
        else
        {
            checkWhetherExists(matrix,row,target,result,left,middle-1);
        }

    }
}
