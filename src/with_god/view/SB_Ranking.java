package with_god.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;

public class SB_Ranking extends JPanel {
	
	private JFrame mf;
	private JPanel jp = this;
	public SB_Ranking (JFrame mf) {
		this.mf = mf;
		mf.add(this);
		this.setLayout(null);
		this.setBounds(0, 0, 1300, 800);
		Image background = new ImageIcon("images/gw.png").getImage().getScaledInstance(1300, 800, 0);
		Image exit = new ImageIcon("images/exit.png").getImage().getScaledInstance(50, 50, 0);
		
		JLabel backgroundL = new JLabel(new ImageIcon(background));
		JLabel exitL = new JLabel(new ImageIcon(exit));
		
		backgroundL.setSize(1300, 800);
		exitL.setBounds(1180, 680, 50, 50);
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new MainPage(mf));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		
		this.add(backgroundL);
		this.add(exitL);
		this.setComponentZOrder(backgroundL, 1);
		
		
	}

}
