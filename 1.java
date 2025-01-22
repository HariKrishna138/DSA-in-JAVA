class merge{
    public static void merge(int a[],int low,int mid,int high){
        i=low;j=mid+1;k=low;
        while((i<=mid)&&(j<=high)){
            if(a[i]<a[j]){
                b[k]=a[i];
                i+=1;
            }
            else{
                b[k]=a[j];
                j+=1;
            }
        }
        while(i<=mid){
            b[k]=a[i];
            i+=1;
            k+=1;
        }
        while(j<=mid){
            b[k]=a[j];
            j+=1;
            k+=1;
        }
        for(int h=low;h<high;h++){
            a[h]=b[h];
        }
    }
}
class 1{
    public static void mergesort(int a[],int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n=sc.nextInt();
        int a[]=new int[n];
        int low=0,high=n-1;
        System.out.println("Enter Array Elements:");
        for(int i=o;i<n;i++){
            a[i]=sc.nextInt();
        }
        mergesort(a,low,high);
        for(int k:a){
            System.out.println(k);
        }
    }
}