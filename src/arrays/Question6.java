package arrays;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        //No of islands
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows");
        int rows=sc.nextInt();
        int[][] metric=new int[rows][5];
        for(int j=0;j<rows;j++) {
            Scanner sc1=new Scanner(System.in);
            String numbers = sc1.nextLine();
            String num[] = numbers.split("\\s");
            int k=0;
            for (String n : num
            ) {
                metric[j][k] = Integer.parseInt(n);
                k++;
            }
        }
        int count=noOfIslands(metric);
        System.out.println(count);
    }

    private static int noOfIslands(int[][] metric) {

        if(metric.length==0 || metric==null)
            return 0;
        int count=0;
        boolean[][] visited=new boolean[metric.length][metric[0].length];
        for (int i=0;i<metric.length;i++)
        {
            for (int j=0;j<metric[0].length;j++)
            {
                if(metric[i][j]==1 && visited[i][j]==false)
                {
                   dfs(metric,visited,i,j);
                    count++;
                }
            }
        }
        return  count;
    }

    private static void dfs(int[][] metric, boolean[][] visited, int i, int j) {

        if(i<0 || j<0 || visited[i][j] || metric[i][j]==0 || i>metric.length || j>metric[0].length)
            return;

        visited[i][j]=true;
        dfs(metric,visited,i+1,j);
        dfs(metric,visited,i,j+1);
        dfs(metric,visited,i-1,j);
        dfs(metric,visited,i,j-1);
    }
}
