
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import br.com.diagnosticit.api.SynchronizedBufferLock;
import br.com.diagnosticit.api.Buffer;
import br.com.diagnosticit.api.Producer;
import br.com.diagnosticit.api.Consumer;

public class SharedBufferTestLock{

	public static void main(String[] args) throws InterruptedException{
	
		ExecutorService executorService = Executors.newCachedThreadPool();		
		Buffer sharedLocation = new SynchronizedBufferLock();
		System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation",
			"Buffer", "Occupied", "---------", "------\t\t--------");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
	
}