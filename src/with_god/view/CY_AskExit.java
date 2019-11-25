package with_god.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import with_god.controller.ChangePanel;

public class CY_AskExit {
	public CY_AskExit(JFrame mf, JPanel exitPanel) {
		Dialog dg = new Dialog(mf, true);
		dg.setSize(500, 300);
		dg.setLocationRelativeTo(mf);
		dg.setUndecorated(true);
		dg.setLayout(null);
		
		JLabel groundL = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(500, 300, 0)));
		JLabel askL = new JLabel("   게임을 정말 종료하시겠습니까?");
		JLabel yesL = new JLabel(new ImageIcon(new ImageIcon("images/yes.png").getImage().getScaledInstance(90, 40, 0)));
		JLabel noL = new JLabel(new ImageIcon(new ImageIcon("images/no.png").getImage().getScaledInstance(90, 40, 0)));
		groundL.setSize(500, 300);
		askL.setBounds(30, 100, 450, 100);
		askL.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		askL.setForeground(Color.WHITE);
		yesL.setBounds(120, 240, 100, 40);
		noL.setBounds(280, 240, 100, 40);
		dg.add(groundL);
		dg.add(askL);
		dg.add(yesL);
		dg.add(noL);
		
		dg.setComponentZOrder(groundL, 3);
		
		yesL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, exitPanel, new LogInPage(mf));
				dg.dispose();
			}
		});
		noL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dg.dispose();
			}
		});
		
		dg.setVisible(true);
	}
}
