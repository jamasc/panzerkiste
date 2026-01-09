package main;

/**
 * 
 * Gibt dem target einen regelmäßigen tick
 * 
 * @author Arne
 *
 */
public class GameDriver implements Runnable{
	
	private Game target;
	private Thread gameThread;
	
	private boolean enabled;
	private boolean running;
	private boolean delayed;
	
	private long frameCount;
	private long startTime;
	

	public GameDriver(Game target) {
		enabled = false;
		running = false;
		delayed = false;
		this.target = target;
	}
	
	
	public void start() {
		if (!running) {
			gameThread = new Thread(this);
			enabled = true;
			gameThread.start();
		}
	}
	
	public void stop() {
		enabled = false;
	}

	@Override
	public void run() {
		if (!running) {
			try {
				updateLoop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void updateLoop() throws InterruptedException {
		running = true;
		startTime = System.currentTimeMillis();
		while(enabled) {
			frameCount++;
			target.tick();
			Thread.sleep(sleepTime());
		}
		running = false;
	}
	
	private long sleepTime() {
		long endTime = this.startTime + frameCount*Config.MILLIS_PER_FRAME;
		long pufferTime = endTime - System.currentTimeMillis();
		if (pufferTime >= 0) {
			return pufferTime;
		} else {
			delayed = true;
			return 0;
		}
	}

}
