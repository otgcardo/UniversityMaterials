/**
 * Non Synchronized Concurrency Thread Program written in Java.
 * By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com
 * Class PRG/421 - Mitchell Williams
**/
class Concurrency{

	//This method is used concurrently
	public static void atomic(int x){
		for(int i = 0; i <= 10; i++){
			System.out.println("Thread " + x + "= " + i);
		}
	}

	//Inside main() two threads are created to concurrently call atomic method
	public static void main(String[] args) throws InterruptedException{
		//Calls atomic
		Thread thread1 = new Thread(new Runnable(){
			@Override
			public void run(){ atomic(1); }
		});

		//Also calls atomic
		Thread thread2 = new Thread(new Runnable(){
			@Override
			public void run(){ atomic(2); }
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}

}
