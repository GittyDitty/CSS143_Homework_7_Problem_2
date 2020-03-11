public class MaxHeap implements Heap {
    int capacity;
    int size;
    Integer[] data;

    public MaxHeap(int size) {
        this.size = size;
        data = new Integer[size];
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int kthChild(int i, int k){
        return 2*i + k;
    }

    public boolean isFull(){
        return size == capacity;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(isFull()){
            return false;
        }else{
            data[size++] = item;
            maxHeapifyUp(size-1);
        }
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        return findMax();
    }

    // remove the root item
    public Integer pop() {
        // homework
        if(isEmpty()){
            return null;
        }
        int key = data[findMax()];
        data[findMax()] = data[size-1];
        size--;
        maxHeapifyDown(findMax());
        return key;
    }

    public boolean equals(){
        //.equals method for comparing heaps which is needed?
        return false;
    }

    private void maxHeapifyUp(int i) {
        int temp = data[i];
        while(i>0 && temp> data[parent(i)]){
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = temp;
    }

    private void maxHeapifyDown(int i){
        int child;
        int temp = data[i];
        while (kthChild(i,1) < size){
            child = maxChild(i);
            if(temp < data[child]){
                data[i] = data[child];
            }else {
                break;
            }
            i = child;
        }
        data[i] = temp;
    }

    //returns the max child inside of the heap
    private int maxChild(int i){
        int leftChild = kthChild(i,1);
        int rightChild = kthChild(i,2);

        return data[leftChild]>data[rightChild]?leftChild:rightChild;
    }

    //Returns the max element of the heap or heap[0]
    public int findMax(){
        if (isEmpty()){
            return 0;
        }
        return data[0];
    }

}
