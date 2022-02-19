package topic.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfGraphs {
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
        for (int i=0;i<vertices;i++)
        {
            if(!visited[i]) {
                ArrayList<Integer> comp=new ArrayList<>();
                hasPath(graph, visited, i, comp);
                finalList.add(comp);
            }
        }
        System.out.println(finalList);
    }
    static List<List<Integer>> finalList=new ArrayList<>();
    private static  void hasPath(ArrayList<Edge>[] graph, boolean[] visited,int src,List<Integer> list) {
       visited[src]=true;
        list.add(src);
        for (Edge edge:graph[src])
        {
            if(!visited[edge.getNbr()])
            {
                hasPath(graph,visited,edge.getNbr(),list);
            }
        }
        return;
    }
}
