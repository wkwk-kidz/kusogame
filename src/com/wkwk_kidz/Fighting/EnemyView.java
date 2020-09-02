package com.wkwk_kidz.Fighting;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class EnemyView {
	private Graphics g = Main.g;
	//	PlayerView playerView = new PlayerView();
	public static EnemyController enemyController;
	public Collision collision;
	public int MoveInterval,AttackInterval,JumpInterval;
	public Random random = new Random();
	public boolean enemyMove;
	public HP hp;
	public int decHP = 1;

	public EnemyView() {
		enemyController = new EnemyController();
		hp = new HP();
		collision = Main.collision;
		MoveInterval = 5;
		enemyMove = true;
	}

	public void refresh(){
		
		if(Main.pay == true) {
			decHP = 50;
		}
		
		hp.enemyHPview();
		collision.enemy_getter(enemyController.enemyplayerView.enemy_x, enemyController.enemyplayerView.enemy_y);
		
		if(enemyController.jumpFlag == false && 
				enemyController.enemyplayerView.attackFlag == false && 
				enemyController.enemyplayerView.damageFlag == false ) {
			enemyController.enemyplayerView.enemy_player_normal();
		}
		if(enemyController.isKeyPressed(KeyEvent.VK_A)&& 
				enemyController.enemyplayerView.attackFlag == false && 
				enemyController.enemyplayerView.damageFlag == false &&
				enemyController.enemyplayerView.enemy_x >= 300) {
			enemyController.MoveLeft();
		}
		if(enemyController.isKeyPressed(KeyEvent.VK_D)&& 
				enemyController.enemyplayerView.attackFlag == false && 
				enemyController.enemyplayerView.damageFlag == false &&
				enemyController.enemyplayerView.enemy_x <= 1300) {
			enemyController.MoveRight();
		}

		if(MoveInterval == 0) {
			MoveInterval = random.nextInt(10);
			if(enemyMove == true) {
				enemyMove = false;
			}else {
				enemyMove = true;
			}
		}else {
			MoveInterval --;
			if(enemyMove == true&& 
					enemyController.enemyplayerView.attackFlag == false && 
					enemyController.enemyplayerView.damageFlag == false &&
					enemyController.enemyplayerView.enemy_x >= 300) {
				enemyController.MoveLeft();
			}else if(enemyMove == false && 
					enemyController.enemyplayerView.attackFlag == false && 
					enemyController.enemyplayerView.damageFlag == false &&
					enemyController.enemyplayerView.enemy_x <= Main.collision.player_x + 200) {
				enemyController.MoveRight();
			}
		}

		//攻撃コマンド
		AttackInterval = random.nextInt(20);

		if(AttackInterval == 0 && Main.pay == false) {
			if(enemyController.jumpFlag == false && 
					enemyController.enemyplayerView.attackFlag == false && 
					enemyController.enemyplayerView.damageFlag == false) {
				enemyController.enemyplayerView.attackFlag = true;
				collision.enemyFlag = true;
			}
		}
		if(enemyController.enemyplayerView.attackFlag == true) {
			enemyController.enemyplayerView.enemy_player_attack();
		}

		//ジャンプコマンド
		JumpInterval =  random.nextInt(30);

		if(JumpInterval == 0) {
			if(enemyController.jumpFlag == false && 
					enemyController.enemyplayerView.attackFlag == false && 
					enemyController.enemyplayerView.damageFlag == false) {
				enemyController.jumpFlag = true;
				enemyController.y_prev = 0;
				enemyController.y = -50;
			}
		}
		if(enemyController.jumpFlag == true) {
			enemyController.MoveJump();
			enemyController.enemyplayerView.enemy_player_jump();
		}
		
		//ダメージ
		if(enemyController.enemyplayerView.damageFlag == false && collision.enemy_collision()) {
			enemyController.enemyplayerView.damageFlag = true;
			hp.enemy_HP -= decHP;
		}
		if(enemyController.enemyplayerView.damageFlag == true) {
			enemyController.enemyplayerView.enemy_player_damaged();
		}
	}
}
