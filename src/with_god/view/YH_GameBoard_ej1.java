package with_god.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import with_god.model.vo.YH_Quiz;

public class YH_GameBoard_ej1 extends JLabel {

	private JLabel label;
	private JPanel panel;

	boolean xLeftCheck = false;
	boolean xRightCheck = false;
	boolean yUpCheck = false;
	boolean yDownCheck = false;
	final Image empty = new ImageIcon("wall.png").getImage().getScaledInstance(70, 50, 0);

	private boolean onOff = true;
	private boolean onOff1 = false;

	private String quizTempValue = "";
	private String quizTempKey = "";

	private int quizTempKeyNum;
	private int quizCtn = 0;
	private int ctn = 0;
	private int quizCtnCheck = 25;
	int y1, x1;

	private int loopCtn = 0;
	private int num = 0;
	private int x;
	private int y;
	private int f;

	private int i1, j1;

	JLabel[][] l = new JLabel[15][15];
	YH_Quiz[][][] quiz = new YH_Quiz[100][15][15];
	private String compareArr[] = new String[2];

	private YH_QuizShowPanel qsp;
	private YH_QuizAnswer_ej1 qa;
	private InGamePage igp; //내꺼
	private YH_GameBoard_ej1[] yh; //내꺼
//	private InGamePage igp; // 은진이꺼
	
	

	public YH_GameBoard_ej1() {
	}

	public YH_GameBoard_ej1(JPanel panel, InGamePage igp/*, InGamePage igp*/, YH_GameBoard_ej1[] yh, int f) {
		System.out.println("ffffff의 값 : " + f);
		this.panel = panel;
		this.igp = igp;
		this.yh = yh;
		this.f = f;
		System.out.println("이벤트 종료7");
		label = this;

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				if (i == 0 || j == 0) {
					l[i][j] = new JLabel();
					l[i][j].setLayout(null);
					l[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
					l[i][j].setFont(new Font("굴림", 1, 15));
					l[i][j].setHorizontalAlignment(JLabel.CENTER);
					quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
				} else if (i == l.length - 1 || j == l.length - 1) {
					l[i][j] = new JLabel();
					l[i][j].setLayout(null);
					l[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
					l[i][j].setFont(new Font("굴림", 1, 15));
					l[i][j].setHorizontalAlignment(JLabel.CENTER);
					quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
				} else {
					l[i][j] = new JLabel();
					l[i][j].setLayout(null);
					l[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
					l[i][j].setFont(new Font("굴림", 1, 15));
					l[i][j].setHorizontalAlignment(JLabel.CENTER);
					quiz[f][i][j] = new YH_Quiz("", "", "", '1', 1000);
				}
			}
		}
		panel.add(label);
	}

	public void CreateGameboard() {
		
		System.out.println("f의 값 @@@@@@@@@@@@@@@@@@@ " + f);

		qsp = new YH_QuizShowPanel(panel);
		

		label.setLayout(new GridLayout(15, 15));
		label.setBackground(Color.white);
		label.setBounds(10, 20, 620, 620);
		label.setOpaque(true);

		label.setVisible(true);

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				label.add(l[i][j]);
			}
		}

