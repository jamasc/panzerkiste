package main;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * 
 * Stellt den Bildschirm des Spiels dar
 * und
 * den grafischen Output der GameBox
 * 
 * @author Arne
 *
 */
public class Panel extends JPanel {

	private GameBox game;
	
	
	public Panel(GameBox game) {
		init(game);
	}

	
	private void init(GameBox game) {
		this.game = game;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		game.draw(g);
	}
	
	

}
