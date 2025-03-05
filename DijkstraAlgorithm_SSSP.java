import java.util.Scanner;
public class DijkstraAlgorithm_SSSP{
    static final int INF=999;//using 999 as infinity
    private static int chooseMinVertex(int[] dist,boolean[] s,int n){
        int minIndex=-1,min =INF;
        for(int i=0;i<n;i++){
            if(!s[i] && dist[i]<min){
                min=dist[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static void shortestPath(int v,int[][] cost,int[] dist,int n){
        boolean[] s=new boolean[n];
        for(int i=0;i<n;i++){
            dist[i]=cost[v][i];
        }
        s[v]=true;
        for(int num=1;num<n;num++){
            int u=chooseMinVertex(dist,s,n);
            if(u==-1){
                break;
            }
            s[u]=true;
            for(int w=0;w<n;w++){
                if(!s[w]&&dist[u]+cost[u][w]<dist[w]){
                    dist[w]=dist[u]+cost[u][w];
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int n=sc.nextInt();
        int[][] cost=new int[n][n];
        System.out.println("Enter cost matrix(Use 999 for INF):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Source Vertex: ");
        int source=sc.nextInt();
        int[] dist=new int[n];
        shortestPath(source,cost,dist,n);
        System.out.println("Shortest Distance from Source Vertex:");
        for(int i=0;i<n;i++){
            System.out.println("Vertex "+i+" : "+(dist[i]==INF?"INF":dist[i]));
        sc.close();
        }
    }
}
