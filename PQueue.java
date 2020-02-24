
public class PQueue {
	
	// PQueue.java defines a priority queue using a max-heap.
	
	private MaxHeap<Process> heap;
	
	
	
	public PQueue() {
		heap = new MaxHeap<Process>();
	}
	
	public void enPQueue(Process process) {
		int key = process.getPriority();
		heap.insert(key, process);
	}
	
	
	public Process dePQueue() {
		return heap.extract();		
	}
	
	public void update(int timeToIncrementLevel, int maxLevel) {
		
		for(int i = 1; i < heap.getSize(); i++) {
			Process process = heap.getValue(i);
			
			process.increaseTimeNotProcessed();
			
			if(process.getTimeNotProcessed() >= timeToIncrementLevel) {
				
				process.resetTimeNotProcessed();
				
				if(process.getTimeNotProcessed() < maxLevel) {
					
					process.increasePriority();
					heap.heapifyUp(i);
				}
			}	
		}
		
		
	}
	
	public boolean isEmpty() {
		return heap.getSize() == 0;
	}
	

}
