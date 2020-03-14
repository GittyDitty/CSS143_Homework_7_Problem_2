public class MaxHeap implements Heap {
    int capacity; //amount inside of each which is initialized to zero
    int size;     //
    Integer[] data;

    public MaxHeap(int size) {
        this.size = size;
        data = new Integer[size];
        capacity = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    // just use a for loop and add everything into the heap
    public void MaxHeapLogN(Integer[] data) {
        // homework
        if(data.length == 0){
            System.out.println("Error in assigning max heap of zero");
        }
        for(int i=0; i<data.length;i++){
            add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    // based on the lecture given we do this by simply putting the data[]
    // and simply make it into a heap then use maxHeapifyUp to make it into a maxHeap
    public void MaxHeapN(Integer[] data) {
        // homework
        for(int i=0; i<data.length; i++) {
            this.data[capacity++] = data[i];
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if(isFull()){
            return false;
        }else{
            data[capacity] = item;
            capacity++;
            maxHeapifyUp(capacity-1);
        }
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        return data[findMax()];
    }

    // remove the root item
    public Integer pop() {
        // homework
        if(isEmpty()){
            return null;
        }
        int key = findMax();
        data[key] = data[capacity-1];
        capacity--;
        maxHeapifyDown(key);
        return key;
    }

    //Compare this max heap to the contents of the other max heap
    public boolean equals(MaxHeap other){
        //.equals method for comparing heaps which is needed
        if(this.size == other.size && this.capacity == other.capacity){
            for(int i =0; i< this.size; i++){
                if(this.data[i] != other.data[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //Utilized mainly in the add function for scaling from the top to bottom
    private void maxHeapifyUp(int i) {
        int temp = data[i];
        while(i > 0 && temp > data[parent(i)]){
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = temp;
    }

    //Utilized mainly in the pop function for scaling from the bottom to top
    private void maxHeapifyDown(int i){
        int child;
        int temp = data[i];
        while (kthChild(i,1) < capacity){
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

        //Good lord I have no idea what I did here but by god if it doesn't work well
        return data[leftChild]>data[rightChild]?leftChild:rightChild;
    }

    //Returns the max element of the heap or heap[0] (root)
    public int findMax(){
        if (isEmpty()){
            return 0;
        }
        return 0;//return the root
    }

    private int parent(int i){
        if(i%2 == 0){
            return (i-2)/2;
        }else{
            return (i-1)/2;
        }
    }

    //function that can return the kth child (left or right based on #)
    private int kthChild(int i, int k){
        return 2*i + k;
    }

    //Implemented so that there is no need to type if(size == capacity) over and over again
    public boolean isFull(){
        return size == capacity;
    }

    //Implemented so that there's no need to retype if(size == 0) over and over again
    private boolean isEmpty(){
        return size == 0;
    }

}
