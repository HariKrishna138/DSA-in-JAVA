import java.util.*;
public class BFSAdjMatrix{
    int v;
    int adj[][];
    public BFSAdjMatrix(int v){
        this.v=v;
        adj=new int[v][v];
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
            for(int i=0;i<v;i++){
                if(adj[vis][i]==1&& !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = sc.nextInt();
        BFSAdjMatrix g = new BFSAdjMatrix(v);
        System.out.println("Enter the adjacency matrix: ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                g.adj[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the starting vertex: ");
        int start = sc.nextInt();
        g.BFS(start);
        sc.close();
    }
}
