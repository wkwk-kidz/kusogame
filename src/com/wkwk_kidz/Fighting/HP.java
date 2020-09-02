package com.wkwk_kidz.Fighting;

import java.awt.*;

public class HP {
	public int HP = 500;
	public int enemy_HP = 500;
	Graphics g = Main.g;
	
	public static void HP() {
	}
	
	public void HPview() {
		g.setColor(Color.GRAY);
		g.fillRect(650, 700, 500, 20);
		g.setColor(Color.GREEN);
		g.fillRect(650, 700, HP, 20);	
		if(HP <= 0) {
			HP = 500;
		}
	}
	
	public void enemyHPview() {
		g.setColor(Color.GRAY);
		g.fillRect(100, 700, 500, 20);
		g.setColor(Color.GREEN);
		g.fillRect(100, 700, enemy_HP, 20);	
		if(enemy_HP <= 0) {
			enemy_HP = 500;
		}
	}
}
