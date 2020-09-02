package com.wkwk_kidz.Fighting;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {
	static String path = new File("").getAbsolutePath();
	public static WindowFrame windowFrame;
	public static View view;
	public static EnemyView enemyView;
	public static Screen screen;
	public static Controller controller;
	public static Collision collision;
	public static FightingScreen fightingScreen;
	static Music bgm;
	
	public static boolean pay = false;

	public static Graphics g;
	public static int fps = 16;

	public static void main(String[] args){
		
		windowFrame = new WindowFrame();
		g = windowFrame.windowPanel.image.getGraphics();
		collision = new Collision();
		view = new View();
		enemyView = new EnemyView();
		screen = new Screen();
		windowFrame.addKeyListener(view.controller);
		windowFrame.addKeyListener(enemyView.enemyController);
		bgm = new Music();

		fightingScreen = FightingScreen.START;

		

		long startTime;
		
		bgm.play = true;
		
		while(true) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 1200, 800);
			bgm.play_bgm();
			
			startTime = System.currentTimeMillis();

			switch(fightingScreen) {
			case START:
				screen.Menu();
                 
				break;
			case GAME:
				screen.BackView();
				
				view.refresh();
				enemyView.refresh();
				
				if(view.hp.HP <= 0) {
					fightingScreen = FightingScreen.GAME_OVER;
					Main.bgm.play = true;
				}
				
				if(enemyView.hp.enemy_HP <= 0) {
					fightingScreen = FightingScreen.GAME_CLEAR;
					Main.bgm.play = true;
				}

				break;


			case GAME_CLEAR:
				screen.GameClear();
				view.hp.HP = 500;
				enemyView.hp.enemy_HP = 500;
				break;
				
			case GAME_OVER:
				screen.GameOver();
				view.hp.HP = 500;
				enemyView.hp.enemy_HP = 500;
				break;
				
			case PAY:
				screen.Pay();
				view.hp.HP = 500;
				enemyView.hp.enemy_HP = 500;
				break;
			}	
				
			windowFrame.windowPanel.draw();

				try {
					long runTime = System.currentTimeMillis() - startTime;
					if(runTime<(1000 / fps)) {
						Thread.sleep((1000 / fps) - (runTime));
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}

	}
}
