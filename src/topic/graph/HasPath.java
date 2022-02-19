package topic.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {

    public static void main(String[] args) {
        System.out.println("Enter the no of vertices");
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[vertices];
        for (int i=0;i<vertices;i++)
        {
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter the no of edges");
        int edges=sc.nextInt();
        for(int j=0;j<edges;j++)
        {
            Scanner sc1=new Scanner(System.in);
            String[] parts=sc1.nextLine().split("\\s");
            int v1=Integer.parseInt(parts[0]);
            int v2=Integer.parseInt(parts[1]);
            int wt=Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        System.out.println("Enter the start point");
        int src=sc.nextInt();
        System.out.println("Enter the destination point");
        int dest=sc.nextInt();
        boolean[] visited=new boolean[vertices];
        Boolean result=hasPath(graph,src,dest,visited);
        System.out.println(result);
    }

    private static Boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if(src==dest)
        {
            return true;
        }
        visited[src]=true;
        for (Edge edge:graph[src])
        {
            if(!visited[edge.getNbr()])
            {
                boolean hasNbrPath=hasPath(graph,edge.getNbr(),dest,visited);
                if(hasNbrPath)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
