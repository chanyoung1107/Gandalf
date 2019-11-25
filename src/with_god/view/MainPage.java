package with_god.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;
import with_god.model.vo.User;

public class MainPage extends JPanel {
	
	private JFrame mf;
	private JPanel jp;
	private JLabel background, startText;
	private JLabel store, setting, myPage, exit, gameStart, coin2, ranking; 
	private int coinCount;
	
	public MainPage() {}
	
	public MainPage(JFrame mf, User user) {
		
		this.mf = mf;
		jp = this;
		
		coinCount = user.getCoin();
		
		this.setSize(1300, 800);
		this.setLayout(null);
		
		background = new JLabel(new ImageIcon(new ImageIcon("src/image/gamebackground.jpg").getImage().getScaledInstance(1300, 800, 0)));
		background.setBounds(0, 0, 1300, 800);
		
		store = new JLabel(new ImageIcon(new ImageIcon("images/store.png").getImage().getScaledInstance(50, 50, 0)));
		store.setBounds(1150, 20, 50, 50);
		store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new EJ_StoreManager(mf,user));
			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				store.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		setting = new JLabel(new ImageIcon(new ImageIcon("images/Setting.png").getImage().getScaledInstance(50, 50, 0)));
		setting.setBounds(1150, 700, 50, 50);
		setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SB_SettingPage(mf);
			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});

		
		myPage = new JLabel(new ImageIcon(new ImageIcon("images/myPage.png").getImage().getScaledInstance(50, 50, 0)));
		myPage.setBounds(1080, 700, 50, 50);
		myPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CY_MyPage(mf);
			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				myPage.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		exit = new JLabel(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(50, 50, 0)));
		exit.setBounds(1220, 700, 50, 50);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CY_AskExit(mf, jp);
			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		coin2 = new JLabel(coinCount + "");
		coin2.setIcon(new ImageIcon(new ImageIcon("Images/coin.png").getImage().getScaledInstance(50, 50, 0)));
		coin2.setSize(200, 50);
		coin2.setLocation(20, 20);
		coin2.setForeground(Color.WHITE);
		coin2.setFont(new Font("DX새날B",Font.BOLD,25));
		
		ranking = new JLabel(new ImageIcon(new ImageIcon("Images/Ranking.png").getImage().getScaledInstance(50, 50, 0)));
		ranking.setBounds(1220, 20, 50, 50);
		ranking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new SB_Ranking(mf));

			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				ranking.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		gameStart = new JLabel(new ImageIcon(new ImageIcon("images/redButton.png").getImage().getScaledInstance(150, 50, 0)));
		gameStart.setSize(150, 50);
		gameStart.setLocation(575, 650);
		gameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new EJ_GameModeChoicePanel(mf, user));

			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				gameStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});
		
		startText = new JLabel("게임 시작", JLabel.CENTER);
		startText.setBounds(575, 650, 150, 50);
		startText.setForeground(Color.WHITE);
		startText.setFont(new Font("휴먼편지체",Font.BOLD,25));
		
//		EJ_Timer timer = new EJ_Timer(mf, jp);
//		Thread t1 = timer;
//		t1.run();
		
//		JLabel stop = new JLabel("STOP");
//		stop.setBounds(400,400, 100, 100);
//		stop.setForeground(Color.WHITE);
//		stop.setFont(new Font("DX새날B",Font.BOLD,25));
//		stop.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
////				timer.setTimerSleep()
//			}
//		});
		
		
		this.add(store);
		this.add(setting);
		this.add(myPage);
		this.add(exit);
		this.add(gameStart);
		this.add(ranking);
		this.add(coin2);
		this.add(background);
		this.add(startText);
//		this.add(stop);
		
//		this.setComponentZOrder(stop,0);
		this.setComponentZOrder(startText, 0);
		this.setComponentZOrder(background, 8);
		
		mf.add(this);
		
	}

}
