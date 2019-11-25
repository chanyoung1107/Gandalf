package with_god.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;
import with_god.model.vo.User;

public class EJ_Timer extends Thread {
	private JFrame jf;
	private JPanel panel;
	private JLabel heartButton;
	private JLabel barButton;
	private JLabel bar2Button;
	
	private int heartx = 30;				//하트 x위치
	private int hearty = 680;				//하트 y위치
	private int heartw = 70;				//하트 가로 길이
	private int hearth = 60;				//하트 세로 길이
	private int yellowx = 55;				//노랑이 x위치
	private int yellowy = 690;				//노랑이 y위치
	private int yelloww = 570;				//노랑이 가로 길이
	private int yellowh = 40;				//노랑이 세로 길이
	private int barx = 55;
	private int bary = 690;
	private int barw = 580;
	private int barh = 45;
	
	private JLabel countNumText;
	private int countNum;
	
	private int timerSec;
	private int timerSleep = 1000;
	
	private User user;
	public EJ_Timer() {}
	public EJ_Timer(JFrame mf, JPanel jp, User user) {
		this.jf = mf;
		this.panel = jp;
		this.user = user;
		heartButton = new JLabel(new ImageIcon(new ImageIcon("images/heart1.png").getImage().getScaledInstance(heartw, hearth, 0)));
		heartButton.setSize(heartw, hearth);
		heartButton.setLocation(heartx, hearty);
		
		barButton = new JLabel(new ImageIcon(new ImageIcon("images/yellowbar2.png").getImage().getScaledInstance(yelloww, yellowh, 0)));
		barButton.setSize(yelloww, yellowh);
		barButton.setLocation(yellowx, yellowy);
		
		bar2Button = new JLabel(new ImageIcon(new ImageIcon("images/bar.png").getImage().getScaledInstance(barw, barh, 0)));
		bar2Button.setSize(barw, barh);
		bar2Button.setLocation(barx, bary);
		
		countNumText = new JLabel(countNum + "");
		countNumText.setBounds(47, 680, 70, 60);
		countNumText.setForeground(Color.black);
		countNumText.setFont(new Font("DX새날B", Font.BOLD, 30));
		
		panel.add(countNumText);
		panel.setComponentZOrder(countNumText, 0);

		
		
		panel.add(heartButton);
		panel.add(barButton);
		panel.add(bar2Button);
		panel.setComponentZOrder(barButton, 1);
		panel.setComponentZOrder(bar2Button, 0);
		panel.setComponentZOrder(heartButton, 0);
		panel.setComponentZOrder(countNumText, 0);
	}
	
	
	@Override
	public void run() {

		for(timerSec = 180; timerSec >= 0; timerSec--) {
			
			for(int i = 0; i <= 1000; i++) {
				try {
					Thread.sleep(1);
					if(i == 1000) {
						System.out.println(timerSec);
						countNum = timerSec;
						countNumText.setText(countNum + "");
					}else if(i == 300 || i == 600){
						barButton.setSize(yelloww -= 1, yellowh);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		Dialog di = new Dialog(jf, "End", true);
		di.setSize(400,200);
		di.setLocationRelativeTo(jf);
		di.setBackground(Color.BLACK);
		di.setLayout(null);
		
		JLabel orange = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(100, 40, 0)));
		orange.setSize(100, 40);
		orange.setLocation(150, 130);
		orange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(jf, panel, new EJ_GameModeChoicePanel(jf, user));
				di.dispose();
			}
		});
		
		JLabel jl = new JLabel("Time over!!", JLabel.CENTER);
		jl.setSize(400,50);
		jl.setLocation(0, 50);
		jl.setFont(new Font("고딕", Font.BOLD, 30));
		jl.setForeground(Color.WHITE);
		
		JLabel yesL = new JLabel("확인", JLabel.CENTER);
		yesL.setSize(100, 40);
		yesL.setLocation(150, 130);
		yesL.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		yesL.setForeground(Color.black);		
		
		di.add(jl);
		di.add(orange);
		di.add(yesL);
		di.setComponentZOrder(yesL, 0);
		di.setUndecorated(true);
		di.setVisible(true);
		
		
	}

	public int getTimerSec() {
		return timerSec;
	}


	public void setTimerSec(int timerSec) {
		this.timerSec = timerSec;
	}


	public int getTimerSleep() {
		return timerSleep;
	}


	public void setTimerSleep(int timerSleep) {
		this.timerSleep = timerSleep;
	}
	
	
	
}


