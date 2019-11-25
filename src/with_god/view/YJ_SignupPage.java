package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import with_god.controller.YJ_Email;
import with_god.controller.YJ_UserManager;
import with_god.model.dao.UserDao;
import with_god.model.vo.User;

		//회원가입 페이지
public class YJ_SignupPage {
	
	YJ_Email email = new YJ_Email();

	// Dao 파일 불러오기
	UserDao ud = new UserDao();
	//파일에 있는 모든 객체 불러와서 list에 담기
	ArrayList<User> list = ud.readUserList();
	//회원객체 생성
	User user = new User();
	//아이디중복확인을 위한 boolean값
	boolean b = false;
	//닉네임중복확인을 위한 boolean값
	boolean c = false;
	//이메일 인증확인을 위한 boolean값
	boolean d = false;

	public YJ_SignupPage(JFrame mf) {
		JDialog dg = new JDialog(mf, true);
		JLabel backImage = new JLabel(new ImageIcon(new ImageIcon ("images/그라데이션그레이.jpg").getImage().getScaledInstance(500, 500, 0)));
		YJ_Email mail = new YJ_Email();
		backImage.setSize(500, 500);
		
		dg.setLayout(null);
		dg.setSize(500, 500);
		dg.setLocationRelativeTo(mf);
		dg.setBackground(Color.LIGHT_GRAY);

		// 회원가입 글자 label
		JLabel headlabel = new JLabel();
		headlabel.setBounds(180, -50, 150, 150);
		headlabel.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		headlabel.setForeground(Color.white);
		headlabel.setText("회원가입");
		dg.add(headlabel);
		//아이디 라벨
		JLabel Idlabel = new JLabel();
		Idlabel.setBounds(100, 50, 50, 50);
		Idlabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		Idlabel.setForeground(Color.white);
		Idlabel.setText("아이디");
		dg.add(Idlabel);
		//아이디 중복 확인 라벨
		JLabel idC = new JLabel("확  인");
		idC.setFont(new Font("휴먼편지체", Font.BOLD, 15));
	    idC.setForeground(Color.black);
	    idC.setBounds(385, 63, 80, 25);
	    dg.add(idC);
	    //아이디 텍스트 필드
		JTextField idT = new JTextField();
		idT.setBounds(160, 65, 200, 20);
		idT.getText();
		//아이디 중복 체크 라벨
		JLabel checkId = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(90, 20, 0)));
		checkId.setBounds(365, 65, 90, 20);
		dg.add(idT);
		dg.add(checkId);
		//비밀번호 라벨
		JLabel pwlabel = new JLabel("비밀번호");
		pwlabel.setBounds(85, 100, 100, 30);
		pwlabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		pwlabel.setForeground(Color.white);
		//비밀번호 필드 
		JPasswordField pwT1 = new JPasswordField();
		pwT1.setBounds(160, 105, 200, 20);
		dg.add(pwlabel);
		dg.add(pwT1);
		//비밀번호확인 라벨
		JLabel pwlabel2 = new JLabel("비밀번호확인");
		pwlabel2.setBounds(55, 140, 100, 30);
		pwlabel2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		pwlabel2.setForeground(Color.white);
		//비밀번호확인필드
		JPasswordField pwT2 = new JPasswordField();
		pwT2.setBounds(160, 145, 200, 20);
		//비밀번호확인 버튼 라벨
		JLabel pwC = new JLabel("확  인");
		pwC.setFont(new Font("휴먼편지체", Font.BOLD, 15));
	    pwC.setForeground(Color.black);
	    pwC.setBounds(385, 145, 80, 25);
	    dg.add(pwC);
	    //비밀번호확인 이미지 라벨
		JLabel checkPw = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(90, 20, 0)));
		checkPw.setBounds(365, 145, 90, 20);
		dg.add(pwlabel2);
		dg.add(pwT2);
		dg.add(checkPw);
		//이름 라벨
		JLabel namelabel = new JLabel("이 름");
		namelabel.setBounds(110, 180, 100, 30);
		namelabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		namelabel.setForeground(Color.white);
		//이름 입력 필드
		JTextField nameT = new JTextField();
		nameT.setBounds(160, 185, 200, 20);
		dg.add(nameT);
		dg.add(namelabel);
		//닉네임 라벨
		JLabel nicklabel = new JLabel("닉네임");
		nicklabel.setBounds(100, 220, 100, 30);
		nicklabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		nicklabel.setForeground(Color.white);
		//닉네임 입력 필드
		JTextField nickT = new JTextField();
		nickT.setBounds(160, 225, 200, 20);
		//닉네임 중복확인 라벨
		JLabel nickC = new JLabel("확  인");
		nickC.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		nickC.setForeground(Color.black);
		nickC.setBounds(385, 225, 80, 25);
	    dg.add(nickC);
	    //닉네임 중복확인 이미지 라벨
		JLabel checkNick = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(90, 20, 0)));
		checkNick.setBounds(365, 225, 90, 20);
		dg.add(checkNick);
		dg.add(nickT);
		dg.add(nicklabel);
		//이메일 라벨
		JLabel emaillabel = new JLabel("이메일");
		emaillabel.setBounds(100, 260, 100, 30);
		emaillabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		emaillabel.setForeground(Color.white);
		//이메일 입력필드
		JTextField emailT = new JTextField();
		emailT.setBounds(160, 265, 200, 20);
		//이메일 전송확인라벨
		JLabel emailC = new JLabel("확  인");
		emailC.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		emailC.setForeground(Color.black);
		emailC.setBounds(385, 265, 80, 25);
	    dg.add(emailC);
	    //이메일 전송 이미지 라벨
		JLabel checkEmail = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(90, 20, 0)));
		checkEmail.setBounds(365, 265, 90, 20);
		dg.add(checkEmail);
		dg.add(emailT);
		dg.add(emaillabel);
		// 이메일 인증입력 필드
		JTextField emailPW = new JTextField();
		emailPW.setBounds(160, 305, 100, 20);
		// 이메일 인증입력 확인 라벨
		JLabel emailpwC = new JLabel("확  인");
		emailpwC.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		emailpwC.setForeground(Color.black);
		emailpwC.setBounds(285, 305, 80, 25);
	    dg.add(emailpwC);
	    //이메일인증입력 이미지 라벨
		JLabel checkEmailPw = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(90, 20, 0)));
		checkEmailPw.setBounds(265, 305, 90, 20);
		dg.add(checkEmailPw);
		dg.add(emailPW);
		// 이전버튼 구현
		JLabel backC = new JLabel("이  전");
		backC.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		backC.setForeground(Color.black);
		backC.setBounds(57, 411, 100, 35);
	    dg.add(backC);
	    //이번버튼 이미지 라벨
		JLabel backL = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(110, 50, 0)));
		backL.setBounds(50, 400, 110, 50);
		dg.add(backL);
		//가입완료
		JLabel SingupC = new JLabel("가입완료");
		SingupC.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		SingupC.setForeground(Color.black);
		SingupC.setBounds(365, 400, 120, 50);
		dg.add(SingupC);
		//가입완료 이미지 라벨
		JLabel Ok = new JLabel(new ImageIcon(new ImageIcon ("images/오렌지버튼.png").getImage().getScaledInstance(110, 50, 0)));
		Ok.setBounds(365, 400, 110, 50);
		dg.add(Ok);
		dg.add(backImage);
		
		//아이디 사용가능 확인 후 다시 아이디를 바꿀 시
		//keyBoard 이벤트를 사용하여 입력시 바로 boolean 값을 false로 바꾸어준다
		idT.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				b = false;
			}
		});

		//이메일 전송버튼 클릭 이벤트
		
		emailPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();}});
		
		// 이전 버튼 누를시
		
		backL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dg.dispose();}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}});

		// 아이디 중복 버튼 누를시
		
		checkId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list == null) {
					b = true;
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (!idT.getText().equals(list.get(i).getId())) {
							b = true;
						}else {
							b = false;}}}
				if(b) {
					//사용가능한 아이디입니다 다이얼로그
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다");
				}else {
					//중복된 아이디 입니다 다이얼로그 텍스트 지우고 슬래쉬
					JOptionPane.showMessageDialog(null, "사용 불가능한 아이디입니다");}}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}});

		// 비밀번호 중복 버튼 누를시
