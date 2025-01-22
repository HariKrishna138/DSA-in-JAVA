import java.util.*;
public  class quicksort{
    public static int partition(int a[],int low,int high){
        int pivot=a[low],i=low+1,j=high;
        while(i<=j){
            while((a[i]<=pivot) && (i<=j)){
                i++;
            }
            while((a[j]>=pivot)&&(i<=j)){
                j--;
            }
            if(i<j){
                swap(a,i,j);
            }
        }
        swap(a,j,low);
        return j;
    }
    public static void quicksort(int a[],int low,int high){
        if(low<high){
            int j=partition(a,low,high);
            quicksort(a,low,j-1);
            quicksort(a,j+1,high);
        }
    }
    public static void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter Array elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        quicksort(a,0,n-1);
        for(int l:a){
            System.out.println(l);
        }
    }
}