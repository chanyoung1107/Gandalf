package with_god.controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JFrame {

	boolean xLeftCheck = false;
	boolean xRightCheck = false;
	boolean yUpCheck = false;
	boolean yDownCheck = false;
	boolean xLeftCheck1 = false;
	boolean xRightCheck1 = false;
	boolean yUpCheck1 = false;
	boolean yDownCheck1 = false;
	boolean startOrStop = true;

	String str = null;
	String str3 = null;
	int str3Num;
	int x = new Random().nextInt(6) + 1;
	int y = new Random().nextInt(6) + 1;

	private JLabel[][] l = new JLabel[8][8];

	public GameBoard() {
		this.setBounds(200, 50, 1300, 800);
		this.setLayout(null);

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				if (i == 0 || j == 0) {
					l[i][j] = new JLabel("0");
				} else if (i == 7 || j == 7) {
					l[i][j] = new JLabel("0");
				} else {
					l[i][j] = new JLabel(i + " . " + j);
				}
			}
		}

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		panel.setBackground(Color.white);
		panel.setBounds(300, 25, 700, 700);
		panel.setVisible(true);
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				panel.add(l[i][j]);
			}
		}

		Properties prop = new Properties();
		ArrayList<String> alist = new ArrayList<String>();
		try {
			prop.load(new FileReader("quiz.txt"));

			// 파일의 키 값들 불러옴
			Set key = prop.keySet();

			Set set = new LinkedHashSet();

			// 불러온 키 값을 배열화
			Object[] keyArr = key.toArray();

			// 중복되지 않는 랜덤값 선정(현재 0~14)
			while (set.size() < key.size()) {
				set.add(new Random().nextInt(key.size()));
			}

			// 랜덤값 배열화
			Object[] rNum = set.toArray();

			for (int i = 0; i < key.size(); i++) {
				alist.add((String) keyArr[(int) rNum[i]]);
			}

			int random = new Random().nextInt(set.size());

			ArrayList keyFinal = new ArrayList();

			str3 = alist.get(random);
			str3Num = random;
			
			bk1: while (true) {

				if (startOrStop == true) {
					str = (String) prop.get(alist.get(random));
					keyFinal.add(alist.get(random));
					// l[x][y].setText(alist.get(num));
					startOrStop = false;
				}

				// 랜덤 위치에 생성 후 좌우위아래 답의 글자 수 만큼 비어있는지(들어갈 수 있는지) 검사
				for (int i = 1; i < str.length(); i++) {
					if ((l[y][x + i].getText().equals("1"))) {
						if (i == str.length() - 1) {
							xRightCheck = true;
						}
					}
					if ((l[y][x - i].getText().equals("1"))) {
						if (i == str.length() - 1) {
							xLeftCheck = true;
						}
					}
					if ((l[y + i][x].getText().equals("1"))) {
						if (i == str.length() - 1) {
							yDownCheck = true;
						}
					}
					if ((l[y - i][x].getText().equals("1"))) {
						if (i == str.length() - 1) {
							yUpCheck = true;
						}
					}
				}

				// 좌우위아래 검사 후 확인 된 곳에 문제 삽입.
				while (true) {
					// 오른쪽이 비어있는게 확인됐으면
					if (xRightCheck) {
						for (int i = 0; i < str.length(); i++) {
							l[y][x + i].setText(str3);
						}
						alist.remove(str3Num);
						break;
						// 오른쪽이 막혀있고 아래쪽이 비어있는게 확인됐을 경우
					} else if (yDownCheck) {
						for (int i = 0; i < str.length(); i++) {
							l[y + i][x].setText(str3);
						}
						alist.remove(str3Num);
						break;
						// 오른쪽, 아래쪽이 막혀있고 왼쪽이 비어있는게 확인됐을 경우
					} else if (xLeftCheck) {
						for (int i = str.length() - 1; i >= 0; i--) {
							l[y][x - i].setText(str3);
						}
						alist.remove(str3Num);
						break;
						// 모두 막혀있고 위로 비어있는게 확인됐을 경우
					} else if (yUpCheck) {
						for (int i = str.length() - 1; i >= 0; i--) {
							l[y - i][x].setText(str3);
						}
						alist.remove(str3Num);
						break;
						// 모두 막혀있을 경우
					} else {
						x = new Random().nextInt(6) + 1;
						y = new Random().nextInt(6) + 1;
					}
				}

				System.out.println();
				System.out.println("--------------------------");
				System.out.println("str의 값 : " + str);
				System.out.println("--------------------------");

				// bk: for (int i = 0; i < alist.size(); i++) {
				// for (int j = 0; j < str.length(); j++) {
				// String str1 = (String) prop.get(alist.get(i));
				// System.out.println("str1의 값 : " + str1);
				// for (int k = 0; k < str1.length(); k++) {
				// if (xRightCheck) {
				// if (str.charAt(j) == str1.charAt(0)) {
				//
				// str = str1;
				// break bk;
				// } else if (str.charAt(j) == str1.charAt(str1.length() - 1)) {
				// str = str1;
				// break bk;
				// }
				// }
				// }
				// }
				// }
				bk: for (int i = 0; i < alist.size(); i++) {
					for (int j = 0; j < str.length(); j++) {
						String str1 = (String) prop.get(alist.get(i));
						System.out.println("str1의 값 : " + str1);
						for (int k = 0; k < str1.length(); k++) {
							// x축으로 썼을 때
							if (xRightCheck) {
								//str1의 0번째 인덱스가 str글자 하나와 일치할 경우
								//str1의 답이 들어갈 길이가 되는지 검사
								if (str.charAt(j) == str1.charAt(0)) {
									for (int a = 1; a < str1.length(); a++) {
										if ((l[y + a][x].getText().equals("1"))) {
											if (a == str1.length() - 1) {
												for (int b = 1; b < str1.length(); b++) {
													l[y + b][x].setText(str3);
												}
												alist.remove(random);
//												yDownCheck1 = true;
											}
										}else {
											break;
										}
									}
									str = str1;
									break bk;
									//str1의 마지막 인덱스가 str글자 하나와 일치할 경우
									//str1의 답이 들어갈 길이가 되는지 검사
								} else if (str.charAt(j) == str1.charAt(str1.length() - 1)) {
									for (int a = 1; a < str.length(); a++) {
										if ((l[y - a][x].getText().equals("1"))) {
											if (a == str.length() - 1) {
//												yUpCheck1 = true;
											}
										}
									}
									str = str1;
									break bk;
								}
							}
						}
					}
				}

				System.out.println("==================");
				if (keyFinal.size() == 5) {
					break bk1;
				}

			}

			for (int i = 0; i < keyFinal.size(); i++) {
				System.out.println("최종문제 : " + keyFinal.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new GameBoard();
	}

}
