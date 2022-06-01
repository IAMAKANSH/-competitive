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
}
