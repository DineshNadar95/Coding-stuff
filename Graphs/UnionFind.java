class Graph {
    int V, E;
    Edge[] edge;

    class Edge{
        int src, dest;
    }

    public Graph(int V,int E){
        this.V = V;
        this.E = E;
        edge = new Edge[E];
        for(int i=0; i<E; i++){
            edge[i] = new Edge();
        }
    }

    int find(int[] parent, int i){
        if(parent[i] == -1)
            return i;
        
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    boolean isCycle(Graph graph){
        int[] parent = new int[graph.V];

        // init parent array
        for(int i=0; i<graph.V; i++){
            parent[i] = -1;
        }

        for(int i=0; i<graph.E; i++){
            int x = find(parent, graph.edge[i].src);
            int y = find(parent, graph.edge[i].dest);

            if(x == y)
                return true;
            
            graph.union(parent, x, y);
        }

        return false;
    }
}

public class UnionFind {
    public static void main(String[] args){
        System.out.println("hello");
        int V = 3;
        int E = 3;

        Graph graph = new Graph(V,E);
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        // add edge 1-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
        if(graph.isCycle(graph))
            System.out.println("Cycle exists");
        else
            System.out.println("No cycle exists");
    }
}