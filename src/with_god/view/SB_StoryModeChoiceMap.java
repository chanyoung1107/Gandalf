package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;
import with_god.model.vo.User;


public class SB_StoryModeChoiceMap extends JPanel {

	private JFrame mf;
	private JPanel jp;
	private boolean stage2 =  false;
	private boolean stage3 =  false;
	private boolean stage4 =  true; 
	private int computer = 200;
	private int win = 1;
	public SB_StoryModeChoiceMap(JFrame mf, User user) {
		jp = this;
		this.mf = mf;
		this.setBounds(0, 0, 1300, 800);
		this.setLayout(null);

		Image background = new ImageIcon("images/gw.png").getImage().getScaledInstance(1300, 800, 0);
		Image stageChoice1 = new ImageIcon("images/stageChoice11.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice2 = new ImageIcon("images/stageChoice2.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice3 = new ImageIcon("images/stageChoice3.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice4 = new ImageIcon("images/stageChoice4.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice5 = new ImageIcon("images/stageChoice5.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice6 = new ImageIcon("images/stageChoice6.png").getImage().getScaledInstance(150, 120, 0);
		Image stageChoice7 = new ImageIcon("images/stageChoice7.png").getImage().getScaledInstance(150, 120, 0);
		Image exit = new ImageIcon("images/exit.png").getImage().getScaledInstance(50, 50, 0);

		JLabel backgroundL = new JLabel(new ImageIcon(background));
		JLabel stageChoice1L = new JLabel(new ImageIcon(stageChoice1));
		JLabel stageChoice2L = new JLabel(new ImageIcon(stageChoice2));
		JLabel stageChoice3L = new JLabel(new ImageIcon(stageChoice3));
		JLabel stageChoice4L = new JLabel(new ImageIcon(stageChoice4));
		JLabel stageChoice5L = new JLabel(new ImageIcon(stageChoice5));
		JLabel stageChoice6L = new JLabel(new ImageIcon(stageChoice6));
		JLabel stageChoice7L = new JLabel(new ImageIcon(stageChoice7));
		JLabel exitL = new JLabel(new ImageIcon(exit));
		
		JLabel stageName1 = new JLabel("ººøµ¡ˆø¡");
		JLabel stageName2 = new JLabel("¬˘øµ¡ˆø¡");
		JLabel stageName3 = new JLabel("º±∫Û¡ˆø¡");
		JLabel stageName4 = new JLabel("¿∫¡¯¡ˆø¡");
		JLabel stageName5 = new JLabel("øÎ»∆¡ˆø¡");
		JLabel stageName6 = new JLabel("¿±¡ﬂ¡ˆø¡");
		JLabel stageName7 = new JLabel("ø∞∂Û¡¯»£");
		
		//SB_Music introMusic = new SB_Music("bgm.mp3", true);
		//introMusic.start();
		
		stageName1.setBounds(240, 590, 100, 100);
		stageName1.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName1.setForeground(Color.ORANGE);

		stageName2.setBounds(390, 390, 100, 100);
		stageName2.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName2.setForeground(Color.CYAN);
		
		stageName3.setBounds(540, 590, 100, 100);
		stageName3.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName3.setForeground(Color.GREEN);
		
		stageName4.setBounds(690, 390, 100, 100);
		stageName4.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName4.setForeground(Color.YELLOW);
		
		stageName5.setBounds(840, 600, 100, 100);
		stageName5.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName5.setForeground(Color.MAGENTA);
		
		stageName6.setBounds(990, 400, 100, 100);
		stageName6.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName6.setForeground(Color.ORANGE);
		
		stageName7.setBounds(610, 190, 100, 100);
		stageName7.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 20));
		stageName7.setForeground(Color.RED);
		
		
		backgroundL.setSize(1300, 800);
		stageChoice1L.setBounds(210, 500, 150, 120);
		stageChoice1L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//SB_StoryModeT smt = new SB_StoryModeT(mf);
				ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice1L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice2L.setBounds(360, 300, 150, 120);
		stageChoice2L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (win == 2){
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice2L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice3L.setBounds(510, 500, 150, 120);
		stageChoice3L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (win == 3) {
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice3L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice4L.setBounds(660, 300, 150, 120);
		stageChoice4L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(win == 4) {
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice4L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice5L.setBounds(810, 500, 150, 150);
		stageChoice5L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(win == 5) {
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice5L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice6L.setBounds(960, 300, 150, 150);
		stageChoice6L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(win == 6) {
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice6L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		stageChoice7L.setBounds(580, 90, 150, 150);
		stageChoice7L.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(win == 7) {
					ChangePanel.changePanel(mf, jp, new IngamePage2(mf, user));
				}else {
					new SB_StageAccess(mf);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stageChoice7L.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		exitL.setBounds(1220, 700, 50, 50);
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new MainPage(mf));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});

		this.add(stageChoice1L);
		this.add(stageChoice2L);
		this.add(stageChoice3L);
		this.add(stageChoice4L);
		this.add(stageChoice5L);
		this.add(stageChoice6L);
		this.add(stageChoice7L);
		this.add(stageName1);
		this.add(stageName2);
		this.add(stageName3);
		this.add(stageName4);
		this.add(stageName5);
		this.add(stageName6);
		this.add(stageName7);
		this.add(backgroundL);
		this.add(exitL);

		/*
		 * this.setComponentZOrder(stageChoice1L, 0);
		 * this.setComponentZOrder(stageChoice2L, 0);
		 * this.setComponentZOrder(stageChoice3L, 0);
		 * this.setComponentZOrder(stageChoice4L, 0);
		 * this.setComponentZOrder(stageChoice5L, 0);
		 * this.setComponentZOrder(stageChoice6L, 0);
		 * this.setComponentZOrder(stageChoice7L, 0);
		 * this.setComponentZOrder(backgroundL, 3);
		 */
		mf.add(this);

	}
}
