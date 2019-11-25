package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import with_god.controller.ChangePanel;
import with_god.model.dao.UserDao;
import with_god.model.vo.User;
import with_god.run.YJ_Run;

public class LogInPage extends JPanel {
	private int mouseX, mouseY;
	private JFrame mf;
	private JPanel jp;
	//파일 불러오기
	private UserDao ud = new UserDao();
	//파일에 있는 모든객체 담아와서 list에 추가
	private ArrayList<User> list = ud.readUserList();
	//아이디확인을 위한  
	boolean b = false;
	//패스워드 확인을 위한
	boolean c = false;

	public LogInPage(JFrame mf) {
		this.mf = mf;
		jp = this;
		mf.add(this);
		this.setSize(1300, 800);
		this.setLayout(null);


		ImageIcon button1 = new ImageIcon(YJ_Run.class.getResource("../../image/button1.png"));
		ImageIcon button2 = new ImageIcon(YJ_Run.class.getResource("../../image/button2.png"));
		ImageIcon button3 = new ImageIcon(YJ_Run.class.getResource("../../image/button3.png"));
		ImageIcon button4 = new ImageIcon(YJ_Run.class.getResource("../../image/button4.png"));
		ImageIcon login = new ImageIcon(YJ_Run.class.getResource("../../image/login.png"));
		ImageIcon login1 = new ImageIcon(YJ_Run.class.getResource("../../image/login1.png"));
		JLabel Signup = new JLabel(button1);
		JLabel Find = new JLabel(button2);
		JLabel loginbutton = new JLabel(login);
		Image introgamebackground = new ImageIcon("images/ground.gif").getImage().getScaledInstance(1300, 800, 0);
		JLabel menubar = new JLabel(new ImageIcon(YJ_Run.class.getResource("../../image/menubar.png")));
		JLabel introgamebackgroundl = new JLabel(new ImageIcon(introgamebackground));


		JLabel lb = new JLabel("ID");
		lb.setLocation(400, 410);
		lb.setSize(150, 150);
		lb.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		lb.setForeground(Color.WHITE);
		this.add(lb);

		JLabel pw = new JLabel("PW");
		pw.setLocation(400, 480);
		pw.setSize(150, 150);
		pw.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		pw.setForeground(Color.WHITE);
		this.add(pw);

		JTextField tf1 = new JTextField();
		tf1.setLocation(480, 470);
		tf1.setSize(350, 30);
		this.add(tf1);

		JPasswordField tf2 = new JPasswordField();
		tf2.setEchoChar('*');
		tf2.setLocation(480, 540);
		tf2.setSize(350, 30);
		this.add(tf2);

		loginbutton.setBounds(850, 450, 150, 150);
		loginbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jp.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				loginbutton.setIcon(login1);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginbutton.setIcon(login);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String pw1 = "";
				for(char ch1 : tf2.getPassword()) {
					Character.toString(ch1);
					pw1 += ch1;
				}

				for(int i = 0; i < list.size(); i++) {
					if(tf1.getText().equals(list.get(i).getId())) {
						System.out.println("일치한다" + list.get(i).getId());
						System.out.println("일치한다" + tf1); 
						if(pw1.equals(list.get(i).getPw())) {
							ChangePanel.changePanel(mf, jp, new MainPage(mf, list.get(i)));
							break;
						}else {
							JOptionPane.showMessageDialog(mf, "정보가 일치하지 않습니다.", "x", JOptionPane.ERROR_MESSAGE);
							tf1.setText("");
							tf2.setText("");
							tf1.requestFocus();
							break;
						}
					}else {
						JOptionPane.showMessageDialog(mf, "정보가 일치하지 않습니다.", "x", JOptionPane.ERROR_MESSAGE);
						tf1.setText("");
						tf2.setText("");
						tf1.requestFocus();
						System.out.println("불일치");
					}
				}
			}     
		});
		this.add(loginbutton);

		Signup.setBounds(400, 600, 200, 30);
		//		Signup.setBorderPainted(false);
		//		Signup.setContentAreaFilled(false);
		//		Signup.setFocusPainted(false);
		Signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jp.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				Signup.setIcon(button3);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Signup.setIcon(button1);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new YJ_UsingTerms(mf);
			}
		});
		this.add(Signup);

		Find.setBounds(630, 600, 200, 30);
		//		Find.setBorderPainted(false);
		//		Find.setContentAreaFilled(false);
		//		Find.setFocusPainted(false);
		Find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Find.setIcon(button4);
				jp.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Find.setIcon(button2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new YJ_FindPage(mf);
			}
		});
		this.add(Find);

		menubar.setBounds(0, 0, 1300, 30);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		introgamebackgroundl.setSize(1300, 800);
		this.add(introgamebackgroundl);

		// Music introMusic = new Music("introMusic.mp3", true);
		// introMusic.start();


	}

}