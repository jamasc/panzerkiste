package main;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Helper {
	
	Toolkit toolkit;

	public Helper() {
		toolkit = Toolkit.getDefaultToolkit();
	}
	
	public Cursor getCrossHairs() {
		ImageIcon cursorImageIcon = new ImageIcon("res/aim/aim_green.png");
	    Image cursorImage = cursorImageIcon.getImage();
	    int hotspotX = cursorImage.getWidth(null) / 2;
        int hotspotY = cursorImage.getHeight(null) / 2;
        Cursor crossHairs = toolkit.createCustomCursor(cursorImage, new Point(hotspotX, hotspotY), "CustomCursor");
	    return crossHairs;
	}
	
	public Cursor getShot() {
		ImageIcon cursorImageIcon = new ImageIcon("res/aim/hit_green.png");
	    Image cursorImage = cursorImageIcon.getImage();
	    int hotspotX = cursorImage.getWidth(null) / 2;
        int hotspotY = cursorImage.getHeight(null) / 2;
        Cursor crossHairs = toolkit.createCustomCursor(cursorImage, new Point(hotspotX, hotspotY), "ClickCursor");
	    return crossHairs;
	}
	
	public Cursor invisibleCursor() {
	        Image image = toolkit.createImage("");
	        Cursor invisibleCursor = toolkit.createCustomCursor(image, new Point(0, 0), "InvisibleCursor");
	        return invisibleCursor;
	}
}
