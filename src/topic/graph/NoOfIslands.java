package topic.graph;

import java.util.Scanner;

public class NoOfIslands {

    public static void main(String[] args) {
        //No of islands
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the columns and rows");
        int cols=sc.nextInt();
        int rows=sc.nextInt();
        int[][] matrix=new int[rows][cols];
        for(int j=0;j<rows;j++) {
            Scanner sc1=new Scanner(System.in);
            String numbers = sc1.nextLine();
            String num[] = numbers.split("\\s");
            int k=0;
            for (String n : num
            ) {
                matrix[j][k] = Integer.parseInt(n);
                k++;
            }
        }
        boolean[][] visited=new boolean[rows][cols];
        int noOfIslands=noOfIslands(matrix,visited);
        System.out.println("No Of Island is "+noOfIslands);
    }

    private static int noOfIslands(int[][] matrix, boolean[][] visited) {

        if(matrix.length==0)
            return 0;
        int count=0;
        for (int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0 && visited[i][j]==false) {
                    dfs(matrix, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if(i>matrix.length-1 || j>matrix[0].length-1 || i<0 || j<0 || visited[i][j] || matrix[i][j]==1 )
            return;
        visited[i][j]=true;
        dfs(matrix,visited,i+1,j);
        dfs(matrix,visited,i,j+1);
        dfs(matrix,visited,i-1,j);
        dfs(matrix,visited,i,j-1);

    }
}
