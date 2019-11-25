package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import with_god.controller.CY_ChooseDirectory;
import with_god.controller.UserManager;
import with_god.model.dao.UserDao;
import with_god.model.vo.User;

public class CY_FixPage {
   
   UserDao ud = new UserDao();
   UserManager um = new UserManager();

   public CY_FixPage(JFrame mf, User user) {
      String tempImage = user.getImageLoad();
      Dialog dg = new Dialog(mf, true);
      dg.setUndecorated(true);
      dg.setSize(500, 600);
      dg.setLayout(null);
      dg.setLocationRelativeTo(mf);
      
      JLabel groundL = new JLabel(new ImageIcon(new ImageIcon("images/그라데이션그레이.jpg").getImage().getScaledInstance(550, 680, 0)));
      JLabel imageL = new JLabel(new ImageIcon(new ImageIcon(user.getImageLoad()).getImage().getScaledInstance(150, 150, 0)));
      JLabel fixOrange = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(50, 30, 0)));
      JLabel fixL  = new JLabel("변경");
      JLabel PwL1 = new JLabel("비밀번호 변경");
      JLabel PwL2 = new JLabel("비밀번호 확인");
      JLabel DreamL = new JLabel("장래희망 변경");
      JLabel EmailL = new JLabel("이메일 변경");
      
      groundL.setSize(500, 600);
      imageL.setBounds(180, 70, 150, 150);
      fixOrange.setBounds(331, 193, 50 ,30);
      fixL.setBounds(338, 193, 40, 30);
      PwL1.setBounds(30, 280, 170, 25);
      PwL2.setBounds(30, 330, 170, 25);
      DreamL.setBounds(30, 380, 170, 25);
      EmailL.setBounds(30, 430, 170, 25);
      fixL.setFont(new Font("휴먼편지체", Font.BOLD, 20));
      PwL1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      PwL2.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      DreamL.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      EmailL.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      PwL1.setForeground(Color.WHITE);
      PwL2.setForeground(Color.WHITE);
      DreamL.setForeground(Color.WHITE);
      EmailL.setForeground(Color.WHITE);

      dg.add(groundL);
      dg.add(imageL);
      dg.add(fixOrange);
      dg.add(fixL);
      dg.add(PwL1);
      dg.add(PwL2);
      dg.add(DreamL);
      dg.add(EmailL);
      
      dg.setComponentZOrder(imageL, 0);
      dg.setComponentZOrder(fixOrange, 0);
      dg.setComponentZOrder(fixL, 0);
      dg.setComponentZOrder(PwL1, 0);
      dg.setComponentZOrder(PwL2, 0);
      dg.setComponentZOrder(DreamL, 0);
      dg.setComponentZOrder(EmailL, 0);
      
      JPasswordField fixPwdT1 = new JPasswordField();
      JPasswordField fixPwdT2 = new JPasswordField();
      JTextField fixDreamT = new JTextField();
      JTextField fixEmailT = new JTextField();
      
      fixPwdT1.setBounds(230, 280, 240, 25);
      fixPwdT2.setBounds(230, 330, 240, 25);
      fixDreamT.setBounds(230, 380, 240, 25);
      fixEmailT.setBounds(230, 430, 240, 25);
      
      fixDreamT.setFont(new Font("휴먼편지체", Font.BOLD, 25));
      fixEmailT.setFont(new Font("휴먼편지체", Font.BOLD, 25));

      fixDreamT.setText(user.getDream());
      fixEmailT.setText(user.getEmail());
      
      dg.add(fixPwdT1);
      dg.add(fixPwdT2);
      dg.add(fixDreamT);
      dg.add(fixEmailT);
      
      dg.setComponentZOrder(fixPwdT1, 0);
      dg.setComponentZOrder(fixPwdT2, 0);
      dg.setComponentZOrder(fixDreamT, 0);
      dg.setComponentZOrder(fixEmailT, 0);

      JLabel orange = new JLabel(new ImageIcon(new ImageIcon("images/오렌지버튼.png").getImage().getScaledInstance(50, 30, 0)), JLabel.CENTER);
      JLabel yesL = new JLabel("변경", JLabel.CENTER);
      JLabel noL = new JLabel(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(40, 40, 0)), JLabel.CENTER);
      orange.setBounds(0, 550, 500, 30);
      yesL.setBounds(0, 550, 500, 30);
      noL.setBounds(425, 545, 40, 40);
      yesL.setFont(new Font("휴먼편지체", Font.BOLD, 20));

      dg.add(orange);
      dg.add(yesL);
      dg.add(noL);
      
      dg.setComponentZOrder(orange, 0);
      dg.setComponentZOrder(yesL, 0);
      dg.setComponentZOrder(noL, 0);
      
      
      fixL.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            new CY_ChooseDirectory(user);
            //현재 페이지의 이미지를 새로고침 해준다.
            imageL.setIcon(new ImageIcon(new ImageIcon(user.getImageLoad()).getImage().getScaledInstance(150, 150, 0)));
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            fixL.setCursor(new Cursor(Cursor.HAND_CURSOR));
            SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
      });
      
      yesL.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            //비밀번호창 2개의 리턴값이 같은지 비교 && 회원 객체의 비밀번호가 같은지 비교
            //변수명.getPassword는 캐릭터 배열 형태이므로 문자열과 비교 불가
            //캐릭터 배열을 문자열로 바꿔주는 메서드
            String pw1 = "";
            for(char ch1 : fixPwdT1.getPassword()) {
               Character.toString(ch1);
               pw1 += ch1;
            }
            String pw2 = "";
            for(char ch1 : fixPwdT2.getPassword()) {
               Character.toString(ch1);
               pw2 += ch1;
            }
            if(pw1 != "" && pw2 != "") {

               if(pw1.equals(pw2)) {
                  //같으면 수정 정보 객체에 저장 후
                  //확인 Dialog창 띄운후 마이페이지로 넘어감
                  user.setPw(pw1);
                  user.setDream(fixDreamT.getText());
                  user.setEmail(fixEmailT.getText());
                  um.updatePw(user);
                  
                  JOptionPane.showMessageDialog(mf, "성공적으로 변경되었습니다.", "확인", JOptionPane.INFORMATION_MESSAGE);
                  dg.dispose();
                  
               }else {
                  //간단한 창으로 일치오류 정보창 띄움
                  JOptionPane.showMessageDialog(mf, "비밀번호가 일치하지 않습니다.", "x", JOptionPane.ERROR_MESSAGE);
                  fixPwdT1.setText("");
                  fixPwdT2.setText("");
                  fixPwdT1.requestFocus();

               }
            }else {
               //비밀번호변경과 변경확인 창 모두 입력하지 않았을 경우
               //다른 수정 정보만 객체에 저장 후 확인 dialog 창 띄운후 마이페이지로 넘어감
               user.setDream(fixDreamT.getText());
               user.setEmail(fixEmailT.getText());
               
               JOptionPane.showMessageDialog(mf, "성공적으로 변경되었습니다.",  "확인", JOptionPane.INFORMATION_MESSAGE);
               dg.dispose();
            }

         }
         @Override
         public void mouseEntered(MouseEvent e) {
            yesL.setCursor(new Cursor(Cursor.HAND_CURSOR));
            SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
      });
      noL.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            user.setImageLoad(tempImage);
            dg.dispose();
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            noL.setCursor(new Cursor(Cursor.HAND_CURSOR));
            SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
      });
      
      
      dg.setVisible(true);
   }
}






