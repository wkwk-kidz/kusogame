package com.wkwk_kidz.Fighting;

import javax.swing.*;

public class WindowFrame extends JFrame{
	public static WindowPanel windowPanel;
	
	public WindowFrame() {
		
		windowPanel = new WindowPanel();
		
		this.add(windowPanel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("wkwk_fighting");
		this.setSize(1200,800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

}
