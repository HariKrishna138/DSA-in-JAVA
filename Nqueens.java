import java.util.*;
public class Nqueens{
    static int x[];
    public static boolean place(int k,int i){
        for(int j=1;j<k;j++){
            if(x[j]==i||Math.abs(x[j]-i)==Math.abs(j-k)){
                return false;
            }
        }
        return true;
    }
    public static void nqueen(int k,int n){
        if (k>n) {
            for(int j=1;j<=n;j++){
                System.out.println(x[j]+" ");
            }
            System.out.println();
        }
        else{
            for(int i=1;i<=n;i++){
                if(place(k,i)){
                    x[k]=i;
                    nqueen(k+1,n);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of queens: ");
        int n=sc.nextInt();
        x=new int[n+1];
        nqueen(1, n);
        sc.close();

    }
}