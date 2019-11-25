
package with_god.view;

import javax.swing.JFrame;

public class SY_mainFrame extends JFrame{
	public SY_mainFrame() { //생성자이기 때문에 void를 안썼던것 , 대신 클래스명이랑 같아야함 . 
		
	
		this.setSize(1300,800);
		this.setLocation(300,200);
		//this.setLayout(null);
		
		
		new SY_mainPanel(this);
	
	    
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


			
}
