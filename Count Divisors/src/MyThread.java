public class MyThread extends Thread {
	//Each thread has a range of numbers to check and stores the number with the most divisors in that range
	private int startNum, endNum, mostDivisors, numWithMostDivisors;
	
	//Initialize the thread with a range of numbers from startNum to endNum
	public MyThread(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
		mostDivisors = 0;
		numWithMostDivisors = 0;
	}
	
	//Override the run method for the Thread object
	//Each thread will find the number with the most divisors in its specified range and store it
	public void run() {
		for(int x = startNum; x < endNum; x++) {
			int currentCount = countDivisors(x);
			if(currentCount >= mostDivisors) {
				setMostDivisors(currentCount);
				setNumWithMostDivisors(x);
			}
		}
	}
	
	//Method to find the amount of divisors for a given number
	public int countDivisors(int num) {
		int numDivisors = 0;
		for(int x = 1; x <= num; x++) {
			if(num % x == 0) {
				numDivisors++;
			}
		}
			
		return numDivisors;
	}
	
	public int getMostDivisors() {
		return mostDivisors;
	}
	
	public int getNumWithMostDivisors() {
		return numWithMostDivisors;
	}
	
	public void setMostDivisors(int mostDivisors) {
		this.mostDivisors = mostDivisors;
	}
	
	public void setNumWithMostDivisors(int numWithMostDivisors) {
		this.numWithMostDivisors = numWithMostDivisors;
	}

}
