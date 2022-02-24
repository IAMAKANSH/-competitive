package topic.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

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

        boolean[] visited=new boolean[vertices];

        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<vertices;i++)
        {
            if(visited[i]==false)
            {
                topologicalSort(graph,i,visited,stack);
            }
        }
        stack.stream().forEach(integer -> System.out.println(integer));
    }


    public static  void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> stack)
    {
        visited[src]=true;
        for (Edge e:graph[src])
        {
            if(visited[e.getNbr()]==false)
            {
                topologicalSort(graph, e.getNbr(),visited,stack);
            }
        }
        stack.push(src);

    }
}
