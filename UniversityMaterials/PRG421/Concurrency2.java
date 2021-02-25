/**
 * Synchronized Concurrency Thread Program written in Java.
 * By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com
 * Class PRG/421 - Mitchell Williams
**/
class Concurrency2{

  private final static Concurrency2 con = new Concurrency2();

	//Method named atomic as required from prior instructions.
	public static void atomic(int x){
    //synchronized lock to make sure that other threads do not corrupt the state
    synchronized(con){
		  for(int i = 0; i <= 10; i++){
			  System.out.println("Thread " + x + "= " + i);
		  }
    }
	}

	//Inside main() two threads are created to concurrently call atomic method
	public static void main(String[] args) throws InterruptedException{
		//Calls atomic
		Thread thread1 = new Thread(()->{
		  atomic(1);
		});

		//Also calls atomic
		Thread thread2 = new Thread(()->{
		  atomic(2);
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}

}
