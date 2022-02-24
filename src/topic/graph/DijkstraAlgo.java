package topic.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgo {

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
        System.out.println("Enter the vertix pointing to person");
        int starting=sc.nextInt();
        boolean[] visited=new boolean[vertices];
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        getPathUsingDijkstra(graph,starting,visited,""+starting,0,pq);
    }

    private static void getPathUsingDijkstra(ArrayList<Edge>[] graph, int starting, boolean[] visited,String psf,int weight,
                                             PriorityQueue<Integer> pq) {

        pq.add(starting);
        while (pq.size()>0)
        {
            Integer p=pq.remove();
            if(visited[p])
            {
                continue;
            }
            //
            System.out.println(psf+"weight so far "+weight);
            visited[p]=true;
            for (Edge e:graph[p])
            {
                if(visited[e.getNbr()]==false)
                {
                    getPathUsingDijkstra(graph,e.getNbr(),visited,psf+e.getNbr(),weight+e.getWeight(),pq);
                }
            }
        }
    }
}