//		checkPw.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String pw1 = "";
//				for (char ch1 : pw1()) {
//					Character.toString(ch1);
//					pw1 += ch1;
//				}
//				String pw2 = "";
//				for (char ch2 : pw2.getText()) {
//					Character.toString(ch2);
//					pw2 += ch2;
//				}
//
//				if (pw1 != "" && pw2 != "") {
//
//					if (pw1.equals(pw2)) {
//						JOptionPane.showMessageDialog(mf, "비밀번호 정상입력되었습니다", "확인", JOptionPane.INFORMATION_MESSAGE);
//					} else {
//						JOptionPane.showMessageDialog(mf, "비밀번호가 일치하지 않습니다", "다시한번 확인해주세요", JOptionPane.ERROR_MESSAGE);
//						pwT1.setText("");
//						pwT2.setText("");
//						pwT1.requestFocus();
//					}
//				}
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
//				buttonEnteredMusic.start();
//			}
//		});
		
		//닉네임 중복확인
		checkNick.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if (list == null) {
					c = true;
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (!nicklabel.getText().equals(list.get(i).getNickName())) {
							c = true;
						}else {
							c = false;}}}
				if(c) {
//					사용가능한 닉네임입니다 다이얼로그
					JOptionPane.showMessageDialog(null, "사용 불가능한 닉네임 입니다");
				}else {
//					중복된 닉네임 입니다 다이얼로그 텍스트 지우고 슬래쉬
					JOptionPane.showMessageDialog(null, "사용 가능한 넥네임입니다");}}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		//이메일 전송버튼 클릭 이벤트
		checkEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mail.getEmailAddress(emailT.getText());
	    		  String[] args1 = {""};
	    		  mail.main(args1);
	    		  JOptionPane.showMessageDialog(null, "메일 전송이 완료되었습니다");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		//이메일인증번호 확인
		emailpwC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list == null) {
					d = true;
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (!emailPW.getText().equals(list.get(i).getReturnNum())) {
							d = true;
						}else {
							d = false;}}}
				if(d) {
//					인증번호동일시 노출되는 다이얼로그
					JOptionPane.showMessageDialog(null, "인증번호 확인완료");
				}else {
//					중복된 닉네임 입니다 다이얼로그 텍스트 지우고 슬래쉬
					JOptionPane.showMessageDialog(null, "사용 가능한 닉네임입니다");
					}
				}
			});
		
		
		// 회원가입 완료 버튼을 눌렀을때
		Ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			            if (idT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "아이디입력", JOptionPane.WARNING_MESSAGE);
			               idT.grabFocus();
			               return;
			            }
			            if (pwT1.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "비밀번호입력", JOptionPane.WARNING_MESSAGE);
			               pwT1.grabFocus();
			               return;
			            }
			            
			            if (pwT2.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "비밀번호확인를 입력해주세요", "비밀번호확인입력", JOptionPane.WARNING_MESSAGE);
			               pwT2.grabFocus();
			               return;
			            }
			            if (nameT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "이름를 입력해주세요", "이름입력", JOptionPane.WARNING_MESSAGE);
			               nameT.grabFocus();
			               return;
			            }
			            if (nickT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "닉네임를 입력해주세요", "닉네임입력", JOptionPane.WARNING_MESSAGE);
			               nickT.grabFocus();
			               return;
			            }
			            if (emailT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "이메일를 입력해주세요", "이메일입력", JOptionPane.WARNING_MESSAGE);
			               emailT.grabFocus();
			               return;
			            }
			            if (emailPW.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "이메일 인증을 입력해주세요", "이메일 인증입력", JOptionPane.WARNING_MESSAGE);
			               emailPW.grabFocus();
			               return;}
	
				//vo의 유저 객체에 전부 집어넣어준다.
				user.setId(idT.getText());
				user.setPw(pwT2.getText());
				user.setName(nameT.getText());
				user.setNickName(nickT.getText());
				user.setEmail(emailT.getText());
				YJ_UserManager um = new YJ_UserManager();
				um.insertUser(user);
				
				System.out.println(um);
				
				UserDao ud = new UserDao();
				
				ArrayList<User> list = ud.readUserList();
				
				JOptionPane.showMessageDialog(null, "가입완료 되었습니다 감사합니다");
				
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getId());
				System.out.println(list.get(i).getPw());
				System.out.println(list.get(i).getNickName());
				System.out.println(list.get(i).getEmail());
			}
				
			dg.dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
		});

		dg.setResizable(false);
		dg.setVisible(true);
		
	}

	public YJ_SignupPage() {
		
	}
}

