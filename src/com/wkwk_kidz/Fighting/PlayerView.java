package com.wkwk_kidz.Fighting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;

public class PlayerView {
	
	public Awakening awakening;
	
	private String player;
	private Graphics g = Main.g;
	public int x = 600;
	public int y = 80;
	public int num = 1;
	
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

	public PlayerView() {
		
		awakening = new Awakening();
		
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
//		
//		this.g = Main.g;
	};

	//通常動作
	public void player_normal() {
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
		
		g.drawImage(player, x, y, null);
	}

	public void player_jump() {
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
		g.drawImage(player, x, y, null);
	}

	//攻撃のやつ
	public void player_attack() {
		Image player = player_attack_3;

		num ++;
		if(num > 8) {
			num = 1;
			attackFlag = false;
			Main.collision.playerFlag = false;
		}
		//			player = Toolkit.getDefaultToolkit().getImage("C:/Users/takar/OneDrive/画像/Fighting/Player/takaren1/attack/" + num +".png");
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
		
		g.drawImage(player, x, y, null);
	}
	
	//ダメージエフェクト
	public void player_damaged() {
		Image player = player_damaged_1;
		
		num++;
		if(num > 8) {
			num = 1;
			damageFlag = false;
			Main.collision.enemyFlag = false;
		}
		
		g.drawImage(player, x, y, null);
	}
	
	
	public void position_getter_x(int get_x) {
		this.position_setter_x(get_x);
	}

	private void position_setter_x(int set_x) {
		x += set_x;
	}

	public void position_getter_y(int get_y) {
		this.position_setter_y(get_y);
	}

	private void position_setter_y(int set_y) {
		y = set_y;
		//		System.out.println(y);
	}

	public int y_return() {
		return(y);
	}
}
