package with_god.view;

import javax.swing.JFrame;

public class YH_MainFrame extends JFrame{
	
	public YH_MainFrame() {
		this.setBounds(200, 50, 1300, 800);
		this.setLayout(null);
		
		new YH_InGamePanel(this);
//		new InGamePage(this);
		System.out.println("이벤트 종료3");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
