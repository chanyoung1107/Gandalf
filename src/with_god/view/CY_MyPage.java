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

import with_god.model.vo.User;

public class CY_MyPage {

   public CY_MyPage(JFrame mf, User user) {
      
      Dialog dg = new Dialog(mf, "MyPage", true);
      dg.setUndecorated(true);
      dg.setSize(550, 680);
      dg.setLayout(null);
      dg.setLocationRelativeTo(mf);
      
      JLabel groundL = new JLabel(new ImageIcon(new ImageIcon("images/�׶��̼Ǳ׷���.jpg").getImage().getScaledInstance(550, 680, 0)));
      JLabel imageL = new JLabel(new ImageIcon(new ImageIcon(user.getImageLoad()).getImage().getScaledInstance(150, 150, 0)));
      JLabel nickNameL = new JLabel("�г���");
      JLabel playCountL = new JLabel("����");
      JLabel rankL = new JLabel("��ŷ");
      JLabel dreamL = new JLabel("�巡���");
      JLabel emailL = new JLabel("�̸���");
      
      groundL.setSize(550, 680);
      imageL.setBounds(200, 70, 150, 150);
      nickNameL.setBounds(60, 270, 150, 30);
      nickNameL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
      nickNameL.setForeground(Color.white);
      playCountL.setBounds(60, 330, 150, 30);
      playCountL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
      playCountL.setForeground(Color.white);
      rankL.setBounds(60, 390, 150, 30);
      rankL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
      rankL.setForeground(Color.white);
      dreamL.setBounds(60, 450, 150, 30);
      dreamL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
      dreamL.setForeground(Color.white);
      emailL.setBounds(60, 510, 150, 30);
      emailL.setFont(new Font("�޸�����ü", Font.BOLD, 30));
      emailL.setForeground(Color.white);
      
      dg.add(groundL);
      dg.add(imageL);
      dg.add(nickNameL);
      dg.add(playCountL);
      dg.add(rankL);
      dg.add(dreamL);
      dg.add(emailL);
      
      dg.setComponentZOrder(imageL, 0);
      dg.setComponentZOrder(nickNameL, 0);
      dg.setComponentZOrder(playCountL, 0);
      dg.setComponentZOrder(rankL, 0);
      dg.setComponentZOrder(dreamL, 0);
      dg.setComponentZOrder(emailL, 0);
      
      
      //�� ������ �� �ڿ� ��� â�� �α����� ��box��
      JLabel box1 = new JLabel();
      JLabel box2 = new JLabel();
      JLabel box3 = new JLabel();
      JLabel box4 = new JLabel();
      JLabel box5 = new JLabel();
      
      box1.setBounds(220, 270, 270, 30);
      box1.setBackground(Color.WHITE);
      box1.setOpaque(true);
      box2.setBounds(220, 330, 270, 30);
      box2.setBackground(Color.WHITE);
      box2.setOpaque(true);
      box3.setBounds(220, 390, 270, 30);
      box3.setBackground(Color.WHITE);
      box3.setOpaque(true);
      box4.setBounds(220, 450, 270, 30);
      box4.setBackground(Color.WHITE);
      box4.setOpaque(true);
      box5.setBounds(220, 510, 270, 30);
      box5.setBackground(Color.WHITE);
      box5.setOpaque(true);
      
      dg.add(box1);
      dg.add(box2);
      dg.add(box3);
      dg.add(box4);
      dg.add(box5);
      
      dg.setComponentZOrder(box1, 0);
      dg.setComponentZOrder(box2, 0);
      dg.setComponentZOrder(box3, 0);
      dg.setComponentZOrder(box4, 0);
      dg.setComponentZOrder(box5, 0);
      
      //box�� �ȿ� �ִ� ȸ����ü ������
      JLabel nickNameT = new JLabel(user.getNickName());
//      nickNameT.setText(tp.getNickName());
      JLabel playCountT = new JLabel(user.getPlaycount() + "�� " + user.getWin() + "�� " + user.getLose() + "��");
      JLabel rankT = new JLabel(user.getRank() + "��");
      JLabel dreamT = new JLabel(user.getDream());
      JLabel emailT = new JLabel(user.getEmail());
      nickNameT.setBounds(220, 270, 270, 20);
      nickNameT.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      playCountT.setBounds(220, 330, 270, 20);
      playCountT.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      rankT.setBounds(220, 390, 270, 20);
      rankT.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      dreamT.setBounds(220, 450, 270, 20);
      dreamT.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      emailT.setBounds(220, 510, 270, 20);
      emailT.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      emailT.setForeground(Color.WHITE);
      
      dg.add(nickNameT);
      dg.add(playCountT);
      dg.add(rankT);
      dg.add(dreamT);
      dg.add(emailT);
      dg.setComponentZOrder(nickNameT, 0);
      dg.setComponentZOrder(playCountT, 0);
      dg.setComponentZOrder(rankT, 0);
      dg.setComponentZOrder(dreamT, 0);
      dg.setComponentZOrder(emailT, 0);
      
      //ȸ���������� �� ����
      JLabel orangeF = new JLabel(new ImageIcon(new ImageIcon("images/��������ư.png").getImage().getScaledInstance(120, 50, 0)), JLabel.CENTER);
      JLabel fixL = new JLabel("ȸ����������", JLabel.CENTER);
      JLabel exitL = new JLabel(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(50, 50, 0)));
      orangeF.setBounds(0, 600, 550, 50);
      fixL.setBounds(0, 600, 550, 50);
      fixL.setFont(new Font("�޸�����ü", Font.BOLD, 20));
      fixL.setForeground(Color.black);
      exitL.setBounds(480, 600, 50, 50);
      
      dg.add(orangeF);
      dg.add(fixL);
      dg.add(exitL);
      
      dg.setComponentZOrder(orangeF, 0);
      dg.setComponentZOrder(fixL, 0);
      dg.setComponentZOrder(exitL, 0);
      
      //�����ư Ŭ����
      exitL.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dg.dispose();
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            exitL.setCursor(new Cursor(Cursor.HAND_CURSOR));
            SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }

      });
      fixL.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            new CY_AskPassword(mf, user);
            //���� �������� �󺧵��� ���ΰ�ħ ���ش�.
            dreamT.setText(user.getDream());
            emailT.setText(user.getEmail());
            imageL.setIcon(new ImageIcon(new ImageIcon(user.getImageLoad()).getImage().getScaledInstance(150, 150, 0)));
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            fixL.setCursor(new Cursor(Cursor.HAND_CURSOR));
            SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }

      });
      
      dg.setVisible(true);
   }
}