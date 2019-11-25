package with_god.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


class SimpleDialog extends JDialog implements ActionListener { // �씤
	JPanel p1, p2;
	JLabel l;
	JButton okButton;
	JButton cancelButton;

	SimpleDialog(Frame parent, String str) {
		super(parent, str, true); // �씥
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		add(p1);

		l = new JLabel("媛꾨떒�븳 ���솕 �긽�옄�엯�땲�떎.", JLabel.CENTER);
		p1.add(l, "Center");
		p2 = new JPanel();
		p1.add(p2, "South");
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		p2.add(okButton);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		p2.add(cancelButton);
		setSize(300, 200);
		addWindowListener(new MyWinListener()); // �씦
	}

	public void actionPerformed(ActionEvent e) {
		dispose(); // ���솕�긽�옄瑜� �젣嫄�
	}

	class MyWinListener extends WindowAdapter { // �씧
		public void windowClosing(WindowEvent e) {
			dispose(); // ���솕�긽�옄瑜� �젣嫄�
		}
	}
}