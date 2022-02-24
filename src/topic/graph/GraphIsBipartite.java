package topic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphIsBipartite {

    static class Pair{
        int v;
        String psf;
        int level;
        Pair(int v,String psf,int level){
            this.v=v;
            this.psf=psf;
            this.level=level;
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
        int[] visited=new int[vertices];
        Arrays.fill(visited,-1);
        for (int i=0;i<vertices;i++)
        {
            if(visited[i]==-1)
            {
                Boolean bipartite= checkComponentBipartite(graph, visited, i);
                if (bipartite==false)
                {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    private static boolean checkComponentBipartite(ArrayList<Edge>[] graph, int[] visited, int i) {
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(i, i +"",0));
        while (queue.size()>0)
        {

            Pair rem=queue.removeFirst();
            System.out.println(rem.v+"@"+rem.psf);
            if(visited[rem.v]!=-1)
            {
                if(rem.level!=visited[rem.v])
                    return false;
            }else
            {
                visited[rem.v]=rem.level;
            }

            for (Edge e: graph[rem.v])
            {
                if(visited[e.getNbr()]==-1)
                {
                    queue.add(new Pair(e.getNbr(), rem.psf+e.getNbr(), rem.level+1));
                }
            }
        }
        return true;
    }
}