/* 텍스트 누르기 전에 입력설명 메세지 띄우는 메소드 구현 예정 */

// pwT1.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (pwT1.getText().trim().length() == 0) {
// pwT1.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (pwT1.getText().trim().equals("비밀번호")) {
// pwT1.setText("");}}});
// pwT2.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (pwT2.getText().trim().length() == 0) {
// pwT2.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (pwT2.getText().trim().equals("비밀번호확인")) {
// pwT2.setText("");}}});
// nameT.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (nameT.getText().trim().length() == 0) {
// nameT.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (nameT.getText().trim().equals("이름")) {
// nameT.setText("");}}});
// emailT.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (emailT.getText().trim().length() == 0) {
// emailT.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (emailT.getText().trim().equals("닉네임")) {
// emailT.setText("");}}
// });
// emailPW.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (emailPW.getText().trim().length() == 0) {
// emailPW.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (emailPW.getText().trim().equals("이메일")) {
// emailPW.setText("");}}});
// emailPW.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (emailPW.getText().trim().length() == 0) {
// emailPW.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (emailPW.getText().trim().equals("")) {
// emailPW.setText("");}}});
// idT.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (idT.getText().length() == 0) {
// idT.setText("");
// }
// }
// @Override
// public void focusGained(FocusEvent e) {
// if (idT.getText().equals("아이디")) {
// idT.setText("");
// }
// }
// });
//
//