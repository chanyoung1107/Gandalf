package with_god.view;

import javax.swing.JFrame;

public class CY_MainFrame extends JFrame{

	public CY_MainFrame() {
		this.setSize(1300, 800);	
		new CY_Page(this);
	
		this.setTitle("신과 함께 가로세로");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//화면에 창 띄우기
		this.setVisible(true);
		//창 닫을때 프로그램도 같이 종료 시킨다.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
}


