package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Panzer;

public class KeyHandler implements KeyListener{

	Game game;
	Panzer panzer;
	float normX, normY;
	int up, down, left, right;
	private boolean wPressed = false;
	private boolean sPressed = false;
	private boolean aPressed = false;
	private boolean dPressed = false;
	
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
		
		if(code == KeyEvent.VK_W && !wPressed) {
			wPressed = true;
			up = -1;
		}
		if(code == KeyEvent.VK_S && !sPressed) {
			sPressed = true;
			down = 1;
		}
		if(code == KeyEvent.VK_A && !aPressed) {
			aPressed = true;
			left = -1;
		}
		if(code == KeyEvent.VK_D && !dPressed) {
			dPressed = true;
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
			wPressed = false;
			up = 0;
		}
		if(code == KeyEvent.VK_S) {
			sPressed = false;
			down = 0;
		}
		if(code == KeyEvent.VK_A) {
			aPressed = false;
			left = 0;
		}
		if(code == KeyEvent.VK_D) {
			dPressed = false;
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
