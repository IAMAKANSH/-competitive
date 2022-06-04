package challenge;

import java.util.*;

public class Day25GraphQuestion1 {


    public static void main(String[] args) {
        Map<String, List<String>> map=new HashMap<>();
        map.put("A", Arrays.asList("B","F"));
        map.put("B", Arrays.asList("A","F","C"));
        map.put("C", Arrays.asList("B","E","D"));
        map.put("D", Arrays.asList("C","E"));
        map.put("E", Arrays.asList("D","C","F"));
        map.put("F", Arrays.asList("A","B","E"));
        List<String> response=travBFS(map,"A");
        System.out.println(response);
        Map<String, List<String>> map2=new HashMap<>();
        map2.put("A", Arrays.asList("B","F"));
        map2.put("B", Arrays.asList("A","C"));
        map2.put("C", Arrays.asList("B","E","D"));
        map2.put("D", Arrays.asList("C","E"));
        map2.put("E", Arrays.asList("D","C","F"));
        map2.put("F", Arrays.asList("A","E"));
        List<String> response1=dfsRecursive(map2,"A");
        System.out.println(response1);
    }

    public static List<String> travBFS(Map<String,List<String>> graph,String startPoint)
    {
        Map<String,Boolean> visited=new HashMap<>();
        List<String> response=new ArrayList<>();
        ArrayDeque<String> queue=new ArrayDeque<>();
        queue.add(startPoint);
        visited.put(startPoint,true);
        while(!queue.isEmpty())
        {
            String currentVertex=queue.removeFirst();
            response.add(currentVertex);
            List<String> neighbours=graph.get(currentVertex);
            for (String neighbour:neighbours
                 ) {
                if(visited.get(neighbour)==null)
                {
                    queue.add(neighbour);
                    visited.put(neighbour,true);
                }
            }

        }
        return response;
    }

    public static List<String> dfsRecursive(Map<String,List<String>> graph,String startingPoint)
    {
        List<String> response=new ArrayList<>();
        Map<String,Boolean> visited=new HashMap<>();
        dfsHelper(graph,startingPoint,response,visited);
        return response;
    }
    //we can use iterative using stack
    private static void dfsHelper(Map<String, List<String>> graph, String startingPoint, List<String> response, Map<String, Boolean> visited) {
        // A,B,C,E,D,F
        response.add(startingPoint);
        visited.put(startingPoint,true);
        List<String> neighbours=graph.get(startingPoint);
        for (String neighbour:neighbours
             ) {

            if(visited.get(neighbour)==null)
            {
                dfsHelper(graph,neighbour,response,visited);
            }
        }
        return;
    }
}
