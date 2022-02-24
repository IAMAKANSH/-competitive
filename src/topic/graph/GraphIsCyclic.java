package topic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphIsCyclic {

    static class Pair{
        int v;
        String psf;
        Pair(int v,String psf){
            this.v=v;
            this.psf=psf;
        }
    }
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
          if(visited[i]==false)
          {
             Boolean cyclic= isGraphCyclic(graph, visited, i);
             if (cyclic)
             {
                 System.out.println(true);
                 return;
             }
          }
        }
        System.out.println(false);
    }

    private static boolean isGraphCyclic(ArrayList<Edge>[] graph, boolean[] visited, int i) {
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(i, i +""));
        while (queue.size()>0)
        {
            Pair rem=queue.removeFirst();
            System.out.println(rem.v+"@"+rem.psf);
            if(visited[rem.v])
            {
                return true;
            }
            visited[rem.v]=true;
            for (Edge e: graph[rem.v])
            {
                if(visited[e.getNbr()]==false)
                {
                    queue.add(new Pair(e.getNbr(), rem.psf+e.getNbr()));
                }
            }
        }
        return false;
    }
}
