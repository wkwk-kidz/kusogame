package com.wkwk_kidz.Fighting;

import java.awt.Color;

public class Collision {
	public int player_x,player_y,enemy_x,enemy_y;
	public boolean playerFlag,enemyFlag;
	
	public void player_getter(int x, int y) {
		player_x = x + 200;
		player_y = y + 170;
	}
	
	public void enemy_getter(int x, int y) {
		enemy_x = x - 300;
		enemy_y = y + 170;
	}
	
	public boolean player_collision() {
		if(enemyFlag == true) {
			enemy_x += 240;
			enemy_y -= 10;
			if(enemy_y <= player_y + 180 ||enemy_y + 25 >= player_y) {
				if(enemy_x + 20 >= player_x && enemy_x <= player_x + 100) {
					return true;	
				}
			}
		}
		
		return false;
				
	}
	
	public boolean enemy_collision() {
		if(playerFlag == true) {
			player_x -= 160;
			player_y -= 10;
			if(player_y <= enemy_y + 180 ||player_y + 25 >= enemy_y) {
				if(player_x <= enemy_x + 100 && player_x + 20 >= enemy_x) {
					return true;	
				}
			}
		}
		
		return false;
				
	}
	
}
