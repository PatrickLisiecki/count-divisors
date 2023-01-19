import java.text.DecimalFormat;
import java.text.NumberFormat;
public class ThreadRunner {

	public static void main(String[] args) {
		//Time that the program begins executing
		long startTime = System.currentTimeMillis();
		
		//Set the amount of numbers to check and the number of threads to use
		final int LIMIT = 10000;
		final int NUM_THREADS = 16;
		
		int mostDivisors = 0, numWithMostDivisors = 0;
		
		//Create array of threads
		MyThread[] workerThreads = new MyThread[NUM_THREADS];
		
		//Divide the amount of numbers that each thread will handle
		//The last thread will deal with the remainder of numbers
		int limitPerThread = LIMIT / NUM_THREADS;
		int startNum = 1;
		int endNum = limitPerThread;
		
		//Split the data between the threads
		for(int x = 0; x < NUM_THREADS; x++) {
			//Last thread deals with the remainder of numbers
			if(x == NUM_THREADS - 1) {
				endNum = LIMIT;
			}
			
			//Initialize each thread with its range
			workerThreads[x] = new MyThread(startNum, endNum);
			
			//Set new range values for the next thread
			startNum = endNum + 1;
			endNum = startNum + limitPerThread - 1;
		}
		
		//Begin running each thread
		for(int x = 0; x < NUM_THREADS; x++) {
			//start() is used to run each thread rather than run()
			workerThreads[x].start();
		}
		
		//Join the threads to make sure that all threads finish executing before the next line of code executes
		for(int x = 0; x < NUM_THREADS; x++) {
			while(workerThreads[x].isAlive()) {
				try {
					workerThreads[x].join();
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
		
		//Find which thread stored the number with the most divisors
		for(MyThread x : workerThreads) {
			int currentMostDivisors = x.getMostDivisors();
			if(currentMostDivisors >= mostDivisors) {
				mostDivisors = currentMostDivisors;
				numWithMostDivisors = x.getNumWithMostDivisors();
			}
		}
		
		System.out.println("Integer with the most divisors: " + numWithMostDivisors + "\nDivisors: " + mostDivisors);

		//Time that the program finished executing formatted into seconds
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.println("Time spent: " + formatter.format((endTime - startTime) / 1000d) + " seconds.");
	}

}
