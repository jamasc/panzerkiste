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
 * Enthält eine GameBox und einen GameDriver
 *
 *
 * @author Arne
 *
 */
public class Game {

	private GameBox kiste;
	private GameDriver driver;
	private Panel screen;

	private State state;


	/**
	 * Muss das Spiel startklar machen
	 */
	public Game() {
		this.init();
	}


	public void startGame() {
		if (state == State.PAUSING) {
			driver.start();
			state = State.RUNNING;
		}
	}

	public void stopGame() {
		if (state == State.RUNNING) {
			driver.stop();
			state = State.PAUSING;
		}
	}

	public Panel getPanel() {
		return screen;
	}


	/**
	 * Initialisiert alle Attribute
	 */
	private void init() {
		this.state = State.BUILDING;
		this.setupKiste();
		this.setupScreen();
		this.setupDriver();
		this.state = State.PAUSING;
	}

	private void setupKiste() {
		this.kiste = new GameBox();
		
		kiste.add(new Grid());
		
		int s = Properties.HALF_UNIT;
		int r = 10*s;
		kiste.add(new Panzer(3*r,3*r));
		kiste.add(new Panzer(29*r,3*r));
		kiste.add(new Rakete(5*r, 5*r));
		Rakete r1 = new Rakete(5*r,3*r);
		r1.setVelocity(Properties.MAX_VELOCITY);
		kiste.add(r1);
	}

	private void setupDriver() {
		this.driver = new GameDriver(kiste, screen);
	}

	private void setupScreen() {
		this.screen = new Panel(kiste);
		screen.setPreferredSize(new Dimension(Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGTH));
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
		executor.schedule(() -> game.stopGame(), 2, TimeUnit.SECONDS); // 2 Sekunden warten

	}

}
