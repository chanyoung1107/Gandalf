package with_god.view;

import javax.swing.JFrame;

public class CY_MainFrame extends JFrame{

	public CY_MainFrame() {
		this.setSize(1300, 800);	
		new CY_Page(this);
	
		this.setTitle("�Ű� �Բ� ���μ���");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//ȭ�鿡 â ����
		this.setVisible(true);
		//â ������ ���α׷��� ���� ���� ��Ų��.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
}


