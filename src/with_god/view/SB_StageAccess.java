package with_god.view ;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SB_StageAccess {
	public SB_StageAccess(JFrame mf) {
		Dialog dg = new Dialog(mf, "불가");
		dg.setSize(400, 250);
		dg.setLocationRelativeTo(mf);
		dg.setBackground(Color.darkGray);
		dg.setLayout(null);
		
		Image exit = new ImageIcon("images/exitButtonBasic.png").getImage().getScaledInstance(30, 30, 0);

		
		JLabel set = new JLabel("이전 스테이지를 \n클리어 하세요!!");
		set.setBounds(70, 90, 300, 100);
		set.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		set.setForeground(Color.RED);
		JLabel exitL = new JLabel(new ImageIcon(exit));
		exitL.setBounds(340, 200, 30, 30);

		exitL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dg.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
		});
		dg.add(exitL);
		dg.add(set);
		dg.setVisible(true);
	}
}
