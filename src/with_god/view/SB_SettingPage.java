package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import with_god.view.SB_Music;

public class SB_SettingPage {
	JCheckBox sound, screen;
	//private static SB_Music introMusic = new SB_Music("bgm.mp3", true);
	boolean onOff = true;
	//SB_Setting sMusic = new SB_Setting();
	public SB_SettingPage(JFrame mf) {
		Dialog dg = new Dialog(mf, "환경설정");
		//dg.setBounds(300, 300, 400, 250);
		dg.setSize(400, 250);
		dg.setLocationRelativeTo(mf);
		dg.setBackground(Color.darkGray);
		dg.setLayout(null);

		JLabel set = new JLabel("환경설정");
		set.setBounds(140, 60, 150, 50);
		set.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		set.setForeground(Color.WHITE);

		/*sound = new JCheckBox("음량");
		sound.setBackground(Color.DARK_GRAY);
		sound.setForeground(Color.WHITE);
		screen = new JCheckBox("창 고정");
		screen.setBackground(Color.DARK_GRAY);
		screen.setForeground(Color.WHITE);
		sound.setBounds(100, 50, 200, 50);
		screen.setBounds(50, 50, 200, 50);*/
		
		Image soundOn = new ImageIcon("images/soundon.png").getImage().getScaledInstance(150, 120, 0);
		Image soundOff = new ImageIcon("images/soundoff.png").getImage().getScaledInstance(150, 120, 0);
		Image exit = new ImageIcon("images/exitButtonBasic.png").getImage().getScaledInstance(30, 30, 0);
		JLabel soundOnL = new JLabel(new ImageIcon(soundOn));
		soundOnL.setBounds(20, 100, 150, 120);
		JLabel soundOffL = new JLabel(new ImageIcon(soundOff));
		soundOffL.setBounds(190, 100, 150, 120);
		JLabel exitL = new JLabel(new ImageIcon(exit));
		exitL.setBounds(360, 210, 30, 30);

		//introMusic.start();
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dg.dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				soundOffL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		
		soundOnL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SB_Setting().startMusic();
				/*if(onOff) {
				onOff = false;
				}else if(!onOff) {
					new SB_Setting().closeMusic();
					onOff = true;
				}*/
				//introMusic.run();
				//sMusic.setStartMusic(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				soundOnL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			
		});
		soundOffL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SB_Setting().closeMusic();
				//sMusic.setStartMusic(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				soundOffL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});

		// introMusic.start();

		dg.add(soundOnL);
		dg.add(soundOffL);
		dg.add(exitL);
		dg.add(set);
		dg.setVisible(true);
	}
}
