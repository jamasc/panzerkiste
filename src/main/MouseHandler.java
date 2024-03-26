package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import entities.Panzer;

public class MouseHandler implements MouseMotionListener{

	Game game;
	Panzer panzer;
	public int mouseX, mouseY;
	
	public MouseHandler(Game game, Panzer panzer) {
		this.game = game;
		this.panzer = panzer;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		panzer.setAim(mouseX, mouseY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		panzer.setAim(mouseX, mouseY);
		
	}
}
