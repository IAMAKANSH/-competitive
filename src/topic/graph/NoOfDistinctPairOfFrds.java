package topic.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoOfDistinctPairOfFrds {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of frds");
        int noOfFrds=sc.nextInt();
        System.out.println("Enter no of friendship");
        int frdships=sc.nextInt();
        Scanner scm=new Scanner(System.in);
        ArrayList<Edge>[] graph=new ArrayList[noOfFrds];
        for (int i=0;i<noOfFrds;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for (int i=0;i<frdships;i++)
        {
            System.out.println("Enter the relationships");
            String[] relation=scm.nextLine().split("\\s");
            int frd1=Integer.parseInt(relation[0]);
            int frd2=Integer.parseInt(relation[1]);
            graph[frd1].add(new Edge(frd1,frd2,0));
            graph[frd2].add(new Edge(frd2,frd1,0));
        }
        ArrayList<List<Integer>> combination=new ArrayList<>();
        boolean[] visited=new boolean[noOfFrds];
        for (int i=0;i<noOfFrds;i++)
        {
            if(!visited[i])
            {
                List<Integer> frdGroup=new ArrayList<>();
                noOfConnections(graph,visited,i,frdGroup);
                combination.add(frdGroup);
            }
        }
        int sumOfPair=0;
       for (int i=0;i<combination.size();i++)
       {
           for (int j=i+1;j<combination.size();j++)
           {
               sumOfPair +=combination.get(i).size()*combination.get(j).size();
           }
       }
        System.out.println(combination);
        System.out.println("Sum is :: "+sumOfPair);
    }

    private static void noOfConnections(List<Edge>[] graph, boolean[] visited, int i, List<Integer> frdGroup) {
        visited[i]=true;
        frdGroup.add(i);
        for (Edge edge:graph[i])
        {
            if(!visited[edge.getNbr()])
            {
                noOfConnections(graph,visited,edge.getNbr(),frdGroup);
            }
        }
        return;
    }
}
