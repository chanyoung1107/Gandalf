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

public class EJ_GameModeChoicePanel extends JPanel{
	private JFrame mf;
	private JPanel jp;
	private JLabel backgroundImage;
	private JLabel modeButton1, modeButton2, modeButton3;
	private JLabel coin2, exit;
	private int coinCount;
	private int buttonW = 150;
	private int buttonH = 50;
	private JLabel text1, text2, text3;
	private int button2W = 575;

	public EJ_GameModeChoicePanel() {}

	public EJ_GameModeChoicePanel(JFrame mf, User user) {

		this.mf = mf;
		jp = this;
		coinCount = user.getCoin();
		jp.setSize(1300,800);
		jp.setLayout(null);

		backgroundImage = new JLabel(new ImageIcon(new ImageIcon("src/Image/gamebackground.png").getImage().getScaledInstance(1300, 800, 0)));
		backgroundImage.setBounds(0, 0, 1300, 800);

		modeButton1 = new JLabel(new ImageIcon(new ImageIcon("Images/greenButton.jpg").getImage().getScaledInstance(buttonW, buttonH, 0)));
		modeButton1.setSize(buttonW, buttonH);
		modeButton1.setLocation(button2W-buttonW-80, 650);
		modeButton1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CategoryChoice cc = new CategoryChoice(mf, jp, user);


			}
		});


		modeButton2 = new JLabel(new ImageIcon(new ImageIcon("Images/purpleButton.png").getImage().getScaledInstance(buttonW, buttonH, 0)));
		modeButton2.setSize(buttonW, buttonH);
		modeButton2.setLocation(button2W, 650);
		modeButton2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				ChangePanel.changePanel(mf, jp, new SB_StoryModeChoiceMap(mf, user));

			}

			//					@Override
			//					public void mouseEntered(MouseEvent e) {
			//						yesL.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//						SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
			//						buttonEnteredMusic.start();
			//					}

	});

	modeButton3 = new JLabel(new ImageIcon(new ImageIcon("Images/redButton.png").getImage().getScaledInstance(buttonW, buttonH, 0)));
	modeButton3.setSize(buttonW, buttonH);
	modeButton3.setLocation(button2W+buttonW+80, 650);
	modeButton3.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			//ChangePanel.changePanel(mf, jp, new EJ_StoreManager(mf, user));
			Dialog di = new Dialog(mf, "End", true);
			di.setSize(400,200);
			di.setLocationRelativeTo(mf);
			//di.setBackground(Color.BLACK);
			di.setLayout(null);
			
			JLabel orange = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(100, 40, 0)));
			orange.setSize(100, 40);
			orange.setLocation(150, 130);
			orange.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ChangePanel.changePanel(mf, jp, new EJ_GameModeChoicePanel(mf, user));
					di.dispose();
				}
			});
			JLabel back = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(400, 200, 0)));
			back.setBounds(0,0, 400, 200);
			
			JLabel jl = new JLabel("구현 중........", JLabel.CENTER);
			jl.setSize(400,50);
			jl.setLocation(0, 50);
			jl.setFont(new Font("휴먼편지체", Font.BOLD, 30));
			jl.setForeground(Color.WHITE);
			
			JLabel yesL = new JLabel("확인", JLabel.CENTER);
			yesL.setSize(100, 40);
			yesL.setLocation(150, 130);
			yesL.setFont(new Font("휴먼편지체", Font.BOLD, 20));
			yesL.setForeground(Color.black);		
			
			di.add(jl);
			di.add(orange);
			di.add(yesL);
			di.add(back);
			di.setComponentZOrder(back, 3);
			di.setComponentZOrder(yesL, 0);
			di.setUndecorated(true);
			di.setVisible(true);
			

		}

		//			@Override
		//			public void mouseEntered(MouseEvent e) {
		//				modeButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
		//				buttonEnteredMusic.start();
		//			}

	});

	text1 = new JLabel("카테고리", JLabel.CENTER);
	text1.setSize(buttonW, buttonH);
	text1.setLocation(button2W-buttonW-80, 650);
	text1.setForeground(Color.WHITE);
	text1.setFont(new Font("휴먼편지체",Font.BOLD,20));


	text2 = new JLabel("스토리", JLabel.CENTER);
	text2.setSize(buttonW, buttonH);
	text2.setLocation(button2W, 650);
	text2.setFont(new Font("휴먼편지체",Font.BOLD,20));
	text2.setForeground(Color.WHITE);


	text3 = new JLabel("1대1 대전", JLabel.CENTER);
	text3.setSize(buttonW, buttonH);
	text3.setLocation(button2W+buttonW+80, 650);
	text3.setFont(new Font("휴먼편지체",Font.BOLD,20));
	text3.setForeground(Color.WHITE);


	coin2 = new JLabel(coinCount + "");
	coin2.setIcon(new ImageIcon(new ImageIcon("Images/coin.png").getImage().getScaledInstance(50, 50, 0)));
	coin2.setSize(200, 50);
	coin2.setLocation(20, 20);
	coin2.setForeground(Color.WHITE);
	coin2.setFont(new Font("휴먼편지체",Font.BOLD,25));

	exit = new JLabel(new ImageIcon(new ImageIcon("Images/exit.png").getImage().getScaledInstance(50, 50, 0)));
	exit.setSize(50, 50);
	exit.setLocation(1220, 700);
	exit.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, jp, new MainPage(mf));


			//				Timer timer = new Timer(mf, sm);
			//
			//				Thread t1 = timer;
			//				t1.start();

		}

		//			@Override
		//			public void mouseEntered(MouseEvent e) {
		//				exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
		//				buttonEnteredMusic.start();
		//			}
	});

	//		jp.add(backgroundImage);
	//		jp.add(modeButton1);
	//		jp.add(modeButton2);
	//		jp.add(modeButton3);
	jp.add(text1);
	jp.add(text2);
	jp.add(text3);

	jp.setComponentZOrder(text1, 0);
	jp.setComponentZOrder(text2, 0);
	jp.setComponentZOrder(text3, 0);
	jp.setComponentZOrder(backgroundImage, 3);
	jp.setComponentZOrder(modeButton1, 3);
	jp.setComponentZOrder(modeButton2, 3);
	jp.setComponentZOrder(modeButton3, 3);
	jp.setComponentZOrder(coin2, 0);
	jp.setComponentZOrder(exit, 0);
	mf.add(jp);

}

/*	public void gbinsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		di.add(c);
	}*/
}
