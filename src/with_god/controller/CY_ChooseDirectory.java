package with_god.controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import with_god.model.vo.User;

public class CY_ChooseDirectory {

	public CY_ChooseDirectory(User user) {
	
		//���ϼ��� ��ü ����
		JFileChooser chooser = new JFileChooser();
		//���ϰ�θ� ������
		int ret = chooser.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			//���� �������ÿ� ����â �����ش�.
			JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
			//������ ��� console â�� ������ �ȶ�.
			return;
		}
		
		//������ �޾ƿ�
		String filePath = chooser.getSelectedFile().getPath();
		System.out.println(filePath);
		
		//�̹����� ȸ����ü�� �־���
		user.setImageLoad(filePath);
		
		
	}
}

