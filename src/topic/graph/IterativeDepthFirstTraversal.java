package topic.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class IterativeDepthFirstTraversal {

    public static class Pair{
    int v;
    String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
        int src = sc.nextInt();

        boolean[] visited = new boolean[vertices];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(src, "" + src));
        while (stack.size() > 0) {
            Pair p = stack.pop();
            if (visited[p.v] == true) {
                continue;
            }
            visited[p.v] = true;
            System.out.println(p.v + "@" + p.psf);
            for (Edge e : graph[p.v]) {
                if(visited[e.getNbr()]==false)
                {
                    stack.push(new Pair(e.getNbr(), p.psf+e.getNbr()));
                }
            }
        }
    }
}
