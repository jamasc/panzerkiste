package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

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
	private BufferedImage image;
	
	
	public Panel(GameBox game) {
		init(game);
	}

	
	private void init(GameBox game) {
		this.game = game;
		this.image = new BufferedImage(Properties.IMAGE_WIDTH, Properties.IMAGE_HEIGTH, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = image.createGraphics();
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, image.getWidth(), image.getHeight());
		g2.setColor(Color.WHITE);
		game.draw(g2);
		g2.dispose();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	

}
