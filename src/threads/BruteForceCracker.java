package threads;
// Below is a completed program that uses brute force to crack a 9-digit password. 
// On average, the program takes about 0.125 seconds to find the password.
// Your goal is to re-write the algorithm using Threads. Try to shorten the time it takes 
// to find the code to be as little as possible.
// Let's see who can crack the code the fastest!

// Pro-tip: Do not include the creation of the threads as part of the time. 

import java.util.Random;

public class BruteForceCracker {
	static long code = (long)(new Random().nextDouble() * 1_000_000_000);
	
	static long startTime;
	static long endTime;
	static float elapsedTime;
	static boolean isFound = false;
	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
		startTime = System.currentTimeMillis();
		/*int ctr = 0;
		while(!checkCode(ctr++));*/
		while(isFound == false) {
			for (int i = 1; i < 3; i++) {
				final int l = i;
				Thread one = new Thread(()->{
					
					for (long z = 1_000_000_000/l; z > -1; z--) {
						checkCode(z);
						System.out.println(z);
					}
				});
				one.start();
			}
		}
		
		endTime = System.currentTimeMillis();
		elapsedTime = (float)(endTime - startTime);
		elapsedTime /= 1000.f;
		System.out.println("Total time taken: " + elapsedTime + " seconds");
	}
	
	public static boolean checkCode(long p){
		if(p == code){
			isFound = true;
			return true;
		}else{
			return false;
		}
	}
}
