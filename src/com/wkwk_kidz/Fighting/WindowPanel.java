package com.wkwk_kidz.Fighting;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WindowPanel extends JPanel{
	public static BufferedImage image;
	
	public WindowPanel() {
		super();
		this.image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw() {
		this.repaint();
	}
	
}
