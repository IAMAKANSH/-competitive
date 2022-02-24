package topic.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrismAlgo {

    public static class Pair implements Comparator<Pair> {
         int v;
         int av;
         int wt;

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.wt-o2.wt;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the no of vertices");
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        System.out.println("Enter the no of edges");
        int edges = sc.nextInt();
        for (int j = 0; j < edges; j++) {
            Scanner sc1 = new Scanner(System.in);
            String[] parts = sc1.nextLine().split("\\s");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        System.out.println("Enter the vertix pointing to person");
        int src= sc.nextInt();
        boolean[] visited=new boolean[vertices];
        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(new Pair(src,-1,0));
        while (priorityQueue.size()>0)
        {
            Pair pair=priorityQueue.remove();
            if(visited[pair.v]==true)
            {
                continue;
            }
            visited[pair.v]=true;
            if(pair.av!=-1)
                System.out.println(pair.v+"@"+ pair.av+"weight:"+ pair.wt );
            for (Edge e:graph[pair.v])
            {
                if(visited[e.getNbr()]==false)
                {
                    priorityQueue.add(new Pair(e.getNbr(), pair.v, e.getWeight()));
                }
            }
        }
    }
}
