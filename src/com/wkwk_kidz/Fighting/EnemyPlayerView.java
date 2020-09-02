package com.wkwk_kidz.Fighting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class EnemyPlayerView {
	
	private String player;
	private Graphics g = Main.g;
	public int enemy_x = 600;
	public int enemy_y = 80;
	private static int num = 1;


	private Image player_attack_1; 
	private Image player_attack_2; 
	private Image player_attack_3;

	private Image player_jump_1; 
	private Image player_jump_2; 
	private Image player_jump_3; 
	private Image player_jump_4;

	private Image player_normal_1; 
	private Image player_normal_2; 
	private Image player_normal_3; 
	private Image player_normal_4; 
	private Image player_normal_5; 
	private Image player_normal_6; 
	private Image player_normal_7; 
	private Image player_normal_8; 

	private Image player_damaged_1;

	public boolean attackFlag = false;
	public boolean damageFlag = false;

	public EnemyPlayerView() {
		
		player = Main.path + "/Fighting/Player/takaren1";
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		this.player_attack_1 = tool.getImage(player + "/attack/1.png");
		this.player_attack_2 = tool.getImage(player + "/attack/2.png");
		this.player_attack_3 = tool.getImage(player + "/attack/3.png");

		this.player_jump_1 = tool.getImage(player + "/jump/1.png");
		this.player_jump_2 = tool.getImage(player + "/jump/2.png");
		this.player_jump_3 = tool.getImage(player + "/jump/3.png");
		this.player_jump_4 = tool.getImage(player + "/jump/4.png");

		this.player_normal_1 = tool.getImage(player + "/normal/1.png");
		this.player_normal_2 = tool.getImage(player + "/normal/2.png");
		this.player_normal_3 = tool.getImage(player + "/normal/3.png");
		this.player_normal_4 = tool.getImage(player + "/normal/4.png");
		this.player_normal_5 = tool.getImage(player + "/normal/5.png");
		this.player_normal_6 = tool.getImage(player + "/normal/6.png");
		this.player_normal_7 = tool.getImage(player + "/normal/7.png");
		this.player_normal_8 = tool.getImage(player + "/normal/8.png");

		this.player_damaged_1 = tool.getImage(player + "/damaged/1.png");
		
	};

	//’Êí“®ì
	public void enemy_player_normal() {
		Image player = this.player_normal_1;
		num ++;
		if(num > 8) {
			num = 1;
		}
		switch(num) {
		case 1:
			player = player_normal_1;
			break;
		case 2:
			player = player_normal_2;
			break;
		case 3:
			player = player_normal_3;
			break;
		case 4:
			player = player_normal_4;
			break;
		case 5:
			player = player_normal_5;
			break;
		case 6:
			player = player_normal_6;
			break;
		case 7:
			player = player_normal_7;
			break;
		case 8:
			player = player_normal_8;
			break;
		}

		g.drawImage(player, enemy_x, enemy_y, enemy_x - 450 ,680,0,0,450,600, null); //”½“]
	}

	public void enemy_player_jump() {
		Image player = player_jump_4;
		num ++;
		if(num > 4) {
			num = 4;
		}

		switch(num) {
		case 1:
			player = player_jump_1;
			break;
		case 2:
			player = player_jump_2;
			break;
		case 3:
			player = player_jump_3;
			break;
		case 4:
			player = player_jump_4;
			break;
		}
		g.drawImage(player, enemy_x, enemy_y, enemy_x - 450 ,600 + enemy_y,0,0,450,600, null); //”½“]
	}

	//UŒ‚‚Ì‚â‚Â
	public void enemy_player_attack() {
		Image player = player_attack_3;

		num ++;
		if(num > 8) {
			num = 1;
			Main.collision.enemyFlag = false;
			attackFlag = false;	
		}
		//			player = Toolkit.getDefaultToolkit().getImage("C:/Users/takar/OneDrive/‰æ‘œ/Fighting/Player/takaren1/attack/" + num +".png");
		switch(num) {
		case 1:
			player = player_attack_1;
			break;
		case 2:
			player = player_attack_2;
			break;
		case 3:
			player = player_attack_3;
			break;
		}

		g.drawImage(player, enemy_x, enemy_y, enemy_x - 450 ,680,0,0,450,600, null); //”½“]
	}

	//ƒ_ƒ[ƒWƒGƒtƒFƒNƒg
	public void enemy_player_damaged() {
		Image player = player_damaged_1;

		num++;
		if(num > 8) {
			num = 1;
			damageFlag = false;
			Main.collision.playerFlag = false;
		}

		g.drawImage(player, enemy_x, enemy_y, enemy_x - 450 ,600 + enemy_y,0,0,450,600, null); //”½“]
	}



	public void position_getter_enemy_x(int get_x) {
		this.position_setter_enemy_x(get_x);
	}

	private void position_setter_enemy_x(int set_x) {
		enemy_x += set_x;
	}

	public void position_getter_enemy_y(int get_y) {
		this.position_setter_enemy_y(get_y);
	}

	private void position_setter_enemy_y(int set_y) {
		enemy_y = set_y;
		//		System.out.println(y);
	}

	public int enemy_y_return() {
		return(enemy_y);
	}
}
