package with_god.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class YH_QuizShowPanel extends JLabel{
	private JLabel label;
	private JPanel panel;

	public YH_QuizShowPanel(JPanel panel) {
		this.panel = panel;
		label = this;
		label.setLayout(null);
		label.setBackground(Color.WHITE);
		label.setBounds(690, 30, 570, 150);
		label.setOpaque(true);
		label.setFont(new Font("±¼¸²", 1, 20));
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.TOP);
		
		panel.add(label);
	}
}
