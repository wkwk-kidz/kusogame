package com.wkwk_kidz.Fighting;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	
	boolean play = false;
	Clip sound;
	File title_bgm,game_bgm,game_over_bgm,pay_bgm,clear_bgm;
	String bgm;
	
	public Music() {
		bgm = Main.path + "/Fighting/Music/";
		title_bgm = new File(bgm + "OP.wav");
		game_bgm = new File(bgm + "ÉVÉçÉi.wav");
		game_over_bgm = new File(bgm + "loser.wav");
		pay_bgm = new File(bgm + "äoê¡.wav");
		clear_bgm = new File(bgm + "óÉÇÇ≠ÇæÇ≥Ç¢.wav");
	}
	
	private void set_audio(File name){
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(name)){
			AudioFormat af = ais.getFormat();
			DataLine.Info dataline = new DataLine.Info(Clip.class,af);
			
			sound = (Clip)AudioSystem.getLine(dataline);
			
			sound.open(ais);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void select_bgm(){
		switch(Main.fightingScreen) {
		case START:
			this.set_audio(title_bgm);
			break;
		case GAME:
			if(Main.pay == true) {
				this.set_audio(pay_bgm);
				break;
			}
			this.set_audio(game_bgm);
			break;
		case GAME_OVER:
			this.set_audio(game_over_bgm);
			break;
		case PAY:
			this.set_audio(pay_bgm);
			break;
		case GAME_CLEAR:
			this.set_audio(clear_bgm);
			break;
		}
	}
	
	public void play_bgm(){
		if(play == true) {
			if(sound != null) {
				sound.close();
			}
			this.select_bgm();
			sound.loop(Clip.LOOP_CONTINUOUSLY);
			play = false;
		}
	}
	
	
}
