package main;

import java.awt.Cursor;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("panzerkiste");
		
		Game game = new Game();
		window.add(game);
		
		window.pack();
		
		//CURSOR
		Helper h = new Helper();
		Cursor cursor = h.getCrossHairs();
		window.setCursor(cursor);
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		game.setupGame();
		game.startGameThread();
	}
}
		