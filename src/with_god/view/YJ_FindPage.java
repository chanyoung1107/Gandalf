package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import with_god.controller.YJ_Email;
import with_god.run.YJ_Run;

public class YJ_FindPage {
	
   ////////////////////////////////////아아디/비밀번호찾기///////////////////////////////////////////////////////
   public YJ_FindPage(JFrame mf) {
      JDialog dg = new JDialog(mf, "아아디 / 비밀번호 수정");
      JLabel headlabel = new JLabel();
      JLabel backImage = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(500, 500, 0)));
      YJ_Email mail = new YJ_Email();
     
      backImage.setSize(500, 500);
      dg.setSize(500, 500);
      dg.setLayout(null);

      headlabel.setBounds(125, -110, 300, 300);
      headlabel.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      headlabel.setForeground(Color.white);
      headlabel.setText("아이디 / 비밀번호 찾기");
      dg.add(headlabel);

      JLabel label1 = new JLabel();
      label1.setBounds(150, 130, 100, 30);
      label1.setFont(new Font("휴먼편지체", Font.BOLD, 15));
      label1.setForeground(Color.white);
      label1.setText("이름");
      JTextField tf1 = new JTextField();
      tf1.setBounds(200, 130, 100, 30);
      ImageIcon idbutton = new ImageIcon(YJ_Run.class.getResource("../../image/id.png"));
      JLabel idbt = new JLabel(idbutton);
      idbt.setBounds(170, 20, 150, 150);
      dg.add(idbt);
      dg.add(tf1);
      dg.add(label1);

      JLabel label2 = new JLabel();
      label2.setBounds(135, 180, 100, 30);
      label2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
      label2.setForeground(Color.white);
      label2.setText("이메일");
      JTextField tf2 = new JTextField();
      tf2.setBounds(200, 180, 100, 30);
      JLabel btn1 = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(80, 30, 0)));
      btn1.setBounds(310, 180, 80, 30);
      JLabel Idchek = new JLabel("전  송");
      Idchek.setBounds(325, 180, 80, 30);
      Idchek.setFont(new Font("휴먼편지체", Font.BOLD, 18));
      Idchek.setForeground(Color.white);
      dg.add(Idchek);
      dg.add(btn1);
      dg.add(tf2);
      dg.add(label2);

      JLabel label3 = new JLabel();
      label3.setBounds(150, 300, 100, 30);
      label3.setFont(new Font("휴먼편지체", Font.BOLD, 15));
      label3.setForeground(Color.white);
      label3.setText("이름");
      JTextField tf3 = new JTextField();
      tf3.setBounds(200, 300, 100, 30);
      ImageIcon pwbutton = new ImageIcon(YJ_Run.class.getResource("../../image/pw.png"));
      JLabel pwbt = new JLabel(pwbutton);
      pwbt.setBounds(170, 230, 150, 50);
      dg.add(pwbt);
      dg.add(tf3);
      dg.add(label3);

      JLabel label4 = new JLabel();
      label4.setBounds(135, 350, 100, 30);
      label4.setFont(new Font("휴먼편지체", Font.BOLD, 15));
      label4.setForeground(Color.white);
      label4.setText("아이디");
      JTextField tf4 = new JTextField();
      tf4.setBounds(200, 350, 100, 30);
      dg.add(tf4);
      dg.add(label4);

      JLabel label5 = new JLabel();
      label5.setBounds(135, 400, 100, 30);
      label5.setFont(new Font("휴먼편지체", Font.BOLD, 15));
      label5.setForeground(Color.white);
      label5.setText("이메일");
      JTextField tf5 = new JTextField();
      tf5.setBounds(200, 400, 100, 30);
      JLabel btn2 = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(80, 30, 0)));
      btn2.setBounds(310, 400, 80, 30);
      JLabel pwchek = new JLabel("전  송");
      pwchek.setBounds(324, 400, 80, 30);
      pwchek.setFont(new Font("휴먼편지체", Font.BOLD, 18));
      pwchek.setForeground(Color.white);
      
      btn1.addMouseListener(new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    		  mail.getEmailAddress(tf2.getText());
    	      String[] args1 = {""};
    	      mail.main(args1);
    		  dg.dispose();
    	  }
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

		});
      btn2.addMouseListener(new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    		  mail.getEmailAddress(tf5.getText());
    		  String[] args1 = {""};
    		  mail.main(args1);
    		  dg.dispose();
      }
			@Override
			public void mouseEntered(MouseEvent e) {
				dg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
	});      
      dg.add(pwchek);
      dg.add(btn2);
      dg.add(tf5);
      dg.add(label5);
      dg.add(backImage);
      dg.setResizable(false);
      dg.setLocationRelativeTo(null);
      dg.setVisible(true);
      
   }

public YJ_FindPage() {
	
}


}