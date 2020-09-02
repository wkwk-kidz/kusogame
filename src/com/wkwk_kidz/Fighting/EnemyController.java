package com.wkwk_kidz.Fighting;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EnemyController extends KeyAdapter{
	public static EnemyPlayerView enemyplayerView = new EnemyPlayerView();

	public int y, y_prev, y_temp;
	public boolean jumpFlag = false;
	private ArrayList<Integer> pressedButtons = new ArrayList<>();

	public boolean isKeyPressed(int keyCode) {
		return pressedButtons.contains(keyCode);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(!pressedButtons.contains(e.getKeyCode())) pressedButtons.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		pressedButtons.remove((Integer) e.getKeyCode());
	}

	public void MoveLeft() {
		enemyplayerView.position_getter_enemy_x(-16);
	}

	public void MoveRight() {
		enemyplayerView.position_getter_enemy_x(16);
	}

	public void MoveJump() {
		if(jumpFlag == true) {
			y_temp = y; // temp = -10, y = -10
					y += (y - y_prev) + 10;//y = -19
					enemyplayerView.position_getter_enemy_y(80 + y);
					y_prev = y_temp;
					if(y == 0) {
						enemyplayerView.position_getter_enemy_y(80);
						jumpFlag = false;
					}
		}
	}
}
