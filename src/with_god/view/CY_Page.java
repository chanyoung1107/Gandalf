package with_god.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//����ȭ�鿡���� �����ư, ���������� ��ư ����
public class CY_Page extends JPanel{
	
	private JFrame mf;
	private JPanel exitPanel = this;
	public CY_Page (JFrame mf) {
		this.mf = mf;
		mf.add(this);
		//Layout�� null ������ �ؾ� ��ġ������ ����������.
		this.setLayout(null);

		//�̹��� ���������� ��������
		Image ground = new ImageIcon("images/ground.gif").getImage().getScaledInstance(1300, 800, 0);
		Image exit = new ImageIcon("images/xx.png").getImage().getScaledInstance(50, 50, 0);
		Image myPage = new ImageIcon("images/myPage.png").getImage().getScaledInstance(50, 50, 0);
		
		JLabel groundL = new JLabel(new ImageIcon(ground));
		JLabel exitL = new JLabel(new ImageIcon(exit));
		JLabel myPageL = new JLabel(new ImageIcon(myPage));
		
		//�������� �� �� ������ ����
		groundL.setSize(1300, 800);
		myPageL.setBounds(1130, 700, 50, 50);
		exitL.setBounds(1200, 700, 50, 50);
		
		this.add(groundL);
		this.add(exitL);
		this.add(myPageL);
		
		//���� ���̴� �켱���� �����ֱ�
		this.setComponentZOrder(groundL, 2);
		
		/*button ������ �����ִ� �޼��� Frame�� �����ܸ� ���´�. label�� �Ƚ��൵ ��.
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);*/

		//
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CY_AskExit(mf, exitPanel);
			}
		});
		myPageL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CY_MyPage(mf);
			}
		});
		
	}
}
