import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap<T extends Comparable<T>> {

    private ArrayList<HeapNode<T>> array;
    private int size;

    private int parent(int i){
        return i/2;
    }
    private int left(int i){
        return 2*i;
    }
    private int right(int i){
        return 2*i+1;
    }

    public MaxHeap(){
        array = new ArrayList<HeapNode<T>>(10);
        array.add(null);
        size = 0;
    }

    public void insert(int key, T value){
        HeapNode<T> node = new HeapNode<T>(key, value);
        array.add(node);
        size++;
        Collections.swap(array, 1, size);
        heapifyDown(1);
    }

    public T extract(){
        Collections.swap(array, 1, size);
        T retval = array.remove(size).getValue();
        size--;
        heapifyDown(1);
        return retval;
    }

    public void heapifyDown(int i){

        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l <= size && array.get(l).getValue().compareTo(array.get(i).getValue()) == -1){
            largest = l;
        }

        if (r <= size && array.get(r).getValue().compareTo(array.get(largest).getValue()) == -1){
            largest = r;
        }

        if (largest != i){
            Collections.swap(array, i, largest);
            heapifyDown(largest);
        }

    }
    public void heapifyUp(int i){

        int p = parent(i);

        if(i > 1 && array.get(i).getValue().compareTo(array.get(p).getValue()) == 1){ //not root and key is bigger than parent's key
            Collections.swap(array, i, p);
            heapifyUp(p); //recurse on parent
        }
    }

    public void updateKey(int i, int key){

        int current = array.get(i).getKey();
        array.get(i).setKey(key);

        if(current < key) {
            heapifyUp(i); //key grew so it needs to go up
        } else if(current > key){
            heapifyDown(i);//key shrunk so it needs to go down
        }
        //else key stayed the same, so no update is necessary
    }

    public int getSize(){
        return size;
    }
    
    public T getValue(int i) {
    	return array.get(i).getValue();
    }

    public String toString(){

        StringBuilder str = new StringBuilder("{");

        for (int i = 1; i <= size; i++){
            str.append(array.get(i).getValue().toString() + ", ");
        }

        if(str.length() > 1){
            str.delete(str.length()-2, str.length()-1);
        }

        str.append("}");

        return str.toString();
    }

}
