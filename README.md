# Count Divisors

This is a multithreaded application developed in Java to find the integer in the range 1 to 10000 that has the largest number of divisors. The application prints the integer with the highest number of divisors, as well as the time taken to complete the calculation. It utilizes multithreading to optimize the performance and speed of the program.

## Prerequisites

Before running this application, ensure that you have the following installed on your system:

- Java Development Kit (JDK)
- Any Java IDE or text editor of your choice (e.g., Eclipse, IntelliJ IDEA, Visual Studio Code)

## Getting Started

Follow the steps below to set up and run the application:

1. Clone the repository or download the source code files to your local machine.
2. Open the Java IDE or text editor and import the project.
3. Run the `ThreadRunner.java` file to execute the program.

## Description

The application uses a multithreaded approach to search for the integer with the largest number of divisors within the range of 1 to 10000. It divides the search space evenly among the available threads, allowing for concurrent execution of divisors calculation.

The steps performed by the application are as follows:

1. It starts a timer to measure the execution time.
2. The application initializes the main variables (these can be changed as you wish):

    ```java
      // Set the amount of numbers to check and the number of threads to use
      final int LIMIT = 10000;
      final int NUM_THREADS = 16;
    ```

3. The search space (1 to LIMIT) is divided equally among the threads.
4. Each thread calculates the number of divisors for the integers within its assigned range.
5. Once all threads have finished their calculations, the application determines the integer with the largest number of divisors.
6. The application displays the integer with the highest number of divisors and the time taken to complete the calculation.

## Assignment Report

### 1. How long it took your app to finish the job when using 1 thread?

The application took about 0.19 seconds to execute when using one thread on my machine.

### 2. How many threads can your machine run simultaneously?

My CPU in my personal computer has 8 cores and 16 threads.

### 3. How long it took your app to finish the job when using all available threads?

The application took about 0.05 seconds to execute when using all 16 threads.

### 4. Did you use task or data parallelization for this program? Why?

I utilized data parallelization for my program. This is because each of the 16 threads performed the same task which was to find the number with the most divisors in a certain range. Every thread ran a method that took in an integer representing the start number and an integer representing the end number. The method then ran a loop from the start to end and saved the number that had the most divisors in its respective range of numbers. I split the numbers up between the threads by dividing 10,000 by the number of the threads and then the last thread was assigned with the remainder of numbers.

## Results


### Using one thread:
![One Thread](https://github.com/PatrickLisiecki/count-divisors/assets/96704934/66428270-6fca-4ace-895a-9938ae5f90f8)

### Using 16 threads:
![16 Threads](https://github.com/PatrickLisiecki/count-divisors/assets/96704934/aca891e8-844d-4cd8-93ca-0470bf43c6b3)

## Conclusion

This multithreaded application successfully finds the integer in the range 1 to 10000 with the largest number of divisors. By leveraging multiple threads, the program achieves improved performance and reduces the overall execution time. The assignment report provides insights into the execution time for different scenarios and clarifies the choice of data parallelization for this specific program.
