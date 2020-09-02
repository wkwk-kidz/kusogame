package com.wkwk_kidz.Fighting;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Awakening {
	private String player;
	private Graphics g = Main.g;
	public int x = 600;
	public int y = 80;
	public int num = 1;
	
	private Image super_1;
	private Image super_2;
	private Image super_3;
	private Image super_4;
	
	public Awakening() {
		
		player = Main.path + "/Fighting/Player/takaren1";
		
		Toolkit tool = Toolkit.getDefaultToolkit();
				
		this.super_1 = tool.getImage(player + "/super/1.png");
		this.super_2 = tool.getImage(player + "/super/2.png");
		this.super_3 = tool.getImage(player + "/super/3.png");
		this.super_4 = tool.getImage(player + "/super/4.png");
	}
	
	public void super_refresh(int x, int y) {
		Image aura = this.super_1;
		num ++;
		if(num > 4) {
			num = 1;
		}
		switch(num) {
		case 1:
			aura = super_1;
			break;
		case 2:
			aura = super_2;
			break;
		case 3:
			aura = super_3;
			break;
		case 4:
			aura = super_4;
			break;
		}
		
		g.drawImage(aura, x, y - 40, null);
	}
}
