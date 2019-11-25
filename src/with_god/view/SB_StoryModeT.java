package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.controller.ChangePanel;

public class SB_StoryModeT extends JPanel {

	private JFrame mf;
	private JPanel jp = this;
	private JLabel label;
	
	public SB_StoryModeT(JFrame mf) {
		this.mf = mf;
		mf.add(this);
		this.setBounds(0, 0, 1300, 800);
		this.setLayout(null);
		Image exit = new ImageIcon("images/exitButtonBasic.png").getImage().getScaledInstance(50, 50, 0);
		
		
		JLabel text = new JLabel("스토리모드11111");
		text.setBounds(500, 300, 400, 100);
		text.setFont(new Font("궁서", Font.BOLD, 50));
		text.setForeground(Color.RED);
		JLabel exitL = new JLabel(new ImageIcon(exit));
		exitL.setBounds(1180, 680, 50, 50);
		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, jp, new SB_StoryModeChoiceMap(mf));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
		this.setBackground(Color.YELLOW);
		this.add(exitL);
		this.add(text);
	}
}
