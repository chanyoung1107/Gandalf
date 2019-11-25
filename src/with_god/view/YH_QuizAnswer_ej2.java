package with_god.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import with_god.model.vo.YH_Quiz;

public class YH_QuizAnswer_ej2 extends JTextField {

	private JPanel panel;
	private YH_Quiz[][][] quiz;
	private String text;
	private String getKey;
	private JTextField tf;
	private String[] compareArr;
	private JLabel[][] l;
	private int i1, j1;
	private int answerCtn = 0;
	private static int f;
	// private InGamePage igp;
	private IngamePage2 igp;
	private YH_GameBoard_ej2[] gb;
	int gg = 0;;

	public YH_QuizAnswer_ej2() {

	}

	public YH_QuizAnswer_ej2(JPanel panel, YH_Quiz[][][] quiz, String[] compareArr, JLabel[][] l, int i1, int j1,
			/* InGamePage igp */IngamePage2 igp, YH_GameBoard_ej2[] gb, int f) {
		this.panel = panel;
		this.quiz = quiz;
		this.compareArr = compareArr;
		this.l = l;
		this.i1 = i1;
		this.j1 = j1;
		this.igp = igp;
		this.gb = gb;
		this.f = f;
		JTextField tf = new JTextField(30);
		tf.setBounds(690, 200, 570, 80);

		System.out.println("f의 값&&&&&&&&&&&&&&&&&&&&&& " + f);

		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text = tf.getText();

				if (text != null && !text.equals("")) {
					// compareArr[1] = text;

					KeyCompare();
				}
				System.out.println("이벤트 종료11");
				tf.setText("");
				tf.requestFocus();
			}
		});
		// tf.addActionListener(new MyEvent(tf));

		panel.add(tf);
		System.out.println("이벤트 종료5");
	}

	public void KeyCompare() {

		// panel.remove(yh[0]);
		// panel.repaint();
		//
		// yh[1].CreateGameboard();
		// panel.repaint();

		for (int i = 0; i < quiz.length; i++) {
			if (quiz[i] != null) {
				gg++;
			}
		}
		System.out.println("ggggggggggggggggggg ===== " + gg);

		for (int i = 0; i < gb[igp.getF()].quiz[igp.getF()].length; i++) {
			for (int j = 0; j < gb[igp.getF()].quiz[igp.getF()][i].length; j++) {
				System.out.println("quiz " + gb[igp.getF()].quiz[igp.getF()][i][j].getKey());
			}
		}
		System.out.println("quiz " + gb[igp.getF()].quiz[igp.getF()][5][6].getKey());
		// System.out.println("qiiz " + quiz[igp.getF()+1][5][6].getKey());

		System.out.println("igp.getCom()의 값 : " + igp.getCom());
		System.out.println("text의 값 : " + text);
		System.out.println("quiz[i1][j1].getKey()의 값 : " + gb[igp.getF()].quiz[igp.getF()][i1][j1].getKey());
		System.out.println("ffffffffffffff ==== " + igp.getF());
		System.out.println("i1의 값 : " + i1);
		System.out.println("j1의 값 : " + j1);
		System.out.println("igp.getY()의 값 : " + igp.getY());
		System.out.println("igp.getX()의 값 : " + igp.getX());

		if (igp.getCom().equals(text)) {
			System.out.println("일치한다");

			System.out.println("게임판 바꾼다@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			igp.setAnswerCtn(igp.getAnswerCtn() + 1);
			for (int i = 0; i < l.length; i++) {
				for (int j = 0; j < l[i].length; j++) {
					if (gb[igp.getF()].quiz[igp.getF()][i][j].getKey().equals(text)
							|| gb[igp.getF()].quiz[igp.getF()][i][j].getKey2().equals(text)) {
						gb[igp.getF()].l[i][j].setText(gb[igp.getF()].quiz[f][i][j].getCh() + "");
						gb[igp.getF()].l[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
						gb[igp.getF()].l[i][j].setOpaque(true);
						gb[igp.getF()].l[i][j].setBackground(Color.GRAY);
//						yh[igp.getF()].l[i][j].setBorder(new LineBorder(Color.red, 5, true));
					}
				}
			}
//l[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
			//label.setOpaque(true); 
	      //  label.setBackground(Color.RED);
			if (igp.getAnswerCtn() == 10) {
				panel.remove(gb[igp.getF()]);
				igp.setF(igp.getF() + 1);
				gb[igp.getF()].CreateGameboard();
				panel.repaint();
				igp.setAnswerCtn(0);
			}

			// if(igp.getAnswerCtn() == 1) {
			//
			// igp.go();
			// }

		} else {
			System.out.println("일치하지 않는다.");
		}

		System.out.println("이벤트 종료6");
	}

	public int answerCtn() {
		return answerCtn;
	}
	/*
	 * class MyEvent implements ActionListener {
	 * 
	 * private JTextField tf;
	 * 
	 * public MyEvent(JTextField tf) { this.tf = tf; }
	 * 
	 * // 내부 클래스를 선언한다
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { String text =
	 * tf.getText();
	 * 
	 * 
	 * System.out.println(text);
	 * 
	 * tf.setText(""); tf.requestFocus(); } }
	 */

}
