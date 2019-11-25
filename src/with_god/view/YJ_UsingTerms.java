package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class YJ_UsingTerms {
	/////////////////////////////// 이용약관////////////////////////////////////
	public YJ_UsingTerms(JFrame mf) {

		JDialog di = new JDialog(mf, true);
		JLabel headlabel = new JLabel("이용약관");
		JLabel backImage = new JLabel(
				new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(500, 500, 0)));
		backImage.setSize(500, 500);
		di.setLayout(null);
		di.setSize(500, 500);
		di.setLocationRelativeTo(mf);
		di.setTitle("이용약관");
		
		
		
		headlabel.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		headlabel.setForeground(Color.white);
		headlabel.setBounds(185, 10, 150, 50);

		TextArea textarea1 = new TextArea("제1조(목적)\r\n" + "\r\n"
				+ "이 약관은 ㈜선데이토즈(이하 “회사”라 합니다)가 제공하는 게임 서비스(이하 “서비스”라 합니다) 이용과 관련하여 회사와 이용자간의 권리∙의무 및 기타 필요한 제반사항을 정함을 목적으로 합니다.\r\n"
				+ "\r\n" + "\r\n" + "\r\n" + "제2조(용어의 정의)\r\n" + "\r\n"
				+ "이 약관에서 사용하는 용어의 정의는 다음 각호와 같으며, 정의하지 않은 용어의 해석은 관련 법령 및 상관례에 따릅니다.\r\n" + "\r\n"
				+ "“이용고객”이란 회사가 제공하는 서비스를 이용하기 위해 앱스토어사업자 또는 플랫폼사업자가 운영하는 앱스토어마켓에서 애플리케이션을 다운로드 받은 자를 말합니다.\r\n"
				+ "“이용자”란 이 약관 및 개인정보처리방침에 동의하고, 회사가 제공하는 서비스 이용자격을 부여 받은 이용고객을 말합니다.\r\n"
				+ "“서비스”란 회사가 제공하는 게임 서비스 일체를 의미합니다.\r\n"
				+ "“단말기”란 서비스를 이용할 수 있는 휴대폰, 스마트폰, PDA, 태블릿, 휴대용 게임기 등 유∙무선 기기를 말합니다.\r\n"
				+ "“애플리케이션”이란 회사가 제공하는 서비스를 이용할 수 있는 프로그램 일체를 의미합니다.\r\n"
				+ "“앱스토어사업자”란 회사가 제공하는 애플리케이션을 다운로드 받을 수 있고, In-App결제를 할 수 있도록 하는 오픈마켓 사업자를 말합니다.");
		textarea1.setBounds(30, 70, 450, 150);
		textarea1.setEditable(false);

		TextArea textarea2 = new TextArea("제3조(회사정보 등의 제공)\r\n" + "\r\n"
				+ "회사는 다음 각호의 사항을 회사의 웹사이트에 게시하거나 애플리케이션내의 연결화면을 통해 이용자가 이를 쉽게 알 수 있도록 합니다. 다만, 이 약관 및 개인정보처리방침은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.\r\n"
				+ "\r\n" + "상호 및 대표자의 성명\r\n" + "영업소 소재지 주소(이용자의 불만을 처리할 수 있는 곳의 주소를 포함한다) 및 전자우편주소\r\n"
				+ "전화번호, FAX 번호\r\n" + "사업자등록번호, 통신판매업 신고번호\r\n" + "개인정보처리방침\r\n" + "서비스이용약관\r\n" + "\r\n" + "\r\n"
				+ "제4조(약관의 효력 및 변경)\r\n" + "\r\n"
				+ "① 이 약관은 이용자가 알 수 있도록 회사의 웹사이트에 게시하거나 어플리케이션 내의 연결화면 등을 통해 이용자에게 공지함으로써 효력이 발생합니다.\r\n"
				+ "② 회사는 「전자상거래 등에서의 소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「게임산업진흥에 관한 법률」, 「정보통신망이용촉진 및 정보보호 등에 관한 법률」, 「콘텐츠산업진흥법」 등 관련 법령에 위배되지 않는 범위에서 이 약관을 변경할 수 있습니다. 변경되는 약관은 적용일자, 변경내용 및 변경사유 등을 명시하여 그 적용일 7일 이전부터 서비스 공식 블로그 또는 단말기 알림(Push 알림) 등을 통해 이용자에게 공지합니다. 다만, 이용자의 권리∙의무에 중대한 영향을 미치는 사항에 대해서는 그 적용일 30일 이전부터 공지합니다.\r\n"
				+ "③ 이용자는 변경되는 약관에 대해 동의하지 않을 수 있으며, 변경되는 약관에 동의하지 않는 경우에는 서비스 이용을 중단하고 서비스에서 탈퇴를 할 수 있습니다. 다만, 제2항의 방법으로 변경되는 약관 공지 시 이용자가 별도의 의사표시를 하지 않으면 승낙한 것으로 본다고 공지하였음에도 불구하고, 변경되는 약관의 적용일 전일까지 회사에 대해 명시적으로 의사표시를 하지 아니하는 경우 또는 이용자가 변경되는 약관 적용일 이후에도 계속하여 서비스를 이용하는 경우에는 변경된 약관에 동의한 것으로 봅니다.\r\n"
				+ "\r\n" + "\r\n" + "\r\n" + "제5조(약관 외 준칙)\r\n" + "\r\n"
				+ "이 약관에서 정하지 아니한 사항에 관하여는 「전자상거래 등에서의 소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「게임산업진흥에 관한 법률」, 「정보통신망이용촉진 및 정보보호 등에 관한 법률」, 「콘텐츠산업진흥법」 등 관련 법령 및 상관례에 따릅니다.\r\n"
				+ "\r\n" + "\r\n" + "\r\n" + "제6조(이용 계약의 성립)\r\n" + "\r\n"
				+ "① 서비스 이용계약은 이용고객이 애플리케이션을 설치 및 구동하여 이 약관 및 개인정보처리방침에 동의한 다음 서비스 이용신청을 하고, 회사가 그 이용신청에 승낙함으로써 성립합니다. 이용고객의 서비스 이용신청 완료 후 단말기내에서 애플리케이션이 정상적으로 구동되는 경우에는 서비스 이용이 승낙된 것으로 봅니다. ② 이용자는 서비스 이용과정에서 타인의 개인정보를 도용하는 경우 이 약관에 의한 이용자의 권리를 주장할 수 없으며, 회사는 이용계약을 취소하거나 해지할 수 있습니다. 이용자가 플랫폼사업자에게 개인정보를 제공하고 플랫폼사업자를 통해 서비스를 이용하는 경우에도 동일하게 간주됩니다. ③ 회사는 다음 각호의 어느 하나에 해당하는 이용신청에 대해서는 승낙을 하지 않을 수 있습니다.\r\n"
				+ "\r\n" + "서비스 운영정책에 따라 최근 3개월 내 이용제한을 받았거나, 영구제한을 받은 이용자가 이용신청을 하는 경우\r\n"
				+ "회사가 체결한 계약에 따라 또는 특정 국가에서 접속하는 이용자에게 서비스를 제공하는 것을 제한할 필요가 있는 경우\r\n"
				+ "「게임산업진흥에 관한 법률」, 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 및 그 밖의 관련 법령에서 금지하는 위법행위를 할 목적으로 이용신청을 하는 경우\r\n"
				+ "그 밖에 제1호 내지 제3호에 준하는 사유로서 승낙이 부적절하다고 판단되는 경우");
		textarea2.setBounds(30, 260, 450, 150);
		textarea2.setEditable(false);

		JCheckBox Checkbox1 = new JCheckBox("예.확인하였습니다");
		Checkbox1.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		Checkbox1.setForeground(Color.white);
		Checkbox1.setBorderPainted(false);
		Checkbox1.setContentAreaFilled(false);
		Checkbox1.setFocusPainted(false);
		Checkbox1.setBounds(30, 220, 200, 30);

		JCheckBox Checkbox2 = new JCheckBox("예.확인하였습니다");
		Checkbox2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		Checkbox2.setForeground(Color.white);
		Checkbox2.setBorderPainted(false);
		Checkbox2.setContentAreaFilled(false);
		Checkbox2.setFocusPainted(false);
		Checkbox2.setBounds(30, 410, 200, 30);

		JLabel button1 = new JLabel(
				new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(80, 30, 0)));
		button1.setBounds(400, 430, 80, 30);
		button1.setEnabled(false);
		JLabel ok = new JLabel("확  인");
		ok.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		ok.setForeground(Color.black);
		ok.setBounds(416, 431, 80, 30);
		di.add(ok);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new YJ_SignupPage(mf);
				di.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				di.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});

		JLabel button2 = new JLabel(
				new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(80, 30, 0)));
		button2.setBounds(320, 430, 80, 30);
		JLabel back = new JLabel("이  전");
		back.setBounds(335, 430, 80, 30);
		back.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		back.setForeground(Color.black);
		di.add(back);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				di.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				di.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});

		Checkbox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				Checkbox2.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {

						if (e.getStateChange() == ItemEvent.SELECTED)
							button1.setEnabled(true);

						else
							button1.setEnabled(false);
					}
				});

			}
		});
	
		di.add(headlabel);
		di.add(textarea1);
		di.add(textarea2);
		di.add(Checkbox1);
		di.add(Checkbox2);
		di.add(button1);
		di.add(button2);
		di.add(backImage);

		di.setResizable(false);
		di.setVisible(true);

	}
}