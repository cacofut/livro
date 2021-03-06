package br.com.diagnosticit.api;

import java.security.SecureRandom;

public class Producer implements Runnable{

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;
	
	public Producer( Buffer sharedLocation ){
		this.sharedLocation = sharedLocation;
	}
	
	public void run(){
		int sum = 0;
		for( int i = 1; i <= 10; i++ ){
			try{
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.blockingPut(i);
				sum += i;
				//System.out.printf("\t%2d\n", sum );
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing\nTermination Producer\n");
	}
}