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

import with_god.controller.SY_changePanel;
import with_god.model.vo.User;

public class SY_exitDialog {
	
	private JFrame jf;    
	
	
	public SY_exitDialog(JFrame jf, JPanel exitPanel, User user) {
		Dialog di = new Dialog(jf, true);
		di.setUndecorated(true);
		di.setSize(500, 300);
		di.setLocationRelativeTo(jf);
		di.setLayout(null);
		
		
		JLabel backGround = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(500, 300, 0)));
		JLabel yesExit = new JLabel(new ImageIcon(new ImageIcon("images/yes.png").getImage().getScaledInstance(90,40, 0)));
		JLabel noDispose = new JLabel(new ImageIcon(new ImageIcon("images/no.png").getImage().getScaledInstance(90,40, 0)));
		JLabel quesExit = new JLabel("       게임을 나가시겠습니까?");
		
	    backGround.setSize(500,300);
	    quesExit.setBounds(30,100,450,100);
	    quesExit.setFont(new Font("휴먼편지체" , Font.BOLD, 30));
	    quesExit.setForeground(Color.WHITE);
	    
	    yesExit.setBounds(120, 240, 100, 40); 
	    noDispose.setBounds(280, 240, 100, 40);
	    di.add(backGround);
	    di.add(yesExit);
	    di.add(noDispose);
	    di.add(quesExit);
	    
	 
	    di.setComponentZOrder(backGround,2);
	    di.setComponentZOrder(quesExit,0);
		
	    yesExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SY_changePanel.changePanel(jf, exitPanel, new MainPage(jf, user));
				di.dispose();
			}
	    });
	    noDispose.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		di.dispose();
	    	}
	    });
			

		di.setVisible(true);
		
		 //noDispose;

	}
	
	public SY_exitDialog(JFrame jf, JPanel exitPanel , Thread timer1, User user) {
			Dialog di = new Dialog(jf);
			di.setBounds(400, 230, 500, 300);
			di.setLayout(null);
			
			
			JLabel backGround = new JLabel(new ImageIcon(new ImageIcon("images/천국지옥.jpg").getImage().getScaledInstance(500, 300, 0)));
			JLabel quesExit = new JLabel("게임을 나가시겠습니까");
			JLabel yesExit = new JLabel(new ImageIcon(new ImageIcon("images/yes.png").getImage().getScaledInstance(90,40, 0)));
			JLabel noDispose = new JLabel(new ImageIcon(new ImageIcon("images/no.png").getImage().getScaledInstance(90,40, 0)));
			
		    backGround.setSize(500,300);
		    quesExit.setBounds(30,100,450,100);
		    quesExit.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		    quesExit.setForeground(Color.WHITE);
		    
		    yesExit.setBounds(120, 240, 100, 40); 
		    noDispose.setBounds(280, 240, 100, 40);
		    di.add(backGround);
		    di.add(yesExit);
		    di.add(noDispose);
		    
		 
		    di.setComponentZOrder(backGround,2);
		    di.setComponentZOrder(quesExit, 0);
		    
		    
			
		    yesExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SY_changePanel.changePanel(jf, exitPanel, new MainPage(jf, user));
					di.dispose();
//					timer1.interrupt();
//					timer2.interrupt();
					
					timer1.stop();
				}
		    });
		    noDispose.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		di.dispose();
		    		
		    		timer1.resume();
		    	}
		    });
				

			di.setVisible(true);
			
			 //noDispose;
	
		}
}
