package topic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class BreadthFirstSearch {
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
        System.out.println("Enter the start point");
        int src=sc.nextInt();

        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(src,src+""));
        boolean[] visited=new boolean[vertices];
        while (queue.size()>0)
        {
            Pair rem=queue.removeFirst();
            if(visited[rem.v])
            {
                continue;
            }
            visited[rem.v]=true;
            System.out.println(rem.v+"@"+rem.psf);
            for (Edge e:graph[rem.v])
            {
                if(visited[e.getNbr()]==false)
                {
                    queue.add(new Pair(e.getNbr(), rem.psf+e.getNbr()));
                }
            }
        }


    }
}
