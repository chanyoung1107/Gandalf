package with_god.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SY_gameMain extends JPanel {
	private JFrame jf ;
	private JPanel jp;

	public SY_gameMain(JFrame jf) { //카테고리 있는    게임메인창 
		this.jf = jf;
		this.setBackground(Color.yellow);
		
		this.setBounds(0, 0, 1300, 800);
		jp = this;
		jf.add(jp);
		
		JLabel label = new JLabel();
		label.setBounds(0,0,1000,800);
		label.setFont(new Font("고딕" , 500, 200));
		
		
		jp.add(label);
		
	

		jf.setVisible(true);

	}

}
