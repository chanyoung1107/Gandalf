package with_god.view;

import javax.swing.JFrame;

public class YJ_FirstMainFrame extends JFrame{
   
   public YJ_FirstMainFrame() {
      this.setBounds(350, 100, 1300, 800);
      new LogInPage(this);
      this.setTitle("로그인화면");
      this.setResizable(false);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);

   }

}