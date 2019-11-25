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

		//ȸ������ ������
public class YJ_SignupPage {
	
	YJ_Email email = new YJ_Email();

	// Dao ���� �ҷ�����
	UserDao ud = new UserDao();
	//���Ͽ� �ִ� ��� ��ü �ҷ��ͼ� list�� ���
	ArrayList<User> list = ud.readUserList();
	//ȸ����ü ����
	User user = new User();
	//���̵��ߺ�Ȯ���� ���� boolean��
	boolean b = false;
	//�г����ߺ�Ȯ���� ���� boolean��
	boolean c = false;
	//�̸��� ����Ȯ���� ���� boolean��
	boolean d = false;

	public YJ_SignupPage(JFrame mf) {
		JDialog dg = new JDialog(mf, true);
		JLabel backImage = new JLabel(new ImageIcon(new ImageIcon ("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(500, 500, 0)));
		YJ_Email mail = new YJ_Email();
		backImage.setSize(500, 500);
		
		dg.setLayout(null);
		dg.setSize(500, 500);
		dg.setLocationRelativeTo(mf);
		dg.setBackground(Color.LIGHT_GRAY);

		// ȸ������ ���� label
		JLabel headlabel = new JLabel();
		headlabel.setBounds(180, -50, 150, 150);
		headlabel.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		headlabel.setForeground(Color.white);
		headlabel.setText("ȸ������");
		dg.add(headlabel);
		//���̵� ��
		JLabel Idlabel = new JLabel();
		Idlabel.setBounds(100, 50, 50, 50);
		Idlabel.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		Idlabel.setForeground(Color.white);
		Idlabel.setText("���̵�");
		dg.add(Idlabel);
		//���̵� �ߺ� Ȯ�� ��
		JLabel idC = new JLabel("Ȯ  ��");
		idC.setFont(new Font("�޸�����ü", Font.BOLD, 15));
	    idC.setForeground(Color.black);
	    idC.setBounds(385, 63, 80, 25);
	    dg.add(idC);
	    //���̵� �ؽ�Ʈ �ʵ�
		JTextField idT = new JTextField();
		idT.setBounds(160, 65, 200, 20);
		idT.getText();
		//���̵� �ߺ� üũ ��
		JLabel checkId = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(90, 20, 0)));
		checkId.setBounds(365, 65, 90, 20);
		dg.add(idT);
		dg.add(checkId);
		//��й�ȣ ��
		JLabel pwlabel = new JLabel("��й�ȣ");
		pwlabel.setBounds(85, 100, 100, 30);
		pwlabel.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		pwlabel.setForeground(Color.white);
		//��й�ȣ �ʵ� 
		JPasswordField pwT1 = new JPasswordField();
		pwT1.setBounds(160, 105, 200, 20);
		dg.add(pwlabel);
		dg.add(pwT1);
		//��й�ȣȮ�� ��
		JLabel pwlabel2 = new JLabel("��й�ȣȮ��");
		pwlabel2.setBounds(55, 140, 100, 30);
		pwlabel2.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		pwlabel2.setForeground(Color.white);
		//��й�ȣȮ���ʵ�
		JPasswordField pwT2 = new JPasswordField();
		pwT2.setBounds(160, 145, 200, 20);
		//��й�ȣȮ�� ��ư ��
		JLabel pwC = new JLabel("Ȯ  ��");
		pwC.setFont(new Font("�޸�����ü", Font.BOLD, 15));
	    pwC.setForeground(Color.black);
	    pwC.setBounds(385, 145, 80, 25);
	    dg.add(pwC);
	    //��й�ȣȮ�� �̹��� ��
		JLabel checkPw = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(90, 20, 0)));
		checkPw.setBounds(365, 145, 90, 20);
		dg.add(pwlabel2);
		dg.add(pwT2);
		dg.add(checkPw);
		//�̸� ��
		JLabel namelabel = new JLabel("�� ��");
		namelabel.setBounds(110, 180, 100, 30);
		namelabel.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		namelabel.setForeground(Color.white);
		//�̸� �Է� �ʵ�
		JTextField nameT = new JTextField();
		nameT.setBounds(160, 185, 200, 20);
		dg.add(nameT);
		dg.add(namelabel);
		//�г��� ��
		JLabel nicklabel = new JLabel("�г���");
		nicklabel.setBounds(100, 220, 100, 30);
		nicklabel.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		nicklabel.setForeground(Color.white);
		//�г��� �Է� �ʵ�
		JTextField nickT = new JTextField();
		nickT.setBounds(160, 225, 200, 20);
		//�г��� �ߺ�Ȯ�� ��
		JLabel nickC = new JLabel("Ȯ  ��");
		nickC.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		nickC.setForeground(Color.black);
		nickC.setBounds(385, 225, 80, 25);
	    dg.add(nickC);
	    //�г��� �ߺ�Ȯ�� �̹��� ��
		JLabel checkNick = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(90, 20, 0)));
		checkNick.setBounds(365, 225, 90, 20);
		dg.add(checkNick);
		dg.add(nickT);
		dg.add(nicklabel);
		//�̸��� ��
		JLabel emaillabel = new JLabel("�̸���");
		emaillabel.setBounds(100, 260, 100, 30);
		emaillabel.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		emaillabel.setForeground(Color.white);
		//�̸��� �Է��ʵ�
		JTextField emailT = new JTextField();
		emailT.setBounds(160, 265, 200, 20);
		//�̸��� ����Ȯ�ζ�
		JLabel emailC = new JLabel("Ȯ  ��");
		emailC.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		emailC.setForeground(Color.black);
		emailC.setBounds(385, 265, 80, 25);
	    dg.add(emailC);
	    //�̸��� ���� �̹��� ��
		JLabel checkEmail = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(90, 20, 0)));
		checkEmail.setBounds(365, 265, 90, 20);
		dg.add(checkEmail);
		dg.add(emailT);
		dg.add(emaillabel);
		// �̸��� �����Է� �ʵ�
		JTextField emailPW = new JTextField();
		emailPW.setBounds(160, 305, 100, 20);
		// �̸��� �����Է� Ȯ�� ��
		JLabel emailpwC = new JLabel("Ȯ  ��");
		emailpwC.setFont(new Font("�޸�����ü", Font.BOLD, 15));
		emailpwC.setForeground(Color.black);
		emailpwC.setBounds(285, 305, 80, 25);
	    dg.add(emailpwC);
	    //�̸��������Է� �̹��� ��
		JLabel checkEmailPw = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(90, 20, 0)));
		checkEmailPw.setBounds(265, 305, 90, 20);
		dg.add(checkEmailPw);
		dg.add(emailPW);
		// ������ư ����
		JLabel backC = new JLabel("��  ��");
		backC.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		backC.setForeground(Color.black);
		backC.setBounds(57, 411, 100, 35);
	    dg.add(backC);
	    //�̹���ư �̹��� ��
		JLabel backL = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(110, 50, 0)));
		backL.setBounds(50, 400, 110, 50);
		dg.add(backL);
		//���ԿϷ�
		JLabel SingupC = new JLabel("���ԿϷ�");
		SingupC.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		SingupC.setForeground(Color.black);
		SingupC.setBounds(365, 400, 120, 50);
		dg.add(SingupC);
		//���ԿϷ� �̹��� ��
		JLabel Ok = new JLabel(new ImageIcon(new ImageIcon ("images/��������ư.png").getImage().getScaledInstance(110, 50, 0)));
		Ok.setBounds(365, 400, 110, 50);
		dg.add(Ok);
		dg.add(backImage);
		
		//���̵� ��밡�� Ȯ�� �� �ٽ� ���̵� �ٲ� ��
		//keyBoard �̺�Ʈ�� ����Ͽ� �Է½� �ٷ� boolean ���� false�� �ٲپ��ش�
		idT.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				b = false;
			}
		});

		//�̸��� ���۹�ư Ŭ�� �̺�Ʈ
		
		emailPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();}});
		
		// ���� ��ư ������
		
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

		// ���̵� �ߺ� ��ư ������
		
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
					//��밡���� ���̵��Դϴ� ���̾�α�
					JOptionPane.showMessageDialog(null, "��� ������ ���̵� �Դϴ�");
				}else {
					//�ߺ��� ���̵� �Դϴ� ���̾�α� �ؽ�Ʈ ����� ������
					JOptionPane.showMessageDialog(null, "��� �Ұ����� ���̵��Դϴ�");}}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}});

		// ��й�ȣ �ߺ� ��ư ������
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
//						JOptionPane.showMessageDialog(mf, "��й�ȣ �����ԷµǾ����ϴ�", "Ȯ��", JOptionPane.INFORMATION_MESSAGE);
//					} else {
//						JOptionPane.showMessageDialog(mf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�", "�ٽ��ѹ� Ȯ�����ּ���", JOptionPane.ERROR_MESSAGE);
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
		
		//�г��� �ߺ�Ȯ��
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
//					��밡���� �г����Դϴ� ���̾�α�
					JOptionPane.showMessageDialog(null, "��� �Ұ����� �г��� �Դϴ�");
				}else {
//					�ߺ��� �г��� �Դϴ� ���̾�α� �ؽ�Ʈ ����� ������
					JOptionPane.showMessageDialog(null, "��� ������ �س����Դϴ�");}}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		//�̸��� ���۹�ư Ŭ�� �̺�Ʈ
		checkEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mail.getEmailAddress(emailT.getText());
	    		  String[] args1 = {""};
	    		  mail.main(args1);
	    		  JOptionPane.showMessageDialog(null, "���� ������ �Ϸ�Ǿ����ϴ�");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		//�̸���������ȣ Ȯ��
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
//					������ȣ���Ͻ� ����Ǵ� ���̾�α�
					JOptionPane.showMessageDialog(null, "������ȣ Ȯ�οϷ�");
				}else {
//					�ߺ��� �г��� �Դϴ� ���̾�α� �ؽ�Ʈ ����� ������
					JOptionPane.showMessageDialog(null, "��� ������ �г����Դϴ�");
					}
				}
			});
		
		
		// ȸ������ �Ϸ� ��ư�� ��������
		Ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			            if (idT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���", "���̵��Է�", JOptionPane.WARNING_MESSAGE);
			               idT.grabFocus();
			               return;
			            }
			            if (pwT1.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���", "��й�ȣ�Է�", JOptionPane.WARNING_MESSAGE);
			               pwT1.grabFocus();
			               return;
			            }
			            
			            if (pwT2.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "��й�ȣȮ�θ� �Է����ּ���", "��й�ȣȮ���Է�", JOptionPane.WARNING_MESSAGE);
			               pwT2.grabFocus();
			               return;
			            }
			            if (nameT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���", "�̸��Է�", JOptionPane.WARNING_MESSAGE);
			               nameT.grabFocus();
			               return;
			            }
			            if (nickT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "�г��Ӹ� �Է����ּ���", "�г����Է�", JOptionPane.WARNING_MESSAGE);
			               nickT.grabFocus();
			               return;
			            }
			            if (emailT.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "�̸��ϸ� �Է����ּ���", "�̸����Է�", JOptionPane.WARNING_MESSAGE);
			               emailT.grabFocus();
			               return;
			            }
			            if (emailPW.getText().trim().length() == 0) {
			               JOptionPane.showMessageDialog(null, "�̸��� ������ �Է����ּ���", "�̸��� �����Է�", JOptionPane.WARNING_MESSAGE);
			               emailPW.grabFocus();
			               return;}
	
				//vo�� ���� ��ü�� ���� ����־��ش�.
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
				
				JOptionPane.showMessageDialog(null, "���ԿϷ� �Ǿ����ϴ� �����մϴ�");
				
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

/* �ؽ�Ʈ ������ ���� �Է¼��� �޼��� ���� �޼ҵ� ���� ���� */

// pwT1.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (pwT1.getText().trim().length() == 0) {
// pwT1.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (pwT1.getText().trim().equals("��й�ȣ")) {
// pwT1.setText("");}}});
// pwT2.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (pwT2.getText().trim().length() == 0) {
// pwT2.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (pwT2.getText().trim().equals("��й�ȣȮ��")) {
// pwT2.setText("");}}});
// nameT.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (nameT.getText().trim().length() == 0) {
// nameT.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (nameT.getText().trim().equals("�̸�")) {
// nameT.setText("");}}});
// emailT.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (emailT.getText().trim().length() == 0) {
// emailT.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (emailT.getText().trim().equals("�г���")) {
// emailT.setText("");}}
// });
// emailPW.addFocusListener(new FocusListener() {
// @Override
// public void focusLost(FocusEvent e) {
// if (emailPW.getText().trim().length() == 0) {
// emailPW.setText("");}}
// @Override
// public void focusGained(FocusEvent e) {
// if (emailPW.getText().trim().equals("�̸���")) {
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
// if (idT.getText().equals("���̵�")) {
// idT.setText("");
// }
// }
// });
//
//