package with_god.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;

public class YH_InGamePanel extends JPanel {

	private JFrame mf;
	private JPanel panel;
	
	public YH_GameBoard2[] yh = new YH_GameBoard2[100];
	public YH_QuizAnswer qa = new YH_QuizAnswer();
	
	private String com;
	private String quizKinds;
	
	private int answerCtn = 0;
	private int f;
	
	boolean onOff = true;
	
	
	public YH_InGamePanel(){
	}

	public YH_InGamePanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setSize(1300, 800);
		this.setOpaque(true);
		this.setLayout(null);
		this.setBackground(Color.gray);

		JLabel start = new JLabel("게임시작하려면 누르세요111111");
		start.setForeground(Color.black);
		start.setBounds(1100, 600, 200, 200);
		start.setLayout(null);
		start.setOpaque(true);

		JLabel start1 = new JLabel("게임시작하려면 누르세요222222");
		start1.setForeground(Color.white);
		start1.setBounds(850, 400, 200, 200);
		start1.setLayout(null);
		start1.setOpaque(true);


		for (int j = 0; j < yh.length; j++) {
			f=j;
			yh[j] = new YH_GameBoard2(panel, this, yh, f);
		}


		f=0;
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				quizKinds = "넌센스문제.txt";
				yh[f].CreateGameboard(quizKinds);
				panel.repaint();
			
				
				

				
				System.out.println("이벤트 종료");
			}
			
		});

		System.out.println("이벤트 종료2");
		this.add(start);
		mf.add(this);
	}
	
	
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
//	public int getX() {
//		return x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public String getQuizKinds() {
		return quizKinds;
	}

	public void setQuizKinds(String quizKinds) {
		this.quizKinds = quizKinds;
	}
	
}