		Properties prop = new Properties();
		ArrayList<String> keyList = new ArrayList<String>();
		try {

			finalLoop: while (true) {
				prop.load(new FileReader("quiz.txt"));

				
				Set key = prop.keySet();
				Set set = new LinkedHashSet();

				Object[] keyArr = key.toArray();
				while (set.size() < key.size()) {
					set.add(new Random().nextInt(key.size()));
				}

				Object[] rNum = set.toArray();
				for (int i = 0; i < key.size(); i++) {
					keyList.add((String) keyArr[(int) rNum[i]]);
				}

				int random = new Random().nextInt(set.size());
				quizTempKey = keyList.get(random);
				quizTempKeyNum = random;
				quizTempValue = (String) prop.get(keyList.get(random));

				x = new Random().nextInt(l.length - 2) + 1;
				y = new Random().nextInt(l.length - 2) + 1;


				first: while (true) {
					bk: while (onOff) {
						if (quiz[f][y][x - 1].getCh() == '0' || quiz[f][y][x - 1].getCh() == '1') {
							if (x + quizTempKey.length() < l.length) {
								for (int c = 0; c < quizTempKey.length(); c++) {

									if (!(quiz[f][y][x].getCh() == '1')) {
										if (!(quiz[f][y][x].getKey() == "")) {
											if (!(quizTempKey.charAt(0) == quiz[f][y][x].getCh())) {
												if (quiz[f][y][x].getCh() == '0') {
													break;
												}
											}
										}
									}

									if (!(quiz[f][y + 1][x].getCh() == '0')) {
										if (!(quiz[f][y + 1][x].getCh() == '1')) {
											if ((quizTempKey.charAt(quizTempKey.length() - 1) != quiz[f][y + 1][x]
													.getCh())) {
												break;
											}
										}
									}

									if (!(quiz[f][y - 1][x].getCh() == '0')) {
										if (!(quiz[f][y - 1][x].getCh() == '1')) {
											break;
										}
									}

									if (!(quiz[f][y][x].getCh() == '1')) {
										if (!(quizTempKey.charAt(0) == quiz[f][y][x].getCh())) {
											break;
										}
									}
									if ((c > 0 && c < quizTempKey.length()) && !(quiz[f][y][x + c].getCh() == '1')) {
										break;
									}
									if ((c == quizTempKey.length() - 1)) {
										if (!(quiz[f][y][x + c + 1].getCh() == '0')) {
											if (!(quiz[f][y][x + c + 1].getCh() == '1')) {
												break;
											}
										}
									}
									if ((c > 0 && c < quizTempKey.length())) {
										if (!(quiz[f][y + 1][x + c].getCh() == '0')) {
											if (!(quiz[f][y + 1][x + c].getCh() == '1')) {
												break;
											}
										}
									}
									if ((c > 0 && c < quizTempKey.length())) {
										if (!(quiz[f][y - 1][x + c].getCh() == '0')) {
											if (!(quiz[f][y - 1][x + c].getCh() == '1')) {
												break;
											}
										}
									}

									ctn++;
									if (ctn == quizTempKey.length()) {
										xRightCheck = true;
									} else {
										xRightCheck = false;
									}

									if (xRightCheck) {
										quiz[f][y][x - 1].setCh('0');
										quiz[f][y][x + quizTempKey.length()].setCh('0');
										num++;
										for (int d = 0; d < quizTempKey.length(); d++) {
											if (d == 0) {
												if (!quiz[f][y][x + d].getKey().equals("")) {
													quiz[f][y][x + d].setKey2(quizTempKey);
													quiz[f][y][x + d].setValue(quizTempValue);
													quiz[f][y][x + d].setCh(quizTempKey.charAt(d));
													quiz[f][y][x + d].setNum(quizTempKeyNum);
												} else {
													quiz[f][y][x + d].setKey(quizTempKey);
													quiz[f][y][x + d].setValue(quizTempValue);
													quiz[f][y][x + d].setCh(quizTempKey.charAt(d));
													quiz[f][y][x + d].setNum(quizTempKeyNum);
												}
											} else {
												quiz[f][y][x + d].setKey(quizTempKey);
												quiz[f][y][x + d].setValue(quizTempValue);
												quiz[f][y][x + d].setCh(quizTempKey.charAt(d));
												quiz[f][y][x + d].setNum(quizTempKeyNum);
											}

										}

										keyList.remove(quizTempKeyNum);
										quizCtn++;
										onOff = false;
										ctn = 0;
										xLeftCheck = false;
										xRightCheck = false;
										yUpCheck = false;
										yDownCheck = false;
										break bk;
									}
								}
								ctn = 0;
							}
						}

						if (quiz[f][y - 1][x].getCh() == '0' || quiz[f][y - 1][x].getCh() == '1') {
							if (y + quizTempKey.length() < l.length) {
								for (int c = 0; c < quizTempKey.length(); c++) {
									if (!(quiz[f][y][x].getCh() == '1')) {
										if (!(quiz[f][y][x].getKey().equals(""))) {
											if ((quizTempKey.charAt(0) != quiz[f][y][x].getCh())) {
												if (quiz[f][y][x].getCh() == '0') {
													break;
												}
											}
										}
									}

									if ((c > 0 && c < quizTempKey.length()) && !(quiz[f][y + c][x].getCh() == '1')) {
										break;
									}
									if ((c == quizTempKey.length() - 1) && (!(quiz[f][y + c + 1][x].getCh() == '0')
											&& !(quiz[f][y + c + 1][x].getCh() == '1'))) {
										break;
									}
									if ((c > 0 && c < quizTempKey.length())) {
										if ((!(quiz[f][y + c][x - 1].getCh() == '0'))) {
											if (!(quiz[f][y + c][x - 1].getCh() == '1')) {
												break;
											}
										}
									}
									if (!(quiz[f][y][x + 1].getCh() == '0')) {
										if (!(quiz[f][y][x + 1].getCh() == '1')) {
											if ((quizTempKey.charAt(quizTempKey.length() - 1) != quiz[f][y][x + 1]
													.getCh())) {
												break;
											}
										}
									}

									if (!(quiz[f][y][x - 1].getCh() == '0')) {
										if (!(quiz[f][y][x - 1].getCh() == '1')) {
											break;
										}
									}

									if ((c > 0 && c < quizTempKey.length())) {
										if ((!(quiz[f][y + c][x + 1].getCh() == '0'))) {
											if (!(quiz[f][y + c][x + 1].getCh() == '1')) {
												break;
											}
										}
									}
									ctn++;
									if (ctn == quizTempKey.length()) {
										yDownCheck = true;
									} else {
										yDownCheck = false;
									}

									if (yDownCheck) {
										quiz[f][y - 1][x].setCh('0');
										quiz[f][y + quizTempKey.length()][x].setCh('0');
										num++;
										for (int d = 0; d < quizTempKey.length(); d++) {
											if (d == 0) {
												if (!quiz[f][y + d][x].getKey().equals("")) {
													quiz[f][y + d][x].setKey2(quizTempKey);
													quiz[f][y + d][x].setValue(quizTempValue);
													quiz[f][y + d][x].setCh(quizTempKey.charAt(d));
													quiz[f][y + d][x].setNum(quizTempKeyNum);
												} else {
													quiz[f][y + d][x].setKey(quizTempKey);
													quiz[f][y + d][x].setValue(quizTempValue);
													quiz[f][y + d][x].setCh(quizTempKey.charAt(d));
													quiz[f][y + d][x].setNum(quizTempKeyNum);
												}
											} else {
												quiz[f][y + d][x].setKey(quizTempKey);
												quiz[f][y + d][x].setValue(quizTempValue);
												quiz[f][y + d][x].setCh(quizTempKey.charAt(d));
												quiz[f][y + d][x].setNum(quizTempKeyNum);
											}
										}
										keyList.remove(quizTempKeyNum);
										quizCtn++;
										onOff = false;
										ctn = 0;
										xLeftCheck = false;
										xRightCheck = false;
										yUpCheck = false;
										yDownCheck = false;
										break bk;
									}
								}
								ctn = 0;
							}
						}

						if (quiz[f][y][x + 1].getCh() == '0' || quiz[f][y][x + 1].getCh() == '1') {
							if (x - quizTempKey.length() > 0) {
								for (int c = 0; c < quizTempKey.length(); c++) {
									if (!(quiz[f][y][x].getCh() == '1')) {
										if (!(quiz[f][y][x].getKey().equals(""))) {
											if ((quizTempKey.charAt(0) != quiz[f][y][x].getCh())) {
												if (quiz[f][y][x].getCh() == '0') {
													break;
												}
											}
										}
									}
									if (!(quiz[f][y - 1][x].getCh() == '0')) {
										if (!(quiz[f][y - 1][x].getCh() == '1')) {
											if (quiz[f][y - 1][x].getCh() != quizTempKey
													.charAt(quizTempKey.length() - 1)) {
												break;
											}
										}
									}

									if (!(quiz[f][y][x - 1].getCh() == '0')) {
										if (!(quiz[f][y][x - 1].getCh() == '1')) {
											break;
										}
									}

									if ((c > 0 && c < quizTempKey.length()) && !(quiz[f][y][x - c].getCh() == '1')) {
										break;
									}
									if ((c == quizTempKey.length() - 1) && (!(quiz[f][y][x - c - 1].getCh() == '0')
											&& !(quiz[f][y][x - c - 1].getCh() == '1'))) {
										break;
									}
									if ((c > 0 && c < quizTempKey.length()) && (!(quiz[f][y - 1][x - c].getCh() == '0')
											&& !(quiz[f][y - 1][x - c].getCh() == '1'))) {
										break;
									}
									if ((!(quiz[f][y + 1][x - c].getCh() == '0')
											&& !(quiz[f][y + 1][x - c].getCh() == '1'))) {
										break;
									}

									ctn++;
									if (ctn == quizTempKey.length()) {
										xLeftCheck = true;
									} else {
										xLeftCheck = false;
									}
									if (xLeftCheck) {
										quiz[f][y][x + 1].setCh('0');
										quiz[f][y][x - quizTempKey.length()].setCh('0');
										num++;
										for (int d = quizTempKey.length() - 1, s = 0; d >= 0; d--, s++) {
											if (d == 0) {
												if (!quiz[f][y][x - d].getKey().equals("")) {
													quiz[f][y][x - d].setKey2(quizTempKey);
													quiz[f][y][x - d].setValue(quizTempValue);
													quiz[f][y][x - d].setCh(quizTempKey.charAt(s));
													quiz[f][y][x - d].setNum(quizTempKeyNum);
												} else {
													quiz[f][y][x - d].setKey(quizTempKey);
													quiz[f][y][x - d].setValue(quizTempValue);
													quiz[f][y][x - d].setCh(quizTempKey.charAt(s));
													quiz[f][y][x - d].setNum(quizTempKeyNum);
												}
											} else {
												quiz[f][y][x - d].setKey(quizTempKey);
												quiz[f][y][x - d].setValue(quizTempValue);
												quiz[f][y][x - d].setCh(quizTempKey.charAt(s));
												quiz[f][y][x - d].setNum(quizTempKeyNum);
											}
											y1 = y;
											x1 = x - d;
										}
										keyList.remove(quizTempKeyNum);
										quizCtn++;
										onOff = false;
										ctn = 0;
										xLeftCheck = false;
										xRightCheck = false;
										yUpCheck = false;
										yDownCheck = false;
										break bk;
									}

								}
								ctn = 0;
							}
						}
						// 위쪽으로 쓸 수 있는지 검사
						if (quiz[f][y + 1][x].getCh() == '0' || quiz[f][y + 1][x].getCh() == '1') {
							if (y - quizTempKey.length() > 0) {
								for (int c = 0; c < quizTempKey.length(); c++) {
									if (!(quiz[f][y][x].getCh() == '1')) {
										if (!(quiz[f][y][x].getKey().equals(""))) {
											if ((quizTempKey.charAt(0) != quiz[f][y][x].getCh())) {
												if (quiz[f][y][x].getCh() == '0') {
													break;
												}
											}
										}
									}
									if ((c > 0 && c < quizTempKey.length()) && !(quiz[f][y - c][x].getCh() == '1')) {
										break;
									}
									if ((c == quizTempKey.length() - 1) && (!(quiz[f][y - c - 1][x].getCh() == '0')
											&& !(quiz[f][y - c - 1][x].getCh() == '1'))) {
										break;
									}
									if ((c > 0 && c < quizTempKey.length())) {
										if ((!(quiz[f][y - c][x - 1].getCh() == '0'))) {
											if (!(quiz[f][y - c][x - 1].getCh() == '1')) {
												break;
											}
										}
									} else if (c == 0) {
										if (!(quiz[f][y][x + 1].getCh() == '0')) {
											if (!(quiz[f][y][x + 1].getCh() == '1')) {
												break;
											}
										}

										if (!(quiz[f][y][x - 1].getCh() == '0')) {
											if (!(quiz[f][y][x - 1].getCh() == '1')) {
												break;
											}
										}
									}
									if ((c > 0 && c < quizTempKey.length())) {
										if ((!(quiz[f][y - c][x + 1].getCh() == '0'))) {
											if (!(quiz[f][y - c][x + 1].getCh() == '1')) {
												break;
											}
										}
									}
									ctn++;
									if (ctn == quizTempKey.length()) {
										yUpCheck = true;
									} else {
										yUpCheck = false;
									}

									if (yUpCheck) {
										quiz[f][y + 1][x].setCh('0');
										quiz[f][y - quizTempKey.length()][x].setCh('0');
										num++;
										for (int d = quizTempKey.length() - 1, s = 0; d >= 0; d--, s++) {
											if (d == 0) {
												if (!quiz[f][y - d][x].getKey().equals("")) {
													quiz[f][y - d][x].setKey2(quizTempKey);
													quiz[f][y - d][x].setValue(quizTempValue);
													quiz[f][y - d][x].setCh(quizTempKey.charAt(s));
													quiz[f][y - d][x].setNum(quizTempKeyNum);
												} else {
													quiz[f][y - d][x].setKey(quizTempKey);
													quiz[f][y - d][x].setValue(quizTempValue);
													quiz[f][y - d][x].setCh(quizTempKey.charAt(s));
													quiz[f][y - d][x].setNum(quizTempKeyNum);
												}
											} else {
												quiz[f][y - d][x].setKey(quizTempKey);
												quiz[f][y - d][x].setValue(quizTempValue);
												quiz[f][y - d][x].setCh(quizTempKey.charAt(s));
												quiz[f][y - d][x].setNum(quizTempKeyNum);
											}
										}
										keyList.remove(quizTempKeyNum);
										quizCtn++;
										onOff = false;
										ctn = 0;
										xLeftCheck = false;
										xRightCheck = false;
										yUpCheck = false;
										yDownCheck = false;
										break bk;
									}
								}
								ctn = 0;
							}
						}
						onOff1 = true;

						if (quizCtn == quizCtnCheck || (keyList.size() == 0)) {
							break first;
						}

						if (onOff1) {

							loopCtn++;
							if (loopCtn == 300) {
								loopCtn = 0;
								onOff = true;
								onOff1 = false;
								xLeftCheck = false;
								xRightCheck = false;
								yUpCheck = false;
								yDownCheck = false;
								quizCtn = 0;
								ctn = 0;
								num = 0;
								for (int i = 0; i < l.length; i++) {
									for (int j = 0; j < l[i].length; j++) {
										if (i == 0 || j == 0) {
											quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
										} else if (i == l.length - 1 || j == l.length - 1) {
											quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
										} else {
											quiz[f][i][j] = new YH_Quiz("", "", "", '1', 1000);
										}
									}
								}
								
								while (keyList.size() != 0) {
									keyList.remove(0);
								}
								
								
								break first;
							}
							
							x = new Random().nextInt(l.length - 2) + 1;
							y = new Random().nextInt(l.length - 2) + 1;
							random = new Random().nextInt(keyList.size());
							quizTempKey = keyList.get(random);
							quizTempKeyNum = random;
							quizTempValue = (String) prop.get(quizTempKey);

							onOff1 = false;


						}

					}

					fi: while (true) {
						bkf1: for (int a = 0, a1 = 0; a < keyList.size(); a++, a1++) {
							quizTempKeyNum = a1;
							quizTempKey = keyList.get(quizTempKeyNum);
							quizTempValue = (String) prop.get(quizTempKey);

							bkf: for (int i = 1; i < l.length - 1; i++) {
								for (int j = 1; j < l[i].length - 1; j++) {

									if (quizTempKey.charAt(0) == quiz[f][i][j].getCh()) {

										if (quiz[f][i][j - 1].getCh() == '0' || quiz[f][i][j - 1].getCh() == '1') {
											if (j + quizTempKey.length() < quiz.length) {
												for (int c = 0; c < quizTempKey.length(); c++) {

													if (c > 0) {
														if (!(quiz[f][i][j + c].getCh() == '1')) {
															break;
														}
													}
													if ((c == quizTempKey.length() - 1)) {
														if (!(quiz[f][i][(j + c) + 1].getCh() == '0')) {
															if (!(quiz[f][i][(j + c) + 1].getCh() == '1')) {
																break;
															}
														}
													}
													if ((c > 0 && c < quizTempKey.length())) {
														if (!(quiz[f][i - 1][j + c].getCh() == '0')) {
															if (!(quiz[f][i - 1][j + c].getCh() == '1')) {
																break;
															}
														}
													}
													if ((!(quiz[f][i + 1][j + c].getCh() == '0')
															&& !(quiz[f][i + 1][j + c].getCh() == '1'))) {
														break;
													}

													ctn++;
													if (ctn == quizTempKey.length()) {
														xRightCheck = true;
													} else {
														xRightCheck = false;
													}

													if (xRightCheck) {
														quiz[f][i][j - 1].setCh('0');
														quiz[f][i][j + quizTempKey.length()].setCh('0');
														num++;
														for (int d = 0; d < quizTempKey.length(); d++) {
															if (d == 0) {
																if (!quiz[f][i][j + d].getKey().equals("")) {
																	quiz[f][i][j + d].setKey2(quizTempKey);
																	quiz[f][i][j + d].setValue(quizTempValue);
																	quiz[f][i][j + d].setCh(quizTempKey.charAt(d));
																	quiz[f][i][j + d].setNum(quizTempKeyNum);
																} else {
																	quiz[f][i][j + d].setKey(quizTempKey);
																	quiz[f][i][j + d].setValue(quizTempValue);
																	quiz[f][i][j + d].setCh(quizTempKey.charAt(d));
																	quiz[f][i][j + d].setNum(quizTempKeyNum);
																}
															} else {
																quiz[f][i][j + d].setKey(quizTempKey);
																quiz[f][i][j + d].setValue(quizTempValue);
																quiz[f][i][j + d].setCh(quizTempKey.charAt(d));
																quiz[f][i][j + d].setNum(quizTempKeyNum);
															}
															y1 = i;
															x1 = j + d;

														}
														keyList.remove(quizTempKeyNum);
														quizTempKeyNum--;
														quizCtn++;
														ctn = 0;
														xRightCheck = false;
														break bkf1;
													}
												}
												ctn = 0;
											}
										}
										if (quiz[f][i - 1][j].getCh() == '0' || quiz[f][i - 1][j].getCh() == '1') {
											if (i + quizTempKey.length() < l.length) {
												for (int c = 0; c < quizTempKey.length(); c++) {
													if (!(quiz[f][i][j].getCh() == '1')) {
														if (!(quiz[f][i][j].getKey() == "")) {
															if (!(quizTempKey.charAt(0) == quiz[f][i][j].getCh())) {
																if (quiz[f][i][j].getCh() == '0') {
																	break;
																}
															}
														}
													}
													if (c > 0) {
														if (!(quiz[f][i + c][j].getCh() == '1')) {
															break;
														}
													}
													if ((c == quizTempKey.length() - 1)
															&& (!(quiz[f][i + c + 1][j].getCh() == '0')
																	&& !(quiz[f][i + c + 1][j].getCh() == '1'))) {
														break;
													}
													if ((c > 0 && c < quizTempKey.length())) {
														if ((!(quiz[f][i + c][j - 1].getCh() == '0'))) {
															if (!(quiz[f][i + c][j - 1].getCh() == '1')) {
																break;
															}
														}
													}
													if ((c > 0 && c < quizTempKey.length())) {
														if ((!(quiz[f][i + c][j + 1].getCh() == '0'))) {
															if (!(quiz[f][i + c][j + 1].getCh() == '1')) {
																break;
															}
														}
													}
													ctn++;
													if (ctn == quizTempKey.length()) {
														yDownCheck = true;
													} else {
														yDownCheck = false;
													}

													if (yDownCheck) {
														quiz[f][i - 1][j].setCh('0');
														quiz[f][i + quizTempKey.length()][j].setCh('0');
														num++;
														for (int d = 0; d < quizTempKey.length(); d++) {
															if (d == 0) {
																if (!quiz[f][i + d][j].getKey().equals("")) {
																	quiz[f][i + d][j].setKey2(quizTempKey);
																	quiz[f][i + d][j].setValue(quizTempValue);
																	quiz[f][i + d][j].setCh(quizTempKey.charAt(d));
																	quiz[f][i + d][j].setNum(quizTempKeyNum);
																} else {
																	quiz[f][i + d][j].setKey(quizTempKey);
																	quiz[f][i + d][j].setValue(quizTempValue);
																	quiz[f][i + d][j].setCh(quizTempKey.charAt(d));
																	quiz[f][i + d][j].setNum(quizTempKeyNum);
																}
															} else {
																quiz[f][i + d][j].setKey(quizTempKey);
																quiz[f][i + d][j].setValue(quizTempValue);
																quiz[f][i + d][j].setCh(quizTempKey.charAt(d));
																quiz[f][i + d][j].setNum(quizTempKeyNum);
															}
															y1 = i + d;
															x1 = j;
														}
														keyList.remove(quizTempKeyNum);
														quizTempKeyNum--;
														quizCtn++;
														ctn = 0;
														yDownCheck = false;
														break bkf1;
													}
												}
												ctn = 0;
											}
										}

									} else if (quizTempKey.charAt(quizTempKey.length() - 1) == quiz[f][i][j].getCh()) {

										if (quiz[f][i][j + 1].getCh() == '0' || quiz[f][i][j + 1].getCh() == '1') {
											if (j - quizTempKey.length() > 0) {
												for (int c = 0; c < quizTempKey.length(); c++) {
													if ((c > 0 && c < quizTempKey.length())
															&& !(quiz[f][i][j - c].getCh() == '1')) {
														break;
													}
													if ((c == quizTempKey.length() - 1)
															&& (!(quiz[f][i][j - c - 1].getCh() == '0')
																	&& !(quiz[f][i][j - c - 1].getCh() == '1'))) {
														break;
													}
													if ((c > 0 && c < quizTempKey.length())
															&& (!(quiz[f][i - 1][j - c].getCh() == '0')
																	&& !(quiz[f][i - 1][j - c].getCh() == '1'))) {
														break;
													}
													if ((!(quiz[f][i + 1][j - c].getCh() == '0')
															&& !(quiz[f][i + 1][j - c].getCh() == '1'))) {
														break;
													}

													ctn++;
													if (ctn == quizTempKey.length()) {
														xLeftCheck = true;
													} else {
														xLeftCheck = false;
													}
													if (xLeftCheck) {
														quiz[f][i][j + 1].setCh('0');
														quiz[f][i][j - quizTempKey.length()].setCh('0');
														num++;
														for (int d = quizTempKey.length()
																- 1, s = 0; d >= 0; d--, s++) {
															if (d == 0) {
																if (!quiz[f][i][j - d].getKey().equals("")) {
																	quiz[f][i][j - d].setKey2(quizTempKey);
																	quiz[f][i][j - d].setValue(quizTempValue);
																	quiz[f][i][j - d].setCh(quizTempKey.charAt(s));
																	quiz[f][i][j - d].setNum(quizTempKeyNum);
																} else {
																	quiz[f][i][j - d].setKey(quizTempKey);
																	quiz[f][i][j - d].setValue(quizTempValue);
																	quiz[f][i][j - d].setCh(quizTempKey.charAt(s));
																	quiz[f][i][j - d].setNum(quizTempKeyNum);
																}
															} else {
																quiz[f][i][j - d].setKey(quizTempKey);
																quiz[f][i][j - d].setValue(quizTempValue);
																quiz[f][i][j - d].setCh(quizTempKey.charAt(s));
																quiz[f][i][j - d].setNum(quizTempKeyNum);
															}
															y1 = i;
															x1 = j - d;
														}
														keyList.remove(quizTempKeyNum);
														quizTempKeyNum--;
														quizCtn++;
														ctn = 0;
														xLeftCheck = false;
														break bkf1;
													}

												}
												ctn = 0;
											}
										}
										// 위쪽으로 쓸 수 있는지 검사
										if (quiz[f][i + 1][j].getCh() == '0' || quiz[f][i + 1][j].getCh() == '1') {
											if (i - quizTempKey.length() > 0) {
												for (int c = 0; c < quizTempKey.length(); c++) {
													if ((c > 0 && c < quizTempKey.length())
															&& !(quiz[f][i - c][j].getCh() == '1')) {
														break;
													}
													if ((c == quizTempKey.length() - 1)
															&& (!(quiz[f][i - c - 1][j].getCh() == '0')
																	&& !(quiz[f][i - c - 1][j].getCh() == '1'))) {
														break;
													}
													if (c > 0 && (!(quiz[f][i - c][j - 1].getCh() == '0')
															&& !(quiz[f][i - c][j - 1].getCh() == '1'))) {
														break;
													}
													if ((c > 0 && c < quizTempKey.length())
															&& (!(quiz[f][i - c][j + 1].getCh() == '0')
																	&& !(quiz[f][i - c][j + 1].getCh() == '1'))) {
														break;
													}
													ctn++;
													if (ctn == quizTempKey.length()) {
														yUpCheck = true;
													} else {
														yUpCheck = false;
													}

													if (yUpCheck) {
														quiz[f][i + 1][j].setCh('0');
														quiz[f][i - quizTempKey.length()][j].setCh('0');
														num++;
														for (int d = quizTempKey.length()
																- 1, s = 0; d >= 0; d--, s++) {
															if (d == 0) {
																if (!quiz[f][i - d][j].getKey().equals("")) {
																	quiz[f][i - d][j].setKey2(quizTempKey);
																	quiz[f][i - d][j].setValue(quizTempValue);
																	quiz[f][i - d][j].setCh(quizTempKey.charAt(s));
																	quiz[f][i - d][j].setNum(quizTempKeyNum);
																} else {
																	quiz[f][i - d][j].setKey(quizTempKey);
																	quiz[f][i - d][j].setValue(quizTempValue);
																	quiz[f][i - d][j].setCh(quizTempKey.charAt(s));
																	quiz[f][i - d][j].setNum(quizTempKeyNum);
																}
															} else {
																quiz[f][i - d][j].setKey(quizTempKey);
																quiz[f][i - d][j].setValue(quizTempValue);
																quiz[f][i - d][j].setCh(quizTempKey.charAt(s));
																quiz[f][i - d][j].setNum(quizTempKeyNum);
															}
															y1 = i - d;
															x1 = j;
														}
														keyList.remove(quizTempKeyNum);
														if (quizTempKeyNum != 0) {
															quizTempKeyNum--;
														}

														quizCtn++;
														ctn = 0;
														yUpCheck = false;
														break bkf1;
													}
												}
												ctn = 0;
											}
										}
									}
								}
							}
						}
						if (quizCtn == quizCtnCheck || (keyList.size() == 0)) {
							// break first;
							break finalLoop;
						}

						if (keyList.size() - 1 == quizTempKeyNum) {

							loopCtn++;

							if (loopCtn == 300) {
								loopCtn = 0;
								onOff = true;
								onOff1 = false;
								xLeftCheck = false;
								xRightCheck = false;
								yUpCheck = false;
								yDownCheck = false;
								quizCtn = 0;
								ctn = 0;
								num = 0;
								for (int i = 0; i < l.length; i++) {
									for (int j = 0; j < l[i].length; j++) {
										if (i == 0 || j == 0) {
											quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
										} else if (i == l.length - 1 || j == l.length - 1) {
											quiz[f][i][j] = new YH_Quiz("", "", "", '0', 1000);
										} else {
											quiz[f][i][j] = new YH_Quiz("", "", "", '1', 1000);
										}
									}
								}
								
								while (keyList.size() != 0) {
									keyList.remove(0);
								}
								
								
								break first;
							}

							Set tempSet = new LinkedHashSet();
							while (tempSet.size() < keyList.size()) {
								tempSet.add(new Random().nextInt(keyList.size()));
							}

							String[] tempArr = new String[keyList.size()];

							Object[] tempNum = tempSet.toArray();

							for (int i = 0; i < tempNum.length; i++) {
								tempArr[i] = keyList.get((int) tempNum[i]);
							}


							while (keyList.size() != 0) {
								keyList.remove(0);
							}


							for (int i = 0; i < tempArr.length; i++) {
								keyList.add(tempArr[i]);
							}
							onOff = true;
							break fi;
						}
					}
				}
			}

		System.out.println("이벤트 종료8");
		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {

		}

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				if (quiz[f][i][j].getCh() == '0' || quiz[f][i][j].getCh() == '1') {
					l[i][j].setIcon(new ImageIcon(empty));
				}
			}
		}

		for (i1 = 0; i1 < l.length; i1++) {
			for (j1 = 0; j1 < l[i1].length; j1++) {
				if (quiz[f][i1][j1].getCh() != '1' && quiz[f][i1][j1].getCh() != '0') {
					l[i1][j1].addMouseListener(new MyEvent(i1, j1, panel, qsp, qa, compareArr, l, igp, yh, f, quiz));
				}
			}
		}
		System.out.println("이벤트 종료9");
	}

	private class MyEvent implements ActionListener, MouseListener {

		private int i1;
		private int j1;
		private JPanel panel;
		private YH_QuizShowPanel qsp;
		private YH_QuizAnswer_ej1 qa;
		private String[] compareArr;
		private JLabel[][] l;
//		private InGamePage igp; //은진이꺼
		private InGamePage igp; //내꺼
		private YH_GameBoard_ej1[] gb;
		private int f;
		private YH_Quiz[][][] quiz;

		public MyEvent(int i1, int j1, JPanel panel, YH_QuizShowPanel qsp, YH_QuizAnswer_ej1 qa, String[] compareArr,
				JLabel[][] l, /*InGamePage igp,*/ InGamePage igp, YH_GameBoard_ej1[] gb, int f, YH_Quiz[][][] quiz) {
			this.i1 = i1;
			this.j1 = j1;
			this.panel = panel;
			this.qsp = qsp;
			this.qa = qa;
			this.compareArr = compareArr;
			this.l = l;
			this.igp = igp;
			this.gb = gb;
			this.f = f;
			this.quiz = quiz;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == l[i1][j1]) {
				
				System.out.println("f의 값!!!!!!!!!!!!!!!!!!!!!!!!! " + f);
				qa = new YH_QuizAnswer_ej1(panel, quiz, compareArr, l, i1, j1, igp, gb, f);
				qsp.setText("<html><p style=\"width:400px\">" + quiz[f][i1][j1].getValue() + "</p></html>");
				igp.setCom(quiz[f][i1][j1].getKey());
				igp.setX(j1);
				igp.setY(i1);
				System.out.println("igp.getCom()의 값 : " + igp.getCom());
				System.out.println("이벤트 종료10");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}