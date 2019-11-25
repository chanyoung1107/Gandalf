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

public class IngamePage2 extends JPanel {
	private JPanel jp;
	private JFrame mf;
	private JLabel itemK, itemD, itemH;
	private JLabel background;
	private JLabel nemo, question, answer;
	private JLabel infoBox, exit, king, VS;
	private JLabel clientImage, clientNick, clientWin, clientDream;

	////////////////////// ���� �߰��Ѱ�////////////////////////////////
	public YH_QuizAnswer_ej2 qa = new YH_QuizAnswer_ej2();
	public YH_GameBoard_ej2[] gb = new YH_GameBoard_ej2[100];
	private int i = 0;
	private int answerCtn = 0;
	private String com;
	private int x, y;
	private int f;
	//////////////////////////////////////////////////////////////

	private int itemCountK, itemCountD, itemCountH;
	private JLabel itemCountKT, itemCountDT, itemCountHT;

	public IngamePage2() {
	}

	public IngamePage2(JFrame mf, User user, int stageNumber/* , Thread t1 */) {
		this.mf = mf;
		jp = this;

		// YH_GameBoard gb = new YH_GameBoard(jp);
		////////////////////// ���� �߰��Ѱ�////////////////////////////////
		for (int j = 0; j < gb.length; j++) {
			f = j;
			gb[j] = new YH_GameBoard_ej2(jp, this, gb, f);
		}
		////////////////////// ���� �߰��Ѱ�////////////////////////////////
//		nemo = gb;
//		nemo.setBounds(30, 30, 620, 620);

		Dialog di2 = new Dialog(mf, "Ȯ��", true);
		di2.setSize(400, 250);
		di2.setLocationRelativeTo(mf);
		di2.setBackground(Color.BLACK);
		di2.setLayout(null);

		JLabel jl = new JLabel("������ �����Ͻðڽ��ϱ�?");
		jl.setForeground(Color.WHITE);
		jl.setBounds(80, 50, 260, 100);
		jl.setFont(new Font("DX����B", Font.BOLD, 30));

		JLabel yesL = new JLabel(
				new ImageIcon(new ImageIcon("Images/yes.png").getImage().getScaledInstance(90, 40, 0)));
		// yesL.setBounds(100, 300, 100, 50);
		yesL.setSize(90, 40);
		yesL.setLocation(80, 170);
		f=0;
		yesL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingamepanel(mf, jp, user, stageNumber);
				gb[f].CreateGameboard();
				jp.repaint();

				di2.dispose();
			}

