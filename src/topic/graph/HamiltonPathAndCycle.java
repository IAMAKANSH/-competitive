package topic.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonPathAndCycle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the vertices");
        int vertices=sc.nextInt();
        System.out.println("Enter the edges");
        int edges=sc.nextInt();
        System.out.println("Enter the source");
        int src=sc.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[edges];
        for (int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        Scanner scm=new Scanner(System.in);
        for (int i=0;i<edges;i++)
        {
            System.out.println("Enter edge between paths");
            String[] rel=scm.nextLine().split("\\s");
            int v1=Integer.parseInt(rel[0]);
            int v2=Integer.parseInt(rel[1]);
            int wt=Integer.parseInt(rel[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        HashSet<Integer> visited=new HashSet<>();
        hamiltonian(graph,visited,src,""+src,src);
    }

    private static void hamiltonian(ArrayList<Edge>[] graph, HashSet<Integer> visited, int src, String s,
                                    int original) {
        if(visited.size()== graph.length-1)
        {
            System.out.println(s);
            boolean closingEdgeFound=false;
            for (Edge e:graph[src])
            {
                if(e.getNbr()==original)
                {
                    closingEdgeFound=true;
                    break;
                }
            }
            if(closingEdgeFound==true)
            {
                System.out.println(s+"*");
            }
            else {
                System.out.println(s+".");
            }
            return;
        }
        visited.add(src);
        for (Edge e:graph[src])
        {
            if(visited.contains(e.getNbr())==false)
            {
                hamiltonian(graph,visited,e.getNbr(),s+e.getNbr(),original);
            }
        }
        visited.remove(src);
    }
}

