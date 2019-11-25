package with_god.view;

import javax.swing.JFrame;


public class SB_MainFrame extends JFrame {
	
	public SB_MainFrame() {
		this.setSize(1300, 800);
		//new SB_Setting(this);
		//new SB_Ranking(this);
		//new SB_StoryModeChoiceMap(this);
		new SB_Rankingg(this);
		this.setTitle("Test1");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
