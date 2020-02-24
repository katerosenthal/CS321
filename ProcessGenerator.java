import java.util.Random;

/*
 * ProcessGenerator.java randomly generates processes with a given probability. At beginning
 * of each time unit, whether a process will arrive is decided by the given probability. In addition,
 * while generating a new process, both its priority and the required time units to finish the
 * process are randomly generated within given ranges.
 */

public class ProcessGenerator {
	
	private double processProbability;

	public ProcessGenerator(double probability) {
		processProbability = probability;
	}
	
	public boolean query() {
		Random randomizer = new Random();
		
		boolean result = (randomizer.nextDouble() < processProbability) ;
		
		return result;
	}
	
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		
		Random randomizer = new Random();
		
		int priorityLevel = randomizer.nextInt(maxLevel) + 1; //+1 to remove inclusive 0 and exclusive max
		int timeRemaining = randomizer.nextInt(maxProcessTime) + 1;
		int arrivalTime = currentTime;
		
		
		return new Process(priorityLevel, timeRemaining, arrivalTime);
	}
	

}
