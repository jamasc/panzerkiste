package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	Game game;
	public int xMove, yMove;
	int up, down, left, right;
	
	public KeyHandler(Game game) {
		this.game = game;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//weis nicht wie man des benutzt
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
		xMove = left + right;
		yMove = up + down;
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
		xMove = left + right;
		yMove = up + down;
	}

}