			// @Override
			// public void mouseEntered(MouseEvent e) {
			// yesL.setCursor(new Cursor(Cursor.HAND_CURSOR));
			// SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
			// buttonEnteredMusic.start();
			// }
		});

		JLabel noL = new JLabel(new ImageIcon(new ImageIcon("Images/no.png").getImage().getScaledInstance(90, 40, 0)));
		// noL.setBounds(300, 300, 100, 50);
		noL.setSize(90, 40);
		noL.setLocation(230, 170);

		noL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new EJ_GameModeChoicePanel(mf, user));

				di2.dispose();
			}

			// @Override
			// public void mouseEntered(MouseEvent e) {
			// yesL.setCursor(new Cursor(Cursor.HAND_CURSOR));
			// SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
			// buttonEnteredMusic.start();
			// }
		});
		di2.setUndecorated(true);
		di2.add(jl);
		di2.add(yesL);
		di2.add(noL);
		di2.setComponentZOrder(yesL, 0);
		di2.setComponentZOrder(noL, 0);
		di2.setVisible(true);

	}

	public void ingamepanel(JFrame mf, JPanel jp, User user, int stageNumber) {

		jp.setBounds(0, 0, 1300, 800);
		jp.setLayout(null);
		jp.setLayout(null);

		background = new JLabel(
				new ImageIcon(new ImageIcon("images/���.gif").getImage().getScaledInstance(1300, 800, 0)));
		background.setBounds(0, 0, 1300, 800);

		itemK = new JLabel(new ImageIcon(new ImageIcon("images/����.png").getImage().getScaledInstance(80, 130, 0)));
		itemK.setBounds(660, 580, 80, 130);

		itemD = new JLabel(new ImageIcon(new ImageIcon("images/����.png").getImage().getScaledInstance(80, 130, 0)));
		itemD.setBounds(755, 580, 80, 130);

		itemH = new JLabel(new ImageIcon(new ImageIcon("images/�ؿ���.png").getImage().getScaledInstance(80, 130, 0)));
		itemH.setBounds(850, 580, 80, 130);
		
		if(stageNumber == 1) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
			
		}else if(stageNumber == 2) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
		}else if(stageNumber == 3) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
		}else if(stageNumber == 4) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
		}else if(stageNumber == 5) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
		}else if(stageNumber == 6) {
			king = new JLabel(new ImageIcon(new ImageIcon("images/����.jpg").getImage().getScaledInstance(180, 250, 0)));
		}
		
		
		king.setBounds(700, 300, 180, 250);
		
		
		VS = new JLabel(new ImageIcon(new ImageIcon("images/VS.png").getImage().getScaledInstance(140, 140, 0)));
		VS.setBounds(850, 350, 140, 140);
		
		question = new JLabel(
				new ImageIcon(new ImageIcon("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(600, 150, 0)));
		question.setBounds(690, 30, 570, 150);

		answer = new JLabel(
				new ImageIcon(new ImageIcon("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(600, 80, 0)));
		answer.setBounds(690, 200, 570, 80);

		infoBox = new JLabel(
				new ImageIcon(new ImageIcon("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(300, 350, 0)));
		infoBox.setBounds(955, 330, 300, 350);
		infoBox.setBackground(Color.gray);

		clientImage = new JLabel(
				new ImageIcon(new ImageIcon(user.getImageLoad()).getImage().getScaledInstance(100, 120, 0)));
		clientImage.setBounds(1055, 350, 100, 120);

		clientNick = new JLabel(user.getNickName(), JLabel.CENTER);
		clientNick.setLocation(955, 460);
		clientNick.setSize(300, 60);
		clientNick.setFont(new Font("���", Font.BOLD, 20));
		clientNick.setForeground(Color.WHITE);

		clientWin = new JLabel("����             " + user.getWin() + "/" + user.getLose());
		clientWin.setLocation(970, 500);
		clientWin.setSize(200, 60);
		clientWin.setFont(new Font("���", Font.BOLD, 20));
		clientWin.setForeground(Color.WHITE);

		clientDream = new JLabel("�巡���        " + user.getDream());
		clientDream.setLocation(970, 550);
		clientDream.setSize(200, 60);
		clientDream.setFont(new Font("���", Font.BOLD, 20));
		clientDream.setForeground(Color.WHITE);

		itemCountK = user.getItemCountK();
		itemCountD = user.getItemCountD();
		itemCountH = user.getItemCountH();

		itemCountKT = new JLabel("���� : " + itemCountK);
		itemCountKT.setLocation(670, 700);
		itemCountKT.setSize(200, 60);
		itemCountKT.setFont(new Font("DX����B", Font.BOLD, 25));
		itemCountKT.setForeground(Color.WHITE);

		itemCountDT = new JLabel("���� : " + itemCountD);
		itemCountDT.setLocation(765, 700);
		itemCountDT.setSize(200, 60);
		itemCountDT.setFont(new Font("DX����B", Font.BOLD, 25));
		itemCountDT.setForeground(Color.WHITE);

		itemCountHT = new JLabel("�ؿ��� : " + itemCountH);
		itemCountHT.setLocation(860, 700);
		itemCountHT.setSize(200, 60);
		itemCountHT.setFont(new Font("DX����B", Font.BOLD, 25));
		itemCountHT.setForeground(Color.WHITE);

		exit = new JLabel(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(50, 50, 0)));
		exit.setBounds(1220, 700, 50, 50);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SY_exitDialog(mf, jp);

			}
		});

		// itemH.addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// try {
		// System.out.println("�ؿ����� �ð��� 5�� ��Ƚ��ϴ�!");
		// t1.suspend();
		// t1.sleep(5000);
		// t1.resume();
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// }
		// });

		//
		// itemD.addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// SY_itemDuckchun d = new SY_itemDuckchun();
		// boolean Duckchunskill = d.DuckchunRandom();
		// System.out.println("10 ����");
		// itemCountD -=1;
		// itemCountDT = new JLabel("���� : " + itemCountD);
		// }
		// });
		// itemH.addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// // SY_itemHaewonmac h = new SY_itemHaewonmac();
		// // boolean haewonmacskill = h.timeStop(mf, jp);// haewonmacskill�� true�� �����.
		// }
		// });
		//
		// /* itemK.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// SY_itemGangrim g = new SY_itemGangrim();
		// boolean gangrim = g.GangrimRandom();
		// }
		// });
		//
		//
		// itemD.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// SY_itemDuckchun d = new SY_itemDuckchun();
		// boolean haewonmacskill = d.DuckchunRandom();
		// }
		// });*/

		this.add(background);
		this.add(itemK);
		this.add(itemD);
		this.add(itemH);
//		this.add(nemo);
		this.add(question);
		this.add(answer);
		this.add(infoBox);
		this.add(exit);
		this.add(clientDream);
		this.add(clientImage);
		this.add(clientNick);
		this.add(clientWin);
		this.add(itemCountKT);
		this.add(itemCountDT);
		this.add(itemCountHT);
		this.add(king);
		this.add(VS);

		this.setComponentZOrder(background, 111);
		this.setComponentZOrder(clientDream, 1);
		this.setComponentZOrder(clientImage, 1);
		this.setComponentZOrder(clientNick, 1);
		this.setComponentZOrder(clientWin, 1);
		this.setComponentZOrder(itemCountKT, 0);
		this.setComponentZOrder(itemCountDT, 0);
		this.setComponentZOrder(itemCountHT, 0);
		this.setComponentZOrder(king, 1);
		this.setComponentZOrder(VS, 0);
		mf.add(jp);
	}
	////////////////////// ���� �߰��Ѱ�////////////////////////////////
	
	public int getAnswerCtn() {
		return answerCtn;
	}

	public void setAnswerCtn(int answerCtn) {
		this.answerCtn = answerCtn;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	////////////////////////////////////////////////////////
}
