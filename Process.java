
/*
 * Process.java defines a process. You need to implement the compareTo method in this class.
 * Each process has a priority level, time remaining to finish, and arrival time.
 */

public class Process implements Comparable<Process> {

	int priorityLevel;
	int timeRemaining; // Should be a time??
	int arrivalTime;
	int timeNotProcessed;

	Process(int priority, int timeLeft, int timeIn) {

		this.priorityLevel = priority;
		this.timeRemaining = timeLeft;
		this.arrivalTime = timeIn;
		timeNotProcessed = 0;

	}

	public int getPriority() {

		return priorityLevel;

	}

	public void increasePriority() {

		priorityLevel++;

	}

	public int getTimeRemaining() {

		return timeRemaining;

	}

	public void reduceTimeRemaining() {

		timeRemaining--;
	}

	public int getArrivalTime() {

		return arrivalTime;

	}


	public boolean finish() {
		return (timeRemaining == 0);
	}
	
	public int getTimeNotProcessed(){
		return timeNotProcessed;
	}
	public void increaseTimeNotProcessed(){
		timeNotProcessed++;
	}
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}

	// Should return 1, -1, 0?
	@Override
	public int compareTo(Process p) {

		int result = 0;

		if(getPriority() > p.getPriority()) {
			result = 1;
		} else if(getPriority() < p.getPriority()) {
			result = -1;
		} else if(getArrivalTime() < p.getArrivalTime()) {
			result = 1;
		} else if(getArrivalTime() > p.getArrivalTime()) {
			result = -1;
		}		

		return result;
	}


}
