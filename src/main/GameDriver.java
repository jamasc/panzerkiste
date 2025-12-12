package main;

/**
 * 
 * Gibt der GameBox einen regelmäßigen Updateimpuls auf einem extra Thread.
 * Gibt einem Panel einen regelmäßigen repaint Impuls.
 * 
 * @author Arne
 *
 */
public class GameDriver implements Runnable{
	
	private GameBox target;
	private Panel graphicTarget;
	private Thread gameThread;
	
	private boolean enabled;
	private boolean running;
	
	private long frameCount;
	private long startTime;
	

	public GameDriver(GameBox kiste, Panel screen) {
		enabled = false;
		running = false;
		this.target = kiste;
		this.graphicTarget = screen;
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
			target.update();
			graphicTarget.repaint();
			Thread.sleep(sleepTime());
		}
		running = false;
	}
	
	private long sleepTime() {
		long endTime = this.startTime + frameCount*Properties.MILLIS_PER_FRAME;
		long pufferTime = endTime - System.currentTimeMillis();
		if (pufferTime >= 0) {
			return pufferTime;
		} else {
			return 0;
		}
	}

}
