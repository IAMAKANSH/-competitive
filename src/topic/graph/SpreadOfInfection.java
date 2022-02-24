package topic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpreadOfInfection {

    static class Pair{
        int v;
        int time;
        Pair(int v,int time){
            this.v=v;
            this.time=time;
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
        System.out.println("Enter the vertix pointing to person");
        int starting=sc.nextInt();
        System.out.println("Enter the time at which we want it");
        int time=sc.nextInt();
        int[] visited=new int[vertices];
        Arrays.fill(visited,-1);
        int count= spreadDisease(graph, visited, starting,time);
    }

    private static int spreadDisease(ArrayList<Edge>[] graph, int[] visited, int starting,int time) {
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(starting, 0));
        int count=0;
        while (queue.size()>0)
        {

            Pair rem=queue.removeFirst();
            if(visited[rem.v]>0)
            {
                continue;
            }
            visited[rem.v]=rem.time;
            if(rem.time>time)
            {
                break;
            }
            count++;
            for (Edge e: graph[rem.v])
            {
                if(visited[e.getNbr()]==0)
                {
                    queue.add(new Pair(e.getNbr(),rem.time+1));
                }
            }
        }
        return count;
    }
}

