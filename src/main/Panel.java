package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * Stellt einen Bildschirm dar, welcher zu einer GameBox connected ist
 * show ändert die anzuzeigende GameBox
 * 
 * @author Arne
 *
 */
public class Panel extends JPanel {

	private GameBox game;
	private BufferedImage image;
	
	
	public Panel() {
		init();
	}
	
	public void show(GameBox game) {
		this.game = game;
	}

	
	private void init() {
		setPreferredSize(new Dimension(Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGTH));
		this.image = new BufferedImage(Properties.IMAGE_WIDTH, Properties.IMAGE_HEIGTH, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, image.getWidth(), image.getHeight());
		if (game != null) {
			game.draw(g2);
		}
		g2.dispose();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	

}
