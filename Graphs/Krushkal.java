package Graphs;

class MST{
    static int vertices = 5;
    static int[] parent = new int[vertices]; 
    static int INF = Integer.MAX_VALUE; 

    MST(){
        
    }

    public void Krushkal(int[][] graph){
        int mincost = 0; // Cost of min MST. 
        
        this.makeSet();
        
        int edge_count = 0; 
        while (edge_count < vertices - 1) {
            int min = INF, a = -1, b = -1; 
            for (int i = 0; i < vertices; i++) 
            { 
                for (int j = 0; j < vertices; j++)  
                { 
                    if (findRepresentative(i) != findRepresentative(j) && graph[i][j] < min)  
                    { 
                        min = graph[i][j]; 
                        a = i; 
                        b = j; 
                    } 
                } 
            }
            union(a, b); 
            System.out.printf("Edge %d:(%d, %d) cost:%d \n", 
                edge_count++, a, b, min); 
            mincost += min;  
        }
        System.out.printf("\n Minimum cost= %d \n", mincost); 
    }
    
    public int findRepresentative(int vertex){
        while(parent[vertex] != vertex){
            vertex = parent[vertex];
        }
        return vertex;
    }
    
    public void makeSet(){
        // Initialize sets of disjoint sets. 
        for (int i = 0; i < vertices; i++) 
            parent[i] = i; 
    }
    
    public void union(int vertexA, int vertexB){
        // without using rank
        int x_set_representative = this.findRepresentative(vertexA);
        int y_set_representative = this.findRepresentative(vertexB);
        parent[y_set_representative ] = x_set_representative;
    }
}

public class Krushkal {
    /* Let us create the following graph 
        2 3 
        (0)--(1)--(2) 
        | / \ | 
        6| 8/ \5 |7 
        | /     \ | 
        (3)-------(4) 
            9         */
    public static void main(String[] args){
        int INF = Integer.MAX_VALUE; 
        int cost[][] = { 
                { INF, 2, INF, 6, INF }, 
                { 2, INF, 3, 8, 5 }, 
                { INF, 3, INF, INF, 7 }, 
                { 6, 8, INF, INF, 9 }, 
                { INF, 5, 7, 9, INF }, 
            }; 
        MST mst = new MST();
        mst.Krushkal(cost);
    }
}