import java.util.*;
public class  BFSAdjList{
    int v;
    LinkedList<Integer>[]adj;
    public  BFSAdjList(int v){
        this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]= new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
    public void BFS(int start){
        boolean visited[] = new boolean[v];
        Arrays.fill(visited,false);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int vis = q.poll();
            System.out.print(vis+" ");
            for(int neighbour:adj[vis]){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour]=true;  }             
           }
        }   
        }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
         BFSAdjList g = new  BFSAdjList(v);
        System.out.println("Enter the edges(src and dest): ");
        for(int i=0;i<e;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src,dest);
        }
        System.out.println("Enter the starting vertex: ");
        int start = sc.nextInt();
        g.BFS(start);
        sc.close();
    }
}
