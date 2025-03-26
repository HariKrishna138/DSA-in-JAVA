class MinHeap{
    int arr[];
    int maxSize,heapSize;
    MinHeap(int maxSize){
        this.maxSize=maxSize;
        heapSize=0;
        arr = new int[maxSize];
    }
    int parent(int i){
        return (i-1)/2;
    }
    int lchild(int i){
        return 2*i+1;
    }
    int rchild(int i){
        return 2*i+2;
    }
    int getMin(){
        return arr[0];
    }
    int curSize(){
        return heapSize;
    }
    void MinHeapify(int i){
        int l=lchild(i);
        int r=rchild(i);
        int smallest = i;
        if(l<heapSize && arr[l]<arr[i]){
            smallest=l;
        }
        if(r<heapSize && arr[r]<arr[smallest]){
            smallest=r;
        }
        if(smallest!=i){
            int temp = arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            MinHeapify(smallest);
        }
    }
    void removeMin(){
        if(heapSize<=0){
            System.out.println("HEAP IS EMPTY");
        }
        if(heapSize==1){
            heapSize--;
        }
        else{
            arr[0]=arr[heapSize-1];
            heapSize--;
            MinHeapify(0);
        }
    }
    void insertkey(int x){
        if(heapSize==maxSize){
            System.out.println("HEAP OVERFLOW");
            return;
        }
        int i = heapSize;
        arr[i]=x;
        heapSize++;
        while(i!=0 && arr[parent(i)]>arr[i]){
            int temp = arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }
    public static void main(String args[]){
        MinHeap h = new MinHeap(16);
        int elements[]={25,41,12,52,88,37};
        for(int e:elements)
            h.insertkey(e);
        System.out.println("The Current Size of the Heap is: "+h.curSize());
        System.out.println("The Current Minimum Element is: "+h.getMin());
        h.removeMin();
        System.out.println("The Current Size of Heap is: "+h.curSize());
        h.insertkey(15);
        h.insertkey(33);
        h.insertkey(2);
        System.out.println("The Current Size of the Heap is: "+h.curSize());
        System.out.println("The Current Minimum element is: "+h.getMin());
    }
}