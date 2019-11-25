package with_god.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class SY_mainPanel extends JPanel  {
	
	protected static final JPanel JPanel = null;
	private JFrame jf;
	private JPanel panel = this;
	
	public SY_mainPanel() {}

	public SY_mainPanel(JFrame jf) {
		this.jf = jf;
		//panel.setBounds(0,0,1000,800);
		
		
		this.setLayout(null);
		this.setSize(1300,800);



		JLabel jl = new JLabel(new ImageIcon(new ImageIcon("image/backGroundSY.jpg").getImage().getScaledInstance(1300, 800, 0)));
		jl.setBounds(0, 0, 1300, 800);
		
		panel.add(jl);
		/**프레임 위에 패널 붙임*/ 

		JLabel exitL = new JLabel(new ImageIcon(new ImageIcon("image/exitButtonSY.png").getImage().getScaledInstance(70,70, 0)));
		exitL.setBounds(1150,660,70,70);
		/**인게임 내부 나가기를 위한 버튼*/

		
		exitL.setBounds(1150,660,70,70);

		//exitL.add(this);
	
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SY_exitDialog(jf, panel);
			}
		});
			

		this.add(exitL);
		panel.setComponentZOrder(jl, 1);
		panel.setComponentZOrder(exitL, 0);
		jf.add(this);
	}




}


