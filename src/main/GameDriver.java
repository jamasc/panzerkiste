package main;

/**
 * 
 * Gibt der GameBox einen regelm‰ﬂigen Updateimpuls auf einem extra Thread.
 * Gibt einem Panel einen regelm‰ﬂigen repaint Impuls.
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
		while(enabled) {
			target.update();
			graphicTarget.repaint();
			Thread.sleep(100);
		}
		running = false;
	}

}
