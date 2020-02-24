public class HeapNode<T> {

    private int key;
    private T value;

    public HeapNode(int key, T value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }
    public T getValue(){
        return value;
    }
    public void setKey(int n){
            key = n;
    }


}
