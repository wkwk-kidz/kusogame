package com.wkwk_kidz.Fighting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class View {
	private Graphics g = Main.g;
//	PlayerView playerView = new PlayerView();
	public static Controller controller;
	public Collision collision;
	public HP hp;
	public int decHP = 500;
	
	public View() {
		controller = new Controller();
		collision = Main.collision;
		hp = new HP();
	}
	
	public void refresh(){
		
		if(Main.pay == true) {
			decHP = 0;
		}
		
		hp.HPview();
		collision.player_getter(controller.playerView.x, controller.playerView.y);
		
		if(controller.jumpFlag == false && controller.playerView.attackFlag == false && controller.playerView.damageFlag == false) {
			controller.playerView.player_normal();
		}
		if(controller.isKeyPressed(KeyEvent.VK_LEFT)&& 
				controller.playerView.attackFlag == false && 
				controller.playerView.damageFlag == false &&
				controller.playerView.x >= -100) {
			controller.MoveLeft();
		}
		if(controller.isKeyPressed(KeyEvent.VK_RIGHT)&& 
				controller.playerView.attackFlag == false && 
				controller.playerView.damageFlag == false &&
				controller.playerView.x <= 800) controller.MoveRight();
		//ジャンプコマンド
		if(controller.isKeyPressed(KeyEvent.VK_UP) && controller.jumpFlag == false && controller.playerView.attackFlag == false && controller.playerView.damageFlag == false) {
			controller.jumpFlag = true;
			controller.y_prev = 0;
			controller.y = -50;
		}
		if(controller.jumpFlag == true) {
			controller.MoveJump();
			controller.playerView.player_jump();
		}
		//攻撃コマンド
		if(controller.isKeyPressed(KeyEvent.VK_SPACE) && controller.playerView.attackFlag == false) {
			controller.playerView.attackFlag = true;
			collision.playerFlag = true;
		}
		if(controller.playerView.attackFlag == true) {
			controller.playerView.player_attack();
		}
		
		if( controller.playerView.damageFlag == false && collision.player_collision()) {
			controller.playerView.damageFlag = true;
			hp.HP -= decHP;
		}
		if(controller.playerView.damageFlag == true) {
			controller.playerView.player_damaged();
		}
		
		if(Main.pay == true) {
			controller.playerView.awakening.super_refresh(controller.playerView.x, controller.playerView.y);
		}
		
	}
	
}
