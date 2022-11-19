import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V;

    ArrayList<ArrayList<Integer>> graph;
    Graph(int nodes) {

        V= nodes;
        graph = new ArrayList<ArrayList<Integer>>();


        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

    }


    void addEdge(int v, int u) {
        graph.get(v).add(u);
        graph.get(u).add(v);

    }


    void printGraph()  {
        for (int i = 0; i < V; i++) {
            System.out.println( "Node " + i);

            for(int x : graph.get(i)) {
                System.out.print("child " + x + " ");
            }
            System.out.println();

        }
    }

    void BFS (int start) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start]= true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            System.out.println("Node " + n  );
              for(int c : graph.get(n)) {
                  if(!visited[c]) {
                      visited[c]= true;
                      queue.add(c);
                  }
              }

            }


        }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(3,2);
        g.addEdge(2,4);
        g.addEdge(1,4);

        g.addEdge(3,1);
        g.addEdge(2,0);
        g.printGraph();
        g.BFS(0);



    }

    }

