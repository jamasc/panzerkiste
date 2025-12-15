package main;
import java.awt.Dimension;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * Stellt das ganze Spiel dar.
 * Baut sich selber auf.
 * Kann gestartet und pausiert werden.
 * Enthält eine GameBox und einen GameDriver und ein Panel;
 * Laufende Zeit heißt, dass tick aufgerufen wird.
 * 
 *
 * @author Arne
 *
 */
public class Game {

	private GameBox kiste; //Spiel Kiste
	private GameDriver driver; //sendet ticks
	private Panel screen; //visueller Output

	private State state;


	/**
	 * Muss das Spiel startklar machen
	 */
	public Game() {
		this.init();
		this.load();
	}


	public void startGame() {
		switch (this.state) {
		case STANDBY:
			driver.start();
			state = State.RUNNING;
			break;
		}
	}

	public void stopGame() {
		switch (this.state) {
		case RUNNING:
			driver.stop();
			state = State.STANDBY;
			break;
		}
	}
	
	/**
	 * Wird, wenn das Spiel läuft, mit der Frequenz FPS aufgerufen
	 */
	public void tick() {
		switch (this.state) {
		case RUNNING:
			this.kiste.update();
			this.screen.repaint();
			break;
		}
	}

	public Panel getPanel() {
		return screen;
	}


	/**
	 * Initialisiert alle Attribute
	 */
	private void init() {
		this.state = State.LOADING;
		this.setupScreen();
		this.setupDriver();
	}
	
	/**
	 * wird aufgerufen, wenn das Spiel etwas neues laden soll
	 * danach soll das Spiel im state STANDBY sein.
	 */
	private void load() {
		state = State.LOADING;
		setupKiste();
		state = State.STANDBY;
	}

	private void setupKiste() {
		this.kiste = new TestLevel();
		screen.show(kiste);
	}

	private void setupDriver() {
		this.driver = new GameDriver(this);
	}

	private void setupScreen() {
		this.screen = new Panel();
	}




	public static void main(String[] args) {

		Game game = new Game();
		Panel screen = game.getPanel();
		JFrame frame = new JFrame("Hello World");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(screen);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.startGame();
		
		ScheduledExecutorService executor =
		        Executors.newSingleThreadScheduledExecutor();
		//executor.schedule(() -> game.stopGame(), 5, TimeUnit.SECONDS); // 2 Sekunden warten

	}

}
