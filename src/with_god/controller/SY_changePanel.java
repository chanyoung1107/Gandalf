package with_god.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class SY_changePanel {
	
	
	public static void changePanel(JFrame jf, JPanel jp, JPanel gp) {
		
		jf.remove(jp);
		jf.add(gp);
		jf.repaint();

	}
}
