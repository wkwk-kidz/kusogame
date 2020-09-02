package com.wkwk_kidz.Fighting;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Screen {

	Graphics g = Main.g;
	Image screen;
	Image lose;
	int y = 0,x = 0,num = 7;
	boolean gameFlag = true,payFlag = true,onemore = true;

	public Screen() {
		screen = Toolkit.getDefaultToolkit().getImage(Main.path + "/Fighting/Screen/Stage.png");
		lose = Toolkit.getDefaultToolkit().getImage(Main.path + "/Fighting/Screen/GAME_OVER/LOSER.gif");
	}

	public void Menu() {
		Image MyFace = Toolkit.getDefaultToolkit().getImage(Main.path + "/Fighting/Screen/Title/face.png");
		g.drawImage(MyFace,350,280, null);

		g.setColor(Color.WHITE);
		Font font = new Font("SansSerif", Font.PLAIN, 80);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
		g.drawString("wkwk_kidz", 600 - (metrics.stringWidth("wkwk_kidz") / 2), 150);
		font = new Font("SansSerif", Font.PLAIN, 40);
		g.setFont(font);
		metrics = g.getFontMetrics(font);
		g.drawString("・やる", 600 - (metrics.stringWidth("・やらない") / 2), 240);
		g.drawString("・やらない", 600 - (metrics.stringWidth("・やらない") / 2), 310);

		g.setColor(Color.red);
		g.fillRect(500, 200 + y, 220, 5);
		g.fillRect(500, 250 + y, 220, 5);
		g.fillRect(500, 200 + y, 5, 50);
		g.fillRect(715, 200 + y, 5, 50);

		if(Controller.isKeyPressed(KeyEvent.VK_UP)) {
			y = 0;
			gameFlag = true;
		}

		if(Controller.isKeyPressed(KeyEvent.VK_DOWN)) {
			y = 70;
			gameFlag = false;
		}

		if(Controller.isKeyPressed(KeyEvent.VK_ENTER)) {
			if(gameFlag) {
				Main.fightingScreen = FightingScreen.GAME;
				Main.bgm.play = true;
			}else {
				System.exit(0);
			}
		}
	}

	public void BackView() {
		g.drawImage(screen, 0, 0, null);
	}

	public void GameOver() {
		g.setColor(Color.WHITE);
		Font font = new Font("SansSerif", Font.PLAIN, 80);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
		g.drawString("LOSE...", 600 - (metrics.stringWidth("LOSE...") / 2), 150);
		font = new Font("SansSerif", Font.PLAIN, 40);
		g.setFont(font);
		metrics = g.getFontMetrics(font);
		g.drawString("・もういっかい", 600 - (metrics.stringWidth("・もういっかい") / 2), 240);
		g.drawString("・もういい", 600 - (metrics.stringWidth("・もういっかい") / 2), 310);

		g.drawImage(lose, 390, 350, null);

		g.setColor(Color.red);
		//		g.fillRect(500, 200 + y, 220, 5);
		//		g.fillRect(500, 250 + y, 220, 5);
		//		g.fillRect(500, 200 + y, 5, 50);
		//		g.fillRect(715, 200 + y, 5, 50);
		x = 70;
		g.fillRect(470, 200 + y, 220 + x, 5);
		g.fillRect(470, 250 + y, 220 + x, 5);
		g.fillRect(470, 200 + y, 5, 50);
		g.fillRect(685 + x, 200 + y, 5, 50);

		if(Controller.isKeyPressed(KeyEvent.VK_UP)) {
			y = 0;
			onemore = true;
		}

		if(Controller.isKeyPressed(KeyEvent.VK_DOWN)) {
			y = 70;
			onemore = false;
		}

		if(Controller.isKeyPressed(KeyEvent.VK_ENTER) ) {	
			if(onemore == true) {
				Main.fightingScreen = FightingScreen.PAY;
			}else {
				System.exit(0);
			}
		}
	}

	public void GameClear() {
		Main.pay = false;
		
		g.setColor(Color.WHITE);
		Font font = new Font("SansSerif", Font.PLAIN, 80);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
		g.drawString("おめでとう", 600 - (metrics.stringWidth("おめでとう") / 2), 350);
		g.drawString("&  YOU", 600 - (metrics.stringWidth("&  YOU") / 2), 610);
		font = new Font("SansSerif", Font.PLAIN, 40);
		g.setFont(font);
		metrics = g.getFontMetrics(font);
		g.drawString("父にありがとう、母にさよなら、", 600 - (metrics.stringWidth("父にありがとう、母にさよなら、") / 2), 120);
		g.drawString("そして、すべてのチルドレンに、", 600 - (metrics.stringWidth("そして、すべてのチルドレンに、") / 2), 170);
		g.drawString("素材：おれ&etc.", 600 - (metrics.stringWidth("素材：おれ&etc.") / 2), 470);
		g.drawString("音楽 : おれ&etc.", 600 - (metrics.stringWidth("音楽 : おれ&etc.") / 2), 520);
		font = new Font("SansSerif", Font.PLAIN, 30);
		g.setFont(font);
		metrics = g.getFontMetrics(font);
		g.drawString("PLEASE ENTER", 600 - (metrics.stringWidth("PLEASE ENTER") / 2), 700);


		if(Controller.isKeyPressed(KeyEvent.VK_ENTER) ) {	
			if(onemore == true) {
				Main.fightingScreen = FightingScreen.START;
				Main.bgm.play = true;
			}
		}
	}

	public void Pay() {
		g.setColor(Color.WHITE);
		Font font = new Font("SansSerif", Font.PLAIN, 80);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
		g.drawString("つよくなる？", 600 - (metrics.stringWidth("つよくなる？") / 2), 150);
		font = new Font("SansSerif", Font.PLAIN, 40);
		g.setFont(font);
		metrics = g.getFontMetrics(font);
		g.drawString("なる", 600 - (metrics.stringWidth("なる") / 2), 340);
		g.drawString("ならない", 600 - (metrics.stringWidth("ならない") / 2), 440);

		g.setColor(Color.red);
		g.fillRect(450, 300 + y, 260 + x, 5);
		g.fillRect(450, 350 + y, 260 + x, 5);
		g.fillRect(450, 300 + y, 5, 50);
		g.fillRect(705 + x, 300 + y, 5, 50);

		if(num > 0 ) {
			num --;
		}else {

			if(Controller.isKeyPressed(KeyEvent.VK_UP)) {
				y = 0;
				x = 0;
				payFlag = true;
			}

			if(Controller.isKeyPressed(KeyEvent.VK_DOWN)) {
				y = 100;
				x = 50;
				payFlag = false;
			}

			if(Controller.isKeyPressed(KeyEvent.VK_ENTER) ) {	
				if(payFlag == true) {
					num = 7;
					Main.pay = true;
					Main.bgm.play = true;
					Main.fightingScreen = FightingScreen.GAME;
				}else {
					payFlag = true;
					num = 7;
					Main.bgm.play = true;
					Main.fightingScreen = FightingScreen.GAME;
				}
			}
		}
	}
}
