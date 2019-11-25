package with_god.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;
import with_god.model.vo.User;

public class CategoryChoice {
	
	private int buttonW = 150;
	private int buttonH = 50;
	
	public CategoryChoice(JFrame mf, JPanel op, User user) {
		
		Dialog di = new Dialog(mf, true);
		di.setSize(500, 400);
		di.setLocationRelativeTo(mf);
		di.setLayout(null);
		di.setBackground(Color.BLACK);
		
		JLabel jl = new JLabel("카테고리 선택", JLabel.CENTER);
		jl.setForeground(Color.WHITE);
		jl.setBounds(0, 50, 500, 100);
		jl.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		
		JLabel math = new JLabel(new ImageIcon(new ImageIcon("Images/greenButton.jpg").getImage().getScaledInstance(buttonW, buttonH, 0)));
		math.setSize(buttonW, buttonH);
		math.setLocation(80, 170);
		math.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				di.dispose();
				InGamePage gp = new InGamePage(mf, user);
				
				ChangePanel.changePanel(mf, op, gp);
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				math.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});

		
		JLabel animal = new JLabel(new ImageIcon(new ImageIcon("Images/greenButton.jpg").getImage().getScaledInstance(buttonW, buttonH, 0)));
		animal.setSize(buttonW, buttonH);
		animal.setLocation(270, 170);
		animal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				di.dispose();
				InGamePage gp = new InGamePage(mf, user);
				
				ChangePanel.changePanel(mf, op, gp);
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				math.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});

		
		JLabel economy = new JLabel(new ImageIcon(new ImageIcon("Images/greenButton.jpg").getImage().getScaledInstance(buttonW, buttonH, 0)));
		economy.setSize(buttonW, buttonH);
		economy.setLocation(80, 250);
		economy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				di.dispose();
				InGamePage gp = new InGamePage(mf, user);
				
				ChangePanel.changePanel(mf, op, gp);
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				math.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		JLabel english = new JLabel(new ImageIcon(new ImageIcon("Images/greenButton.jpg").getImage().getScaledInstance(buttonW, buttonH, 0)));
		english.setSize(buttonW, buttonH);
		english.setLocation(270, 250);
		english.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				di.dispose();
//				EJ_Timer timer = new EJ_Timer(mf, gp);
//				EJ_Timer2 timer2 = new EJ_Timer2(mf, gp);
//				Thread t1 = timer;
//				Thread t2 = new Thread(timer2);
				InGamePage gp = new InGamePage(mf, user);
				
				ChangePanel.changePanel(mf, op, gp);
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				math.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		
		JLabel mathText = new JLabel("넌센스", JLabel.CENTER);
		mathText.setSize(buttonW, buttonH);
		mathText.setLocation(80, 170);
		mathText.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		mathText.setForeground(Color.DARK_GRAY);
		
		JLabel animalText = new JLabel("동  물", JLabel.CENTER);
		animalText.setSize(buttonW, buttonH);
		animalText.setLocation(270, 170);
		animalText.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		animalText.setForeground(Color.DARK_GRAY);
		
		JLabel economyText = new JLabel("경  제", JLabel.CENTER);
		economyText.setSize(buttonW, buttonH);
		economyText.setLocation(80, 250);
		economyText.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		economyText.setForeground(Color.DARK_GRAY);
		
		JLabel englishText = new JLabel("영  어", JLabel.CENTER);
		englishText.setSize(buttonW, buttonH);
		englishText.setLocation(270, 250);
		englishText.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		englishText.setForeground(Color.DARK_GRAY);
		
		JLabel exit2 = new JLabel(new ImageIcon(new ImageIcon("Images/exit.png").getImage().getScaledInstance(50, 50, 0)));
		exit2.setSize(50, 50);
		exit2.setLocation(430, 330);
		exit2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				di.dispose();
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				exit2.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		di.add(jl);
		di.add(math);
		di.add(animal);
		di.add(economy);
		di.add(english);
		di.add(mathText);
		di.add(animalText);
		di.add(economyText);
		di.add(englishText);
		di.add(exit2);
		di.setComponentZOrder(math, 1);
		di.setComponentZOrder(animal, 1);
		di.setComponentZOrder(mathText, 0);
		di.setComponentZOrder(animalText, 0);
		di.setComponentZOrder(economyText, 0);
		di.setComponentZOrder(englishText, 0);
		di.setComponentZOrder(exit2, 0);
		di.setUndecorated(true);
		di.setVisible(true);
	}
	
}
