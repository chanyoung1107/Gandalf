/*package with_god.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class godWithStoyChoiceMap extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	// ���ȭ�� ��� ��ü
	private Image background = new ImageIcon(Main.class.getResource("../images/gw.png")).getImage();
	// menuBar��� ��ü�ȿ� �ش��̹����� ��
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//���α׷��ȿ��� ���콺�� x,y�� ��ǥ ��ü�� ��Ÿ��
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	//private ImageIcon StageChoice1 = new ImageIcon(Main.class.getResource("../images/StageChoice1.png"));
	//private JButton sc1 = new JButton(StageChoice1);
	//private ImageIcon StageChoice2 = new ImageIcon(Main.class.getResource("../images/StageChoice2.png"));
	//private JButton sc2 = new JButton(StageChoice2);
	private ImageIcon StageChoice3 = new ImageIcon(Main.class.getResource("../images/StageChoice3.png"));
	private JButton sc3 = new JButton(StageChoice3);
	private ImageIcon StageChoice4 = new ImageIcon(Main.class.getResource("../images/StageChoice4.png"));
	private JButton sc4 = new JButton(StageChoice4);
	private ImageIcon StageChoice5 = new ImageIcon(Main.class.getResource("../images/ch5.png"));
	private JButton sc5 = new JButton(StageChoice5);
	private ImageIcon StageChoice6 = new ImageIcon(Main.class.getResource("../images/ch6.png"));
	private JButton sc6 = new JButton(StageChoice6);
	private ImageIcon StageChoice7 = new ImageIcon(Main.class.getResource("../images/ch7.png"));
	private JButton sc7 = new JButton(StageChoice7);
	private ImageIcon stageChoiceEnteredImage1 = new ImageIcon(Main.class.getResource("../images/StageChoice1.png"));
	private JButton stagechoiceButton1 = new JButton(stageChoiceEnteredImage1);
	private ImageIcon stageChoiceEnteredImage2 = new ImageIcon(Main.class.getResource("../images/StageChoice2.png"));
	private JButton stagechoiceButton2 = new JButton(stageChoiceEnteredImage2);
	private ImageIcon stageChoiceEnteredImage3 = new ImageIcon(Main.class.getResource("../images/StageChoice3.png"));
	private JButton stagechoiceButton3 = new JButton(stageChoiceEnteredImage3);
	private ImageIcon stageChoiceEnteredImage4 = new ImageIcon(Main.class.getResource("../images/StageChoice4.png"));
	private JButton stagechoiceButton4 = new JButton(stageChoiceEnteredImage4);
	private ImageIcon stageChoiceEnteredImage5 = new ImageIcon(Main.class.getResource("../images/ch5.png"));
	private JButton stagechoiceButton5 = new JButton(stageChoiceEnteredImage5);
	private ImageIcon stageChoiceEnteredImage6 = new ImageIcon(Main.class.getResource("../images/ch6.png"));
	private JButton stagechoiceButton6 = new JButton(stageChoiceEnteredImage6);
	private ImageIcon stageChoiceEnteredImage7 = new ImageIcon(Main.class.getResource("../images/ch7.png"));
	private JButton stagechoiceButton7 = new JButton(stageChoiceEnteredImage7);
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/StageChoice1.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonEnteredImage);


	
	private int mouseX, mouseY;
	
	public godWithStoyChoiceMap() {
		setUndecorated(true);
		setTitle("GodWith");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		// null���� �־������ν� �־��� ��ġ������ ����.
		setLayout(null);


		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//�׸��� �ٲ��شٴ� setIcon
				exitButton.setIcon(exitButtonEnteredImage);
				//���콺 �����ٴ�� �հ������
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�ѹ��� �뷡�� ����ǰ� false ���
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
				//������ ����
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			//���콺�� �ش� ��ư�� ���������� �̺�Ʈ ó��
			public void mousePressed(MouseEvent e) {
				//������ ���콺 Ŭ���������� x , y�� ��ǥ�� ���´�.
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//���� ��ũ���� x , y�� ��ǧ�� ������.
				int x = e.getXOnScreen();
				int y = e.getXOnScreen();
				//�巡�׸� �Ҷ� �� �������������� x, y�� ��ǥ�� �����ͼ�
				//�޴��ٸ� �巡�� ������ ����â�� �� ���� ���� ������
				setLocation(x- mouseX, y- mouseY);
			}
		});
		add(menuBar);
		
		stagechoiceButton1.setBounds(210, 500, 150, 120);
		stagechoiceButton1.setBorderPainted(false);
		stagechoiceButton1.setContentAreaFilled(false);
		stagechoiceButton1.setFocusPainted(false);
		stagechoiceButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//�׸��� �ٲ��شٴ� setIcon
				stagechoiceButton1.setIcon(stageChoiceEnteredImage1);
				//���콺 �����ٴ�� �հ������
				stagechoiceButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�ѹ��� �뷡�� ����ǰ� false ���
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(stageChoiceEnteredImage1);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				stagechoiceButton1.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/gwstory.png")).getImage();
			}
		});
		//startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(stagechoiceButton1);
		
		stagechoiceButton2.setBounds(360, 300, 150, 120);
		stagechoiceButton2.setBorderPainted(false);
		stagechoiceButton2.setContentAreaFilled(false);
		stagechoiceButton2.setFocusPainted(false);
		stagechoiceButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//�׸��� �ٲ��شٴ� setIcon
				stagechoiceButton2.setIcon(stageChoiceEnteredImage2);
				//���콺 �����ٴ�� �հ������
				stagechoiceButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�ѹ��� �뷡�� ����ǰ� false ���
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(stageChoiceEnteredImage2);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				stagechoiceButton2.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/gwstory.png")).getImage();
			}
		});
		//startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(stagechoiceButton2);
		
		quitButton.setBounds(360, 300, 150, 120);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//�׸��� �ٲ��شٴ� setIcon
				quitButton.setIcon(quitButtonEnteredImage);
				//���콺 �����ٴ�� �հ������
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�ѹ��� �뷡�� ����ǰ� false ���
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
				//������ ����
				System.exit(0);
			}
		});
		//startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//add(quitButton);
		
		sc1.setBounds(210, 500, 150, 120);
		sc1.setBorderPainted(false);
		sc1.setContentAreaFilled(false);
		sc1.setFocusPainted(false);
		add(sc1);
		
		sc2.setBounds(360, 300, 150, 120);
		sc2.setBorderPainted(false);
		sc2.setContentAreaFilled(false);
		sc2.setFocusPainted(false);
		add(sc2);
		
		sc3.setBounds(510, 500, 150, 120);
		sc3.setBorderPainted(false);
		sc3.setContentAreaFilled(false);
		sc3.setFocusPainted(false);
		add(sc3);
		
		sc4.setBounds(660, 300, 150, 120);
		sc4.setBorderPainted(false);
		sc4.setContentAreaFilled(false);
		sc4.setFocusPainted(false);
		add(sc4);
		
		sc5.setBounds(810, 500, 150, 150);
		sc5.setBorderPainted(false);
		sc5.setContentAreaFilled(false);
		sc5.setFocusPainted(false);
		add(sc5);
		
		sc6.setBounds(960, 300, 150, 150);
		sc6.setBorderPainted(false);
		sc6.setContentAreaFilled(false);
		sc6.setFocusPainted(false);
		add(sc6);
		
		sc7.setBounds(580, 90, 150, 150);
		sc7.setBorderPainted(false);
		sc7.setContentAreaFilled(false);
		sc7.setFocusPainted(false);
		add(sc7);
		
		
		
		Music introMusic = new Music("03. Bruno Mars - Finesse (Remix) feat. Cardi B.mp3", true);
		//introMusic.start();
	}

	public void paint(Graphics g) {
		// 1300 * 800ũ�⸦ screenImage�� �־��ִ��۾�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGTH);
		// screenImage�� �̿��ؼ� �׷��� ��ü�� ����
		screenGraphic = screenImage.getGraphics();
		// screenDraw�� �̸̹� �׷��ִ°�
		screenDraw(screenGraphic);
		// screenImage�� 0,0�� ��ġ�� �׷��ش� / �츮 ����â�� scrrenImage�� ���ԵǴ°�
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		// �������̹��� ���ȭ���� �������� �Ѿ�� �ݸ� ���� �����ٴ� �׽� �����Ͽ���
		// JLabel�ȿ��� paintComponents�� ����Ѵ�.
		paintComponents(g);
		this.repaint();
	}
	
}
*/