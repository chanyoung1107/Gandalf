package with_god.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;
import with_god.controller.EJ_RandomBox;
import with_god.model.vo.User;

public class EJ_StoreManager extends JPanel {
	private JFrame mf;
	private JPanel jp;
	private JPanel jp1;
	private JLabel randomButton;
	private JLabel boxButton, exit;
	private JLabel storeName, coin, coin2, bbob;
	private JLabel itemcount1, itemcount2, itemcount3;
	private JLabel backgroundImage;
	private JLabel item1, item2, item3;
	private int boxW = 220;
	private int boxH = 150;
	private int imageSizeW = 130;
	private int imageSizeH = 160;
	private int coinCount;

	public EJ_StoreManager() {}
	
	public EJ_StoreManager(JFrame mf, User user) {

		EJ_RandomBox rb = new EJ_RandomBox();
		this.mf = mf;
		coinCount = user.getCoin();
		
		jp = this;
		jp.setSize(1300,800);
		jp.setLayout(null);

		backgroundImage = new JLabel(new ImageIcon(new ImageIcon("Images/¹è°æ11.jpg").getImage().getScaledInstance(1300, 800, 0)));
		backgroundImage.setBounds(0, 0, 1300, 800);

		itemcount1 = new JLabel("´öÃá : " + user.getItemCountD() + "");
		itemcount1.setSize(220,60);
		itemcount1.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,20));
		itemcount1.setLocation(390,620);
		itemcount1.setForeground(Color.WHITE);

		itemcount2 = new JLabel("ÇØ¿ø¸Æ : " + user.getItemCountH() + "");
		itemcount2.setSize(220,60);
		itemcount2.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,20));
		itemcount2.setLocation(600,620);
		itemcount2.setForeground(Color.WHITE);

		itemcount3 = new JLabel("°­¸² : " + user.getItemCountK() + "");
		itemcount3.setSize(220,60);
		itemcount3.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,20));
		itemcount3.setLocation(820,620);
		itemcount3.setForeground(Color.WHITE);

		coin2 = new JLabel(coinCount + "");
		coin2.setIcon(new ImageIcon(new ImageIcon("Images/coin.png").getImage().getScaledInstance(50, 50, 0)));
		coin2.setSize(200, 50);
		coin2.setLocation(20, 20);
		coin2.setForeground(Color.WHITE);
		coin2.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,25));

		Image boxbox = new ImageIcon("Images/º¸¹°»óÀÚ.png").getImage().getScaledInstance(boxW,boxH, 0);

		boxButton = new JLabel(new ImageIcon(boxbox));
		boxButton.setSize(boxW,boxH);
		boxButton.setLocation(540, 220);

		boxButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(coinCount >= 1000) {

					rb.sd(mf, user).setVisible(true);
					itemcount1.setText("´öÃá : " + user.getItemCountD() + "");
					itemcount2.setText("ÇØ¿ø¸Æ : " + user.getItemCountH() + "");
					itemcount3.setText("°­¸² : " + user.getItemCountK() + "");
					coinCount -= 1000;
					coin2.setText(coinCount + "");
										
					
				}else {
					JOptionPane.showMessageDialog(mf, "you don't have coin", "coin X", JOptionPane.ERROR_MESSAGE);
				}
			}
			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				boxButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
		});

		storeName = new JLabel("»óÁ¡");
		storeName.setSize(200, 95);
		storeName.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,50));
		storeName.setLocation(610, 10);
		storeName.setForeground(Color.ORANGE);

		bbob = new JLabel("»Ì±â");
		bbob.setSize(200, 95);
		bbob.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,40));
		bbob.setLocation(630, 115);
		bbob.setForeground(Color.ORANGE);

		item1 = new JLabel(new ImageIcon(new ImageIcon("Images/´öÃá.png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
		item1.setSize(imageSizeW, imageSizeH);
		item1.setLocation(380, 470);

		item2 = new JLabel(new ImageIcon(new ImageIcon("Images/ÇØ¿ø¸Æ.png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
		item2.setSize(imageSizeW, imageSizeH);
		item2.setLocation(585, 470);

		item3 = new JLabel(new ImageIcon(new ImageIcon("Images/°­¸².png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
		item3.setSize(imageSizeW, imageSizeH);
		item3.setLocation(810, 470);

		coin = new JLabel(1000+"");
		coin.setIcon(new ImageIcon(new ImageIcon("Images/coin.png").getImage().getScaledInstance(50, 50, 0)));
		coin.setSize(220,60);
		coin.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼",Font.BOLD,30));
		coin.setLocation(605,390);
		coin.setForeground(Color.WHITE);



		exit = new JLabel(new ImageIcon(new ImageIcon("Images/exit.png").getImage().getScaledInstance(50, 50, 0)));
		exit.setSize(50, 50);
		exit.setLocation(1220, 700);

		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage mp = new MainPage(mf);
				
				ChangePanel.changePanel(mf, jp,mp);

				
//				EJ_Timer timer = new EJ_Timer(mf, mp);
//				Thread t1 = timer;
//				t1.start();
			
			}
			
		});
		


		jp.add(backgroundImage);
		jp.add(storeName);
		jp.add(boxButton);
		jp.setComponentZOrder(boxButton, 1);	
		jp.setComponentZOrder(backgroundImage, 1);
		jp.setComponentZOrder(storeName, 1);
		jp.setComponentZOrder(item1, 1);
		jp.setComponentZOrder(item2, 1);
		jp.setComponentZOrder(item3, 1);
		jp.setComponentZOrder(coin, 1);
		jp.setComponentZOrder(coin2, 2);
		jp.setComponentZOrder(bbob, 1);
		jp.setComponentZOrder(itemcount1, 1);
		jp.setComponentZOrder(itemcount2, 1);
		jp.setComponentZOrder(itemcount3, 1);
		jp.setComponentZOrder(exit, 1);
		mf.add(jp);
	}


}
