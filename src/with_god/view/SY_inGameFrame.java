package with_god.view;

import javax.swing.JFrame;

public class SY_inGameFrame extends JFrame{
	

	public SY_inGameFrame() { //�������̱� ������ void�� �Ƚ���� , ��� Ŭ�������̶� ���ƾ��� . 
		
		
		this.setSize(1300,800);
		this.setLocation(300,200);
		//this.setLayout(null);
		
		
		new SY_inGamePanel(this);
	
	    
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


}
