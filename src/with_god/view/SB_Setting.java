package with_god.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SB_Setting extends JPanel {
	
	private JFrame mf;
	private JPanel jp = this;
	//private boolean startMusic = true;
	public static SB_Music introMusic = new SB_Music("bgm.mp3", true);
	
	public SB_Setting() {}
	
	
	public SB_Setting (JFrame mf) {
		this.mf = mf;
		mf.add(this);
		this.setLayout(null);
		//introMusic.start();
		Image background = new ImageIcon("images/gw.png").getImage().getScaledInstance(1300, 800, 0);
		Image setting = new ImageIcon("images/Setting.png").getImage().getScaledInstance(50, 50, 0);

		JLabel ground = new JLabel(new ImageIcon(background));
		JLabel settingg = new JLabel(new ImageIcon(setting));
		
		//SB_Music introMusic = new SB_Music("bgm.mp3", true);
		//introMusic.start();
		/*if(startMusic == true) {
			introMusic.start();
		}else if(startMusic == false){
			introMusic.close();
		}*/

		ground.setSize(1300, 800);
		settingg.setBounds(1120, 50, 50, 50);
		
		this.add(ground);
		this.add(settingg);
		this.setComponentZOrder(ground, 1);
		
		settingg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SB_SettingPage(mf);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				settingg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				SB_Music buttonEnteredMusic = new SB_Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
	}

	/*public boolean isStartMusic() {
		return startMusic;
	}

	public void setStartMusic(boolean startMusic) {
		this.startMusic = startMusic;
		
	}*/
	public void startMusic() {
		introMusic.start();
	}
	public void closeMusic() {
		introMusic.close();
	}
	
}
