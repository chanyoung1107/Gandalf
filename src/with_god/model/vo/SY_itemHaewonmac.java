package with_god.model.vo;

import java.awt.Color;

import with_god.view.EJ_Timer;
import with_god.view.YH_GameBoard;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SY_itemHaewonmac extends JLabel/* implements Runnable */{ //�ؿ��� : ���� ���� �Է� �󸮱�
	private boolean item;
	private JFrame jf;
	private JPanel jp ;
	
	public SY_itemHaewonmac() {}
	
	public SY_itemHaewonmac(JPanel jp) {
		//this.jf = jf;
		this.jp = jp;

		JLabel jl = this;
		
		jl.setText("�ؿ����� ��븦 5�� ��Ƚ��ϴ�"); 
		jp.add(jl);
		jf.add(jp);
		jl.setBounds(500,600,400,300);
		jl.setForeground(Color.white);
		jp.setComponentZOrder(jl,0);

	}


	public boolean timeStop(JFrame jf, JPanel jp) {
		if(item==true) {
			
		//	EJ_Timer h = new EJ_Timer getsleeprun()
			
			
		//	timer.sleeprun();
			item = false;  
		
		}else{
		
		}
		
		
		return item;
	}

	
}


