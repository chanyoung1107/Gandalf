package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import with_god.model.vo.User;

//비밀번호 확인 창만들기
public class CY_AskPassword {
	
	
	public CY_AskPassword (JFrame mf, User tp) {

	Dialog dg = new Dialog(mf, true);
	dg.setUndecorated(true);
	dg.setSize(550, 250);
	dg.setLayout(null);
	dg.setLocationRelativeTo(mf);
	
	JLabel groundL = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(550, 250, 0)));
	JLabel askL = new JLabel(" 비밀번호를 입력해주세요");
	JLabel password = new JLabel("비밀번호");
	//비밀번호 비교용 텍스트창 생성
	JPasswordField passwordT = new JPasswordField();
	
	JLabel orangeF = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(50, 30, 0)));
	JLabel orangeE = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(50, 30, 0)));
	JLabel yesL = new JLabel("확인");
	JLabel noL = new JLabel("취소");
	
	groundL.setSize(550, 250);
	askL.setBounds(100, 60, 500, 50);
	password.setBounds(60, 140, 100, 30);
	passwordT.setBounds(250, 140, 230, 30);
	yesL.setBounds(400, 210, 50, 30);
	noL.setBounds(470, 210, 50, 30);
	orangeF.setBounds(393, 210, 50, 30);
	orangeE.setBounds(462, 210, 50, 30);
	
	askL.setFont(new Font("휴먼편지체", Font.BOLD, 30));
	password.setFont(new Font("휴먼편지체", Font.BOLD, 20));
	yesL.setFont(new Font("휴먼편지체", Font.BOLD, 20));
	noL.setFont(new Font("휴먼편지체", Font.BOLD, 20));
	
	askL.setForeground(Color.WHITE);
	password.setForeground(Color.WHITE);
	
	dg.add(groundL);
	dg.add(askL);
	dg.add(password);
	dg.add(passwordT);
	dg.add(yesL);
	dg.add(noL);
	dg.add(orangeF);
	dg.add(orangeE);
	
	dg.setComponentZOrder(groundL, 7);
	
	yesL.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//비밀번호창의 리턴값이 같은지 비교 && 회원 객체의 비밀번호가 같은지 비교
			//변수명.getPassword는 캐릭터 배열 형태이므로 문자열과 비교 불가
			//캐릭터 배열을 문자열로 바꿔주는 메서드
			String pw1 = "";
			for(char ch1 : passwordT.getPassword()) {
				Character.toString(ch1);
				pw1 += ch1;
			}
			
			if(pw1.equals(tp.getPw())) {
				//같으면 정보수정 창으로 넘어감
				dg.dispose();
				new CY_FixPage(mf, tp);
				
			}else {
				//간단한 창으로 일치오류 정보창 띄움
				JOptionPane.showMessageDialog(mf, "비밀번호가 일치하지 않습니다.", "x", JOptionPane.ERROR_MESSAGE);
			passwordT.setText("");
			passwordT.requestFocus();
			
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			yesL.setCursor(new Cursor(Cursor.HAND_CURSOR));
			SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
			buttonEnteredMusic.start();
		}

	});
	noL.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			dg.dispose();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			noL.setCursor(new Cursor(Cursor.HAND_CURSOR));
			SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
			buttonEnteredMusic.start();
		}

	}); 
	
	
	dg.setVisible(true);
	}
}
















