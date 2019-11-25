package with_god.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//메인화면에서의 종료버튼, 마이페이지 버튼 구성
public class CY_Page extends JPanel{
	
	private JFrame mf;
	private JPanel exitPanel = this;
	public CY_Page (JFrame mf) {
		this.mf = mf;
		mf.add(this);
		//Layout을 null 값으로 해야 위치조정이 가능해진다.
		this.setLayout(null);

		//이미지 아이콘파일 가져오기
		Image ground = new ImageIcon("images/ground.gif").getImage().getScaledInstance(1300, 800, 0);
		Image exit = new ImageIcon("images/xx.png").getImage().getScaledInstance(50, 50, 0);
		Image myPage = new ImageIcon("images/myPage.png").getImage().getScaledInstance(50, 50, 0);
		
		JLabel groundL = new JLabel(new ImageIcon(ground));
		JLabel exitL = new JLabel(new ImageIcon(exit));
		JLabel myPageL = new JLabel(new ImageIcon(myPage));
		
		//아이콘이 들어간 라벨 사이즈 조정
		groundL.setSize(1300, 800);
		myPageL.setBounds(1130, 700, 50, 50);
		exitL.setBounds(1200, 700, 50, 50);
		
		this.add(groundL);
		this.add(exitL);
		this.add(myPageL);
		
		//라벨의 보이는 우선순위 정해주기
		this.setComponentZOrder(groundL, 2);
		
		/*button 형상을 없애주는 메서드 Frame에 아이콘만 남는다. label은 안써줘도 됌.
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
