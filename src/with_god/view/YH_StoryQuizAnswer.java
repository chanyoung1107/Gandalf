package with_god.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import with_god.controller.UserManager;
import with_god.model.vo.User;
import with_god.model.vo.YH_Quiz;

public class YH_StoryQuizAnswer extends JTextField {

	private JPanel panel;
	
	private String text;
	
	private static int f;
	
	boolean goStop = true;
	
	private IngamePage2 igp;
	private YH_StoryGameBoard[] gb;
	private User user;

	private JLabel[][] l;
	private YH_Quiz[][][] quiz;
	UserManager um = new UserManager();
	
	public YH_StoryQuizAnswer() {

	}

	public YH_StoryQuizAnswer(JPanel panel, YH_Quiz[][][] quiz, JLabel[][] l, IngamePage2 igp, YH_StoryGameBoard[] gb,
			int f, User user) {
		this.panel = panel;
		this.quiz = quiz;
		this.l = l;
		this.igp = igp;
		this.gb = gb;
		this.f = f;
		this.user = user;
		JTextField tf = new JTextField(30);
		tf.setBounds(690, 200, 570, 80);
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text = tf.getText();
				goStop = true;
				KeyCompare();
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(tf);
	}

	public void KeyCompare() {

		System.out.println("igp.getCom()의 값 : " + igp.getCom());
		System.out.println("text의 값 : " + text);

		if (igp.getCom().equals(text)) {
			System.out.println("일치한다");

			igp.setAnswerCtn(igp.getAnswerCtn() + 1);
			for (int i = 0; i < l.length; i++) {
				for (int j = 0; j < l[i].length; j++) {
					if (gb[igp.getF()].quiz[igp.getF()][i][j].getKey().equals(text)
							|| gb[igp.getF()].quiz[igp.getF()][i][j].getKey2().equals(text)) {
						gb[igp.getF()].l[i][j].setText(gb[igp.getF()].quiz[f][i][j].getCh() + "");
						gb[igp.getF()].l[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
						gb[igp.getF()].l[i][j].setOpaque(true);
						gb[igp.getF()].l[i][j].setBackground(Color.GRAY);
						// yh[igp.getF()].l[i][j].setBorder(new LineBorder(Color.red, 5, true));
						if (goStop) {
							igp.setScore(igp.getScore() + 10);
							igp.getScoreL().setText("Score : " + igp.getScore());
							goStop = false;
						}
					}
				}
			}
			if (igp.getAnswerCtn() == 15) {
				panel.remove(gb[igp.getF()]);
				igp.setF(igp.getF() + 1);
				gb[igp.getF()].CreateGameboard(igp.getQuizKinds());
				panel.repaint();
				igp.setAnswerCtn(0);
				
				user.setScore(user.getScore()+igp.getScore());
				user.setCoin(user.getCoin() + 500);
				
				um.updateScore(user);
				um.updateCoin(user);
				
				System.out.println(user.getCoin());
				System.out.println(user.getScore());
			}

		} else {
			System.out.println("일치하지 않는다.");
		}

		System.out.println("이벤트 종료6");
	}
}
