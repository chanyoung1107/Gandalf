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

//��й�ȣ Ȯ�� â�����
public class CY_AskPassword {
	
	
	public CY_AskPassword (JFrame mf, User tp) {

	Dialog dg = new Dialog(mf, true);
	dg.setUndecorated(true);
	dg.setSize(550, 250);
	dg.setLayout(null);
	dg.setLocationRelativeTo(mf);
	
	JLabel groundL = new JLabel(new ImageIcon(new ImageIcon("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(550, 250, 0)));
	JLabel askL = new JLabel(" ��й�ȣ�� �Է����ּ���");
	JLabel password = new JLabel("��й�ȣ");
	//��й�ȣ �񱳿� �ؽ�Ʈâ ����
	JPasswordField passwordT = new JPasswordField();
	
	JLabel orangeF = new JLabel(new ImageIcon(new ImageIcon("images/��������ư.png").getImage().getScaledInstance(50, 30, 0)));
	JLabel orangeE = new JLabel(new ImageIcon(new ImageIcon("images/��������ư.png").getImage().getScaledInstance(50, 30, 0)));
	JLabel yesL = new JLabel("Ȯ��");
	JLabel noL = new JLabel("���");
	
	groundL.setSize(550, 250);
	askL.setBounds(100, 60, 500, 50);
	password.setBounds(60, 140, 100, 30);
	passwordT.setBounds(250, 140, 230, 30);
	yesL.setBounds(400, 210, 50, 30);
	noL.setBounds(470, 210, 50, 30);
	orangeF.setBounds(393, 210, 50, 30);
	orangeE.setBounds(462, 210, 50, 30);
	
	askL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
	password.setFont(new Font("�޸�����ü", Font.BOLD, 20));
	yesL.setFont(new Font("�޸�����ü", Font.BOLD, 20));
	noL.setFont(new Font("�޸�����ü", Font.BOLD, 20));
	
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
			//��й�ȣâ�� ���ϰ��� ������ �� && ȸ�� ��ü�� ��й�ȣ�� ������ ��
			//������.getPassword�� ĳ���� �迭 �����̹Ƿ� ���ڿ��� �� �Ұ�
			//ĳ���� �迭�� ���ڿ��� �ٲ��ִ� �޼���
			String pw1 = "";
			for(char ch1 : passwordT.getPassword()) {
				Character.toString(ch1);
				pw1 += ch1;
			}
			
			if(pw1.equals(tp.getPw())) {
				//������ �������� â���� �Ѿ
				dg.dispose();
				new CY_FixPage(mf, tp);
				
			}else {
				//������ â���� ��ġ���� ����â ���
				JOptionPane.showMessageDialog(mf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "x", JOptionPane.ERROR_MESSAGE);
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
















