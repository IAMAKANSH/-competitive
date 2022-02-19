package topic.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrintSpecificDetails {
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
        System.out.println("Enter the criteria");
        int criteria=sc.nextInt();
        System.out.println("Enter the kth");
        int k=sc.nextInt();
        boolean[] visited=new boolean[vertices];
        printAllPaths(graph,src,dest,visited,criteria,k,src+"",0);
        System.out.println("spath"+spathwt+" path is "+spath);
        System.out.println("lpath"+lpathwt+" path is "+lpath);
        System.out.println("cpath"+cpathwt+" path is "+cpath);
        System.out.println("fpath"+fpathWt+" path is "+fpath);
        pq.forEach(pair -> System.out.println(pair.getWeight()));
        System.out.println("kth largest"+pq.poll().path+" weight: "+pq.poll().getWeight());
    }

       static String spath;
    static Integer spathwt=Integer.MAX_VALUE;
    static  String lpath;
    static    Integer lpathwt=Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt=Integer.MAX_VALUE;
    static String fpath;
    static  Integer fpathWt=Integer.MIN_VALUE;
    static  PriorityQueue<Pair> pq=new PriorityQueue<>(
            new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.getWeight() - o1.getWeight();
                }
            }
    );

    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
                                      int criteria,int k,String dsf,int wsf) {

        if(src==dest)
        {
            if(wsf<spathwt)
            {
                spathwt=wsf;
                spath=dsf;
            }
            if(wsf>lpathwt)
            {
                lpathwt=wsf;
                lpath=dsf;
            }
            if(wsf>criteria && wsf<cpathwt)
            {
                cpathwt=wsf;
                cpath=dsf;
            }
            if(wsf<criteria && wsf>fpathWt)
            {
                fpathWt=wsf;
                fpath=dsf;
            }
            pq.add(new Pair(wsf,dsf));
            if(pq.size()>k)
            {
                pq.poll();
            }
            System.out.println(dsf);
            return;
        }
        visited[src]=true;
        for (Edge edge:graph[src])
        {
            if(!visited[edge.getNbr()])
            {
                printAllPaths(graph,edge.getNbr(),dest,visited,criteria,k,dsf+edge.getNbr(),
                        wsf+edge.getWeight());
            }
        }
        visited[src]=false;
    }
}
