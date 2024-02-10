package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Panzer;

public class KeyHandler implements KeyListener{

	Game game;
	Panzer panzer;
	float normX, normY;
	int up, down, left, right;
	
	public KeyHandler(Game game, Panzer panzer) {
		this.game = game;
		this.panzer = panzer;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			up = -1;
		}
		if(code == KeyEvent.VK_S) {
			down = 1;
		}
		if(code == KeyEvent.VK_A) {
			left = -1;
		}
		if(code == KeyEvent.VK_D) {
			right = 1;
		}
		double magnitude = Math.sqrt(Math.abs(left + right) + Math.abs(up + down));
		if(magnitude != 0) {
			normX = (float) ((left + right) / magnitude);
			normY = (float) ((up + down) / magnitude);
		}else {
			normX = 0;
			normY = 0;
		}
		panzer.setDirection(normX,normY);
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W) {
			up = 0;
		}
		if(code == KeyEvent.VK_S) {
			down = 0;
		}
		if(code == KeyEvent.VK_A) {
			left = 0;
		}
		if(code == KeyEvent.VK_D) {
			right = 0;
		}
		double magnitude = Math.sqrt(Math.abs(left + right) + Math.abs(up + down));
		if(magnitude != 0) {
			normX = (float) ((left + right) / magnitude);
			normY = (float) ((up + down) / magnitude);
		}else {
			normX = 0;
			normY = 0;
		}
		panzer.setDirection(normX,normY);
	}

}
