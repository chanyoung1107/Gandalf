package with_god.view;

import javax.swing.JFrame;

public class EJ_MainFrame extends JFrame {
	public EJ_MainFrame() {
		
		this.setTitle("신과함께 테스트");
		this.setSize(1300, 800);
		this.setLocationRelativeTo(null);
		//new EJ_StoreManager(this);
		//new EJ_GameModeChoicePanel(this);
		new MainPage(this);
		//new InGamePage(this);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
