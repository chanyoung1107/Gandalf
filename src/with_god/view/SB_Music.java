package with_god.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import with_god.run.SB_Run;

public class SB_Music extends Thread{
	//�ڹ� �� ����Ʈ���ִ� ���̺�� �� �ϳ�
	private Player player;
	//isLoop��� ������ ���� ���ѹݺ����� �� �� ����ϰ� ���������� ���� ����
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public SB_Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			//���� ��������
			file = new File(SB_Run.class.getResource("/Music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			//player�� �ش� ���� ���
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public int getTime() {
		if (player == null) 
			return 0;
		return player.getPosition();
	}
	//���� ����ǰ� �ִ���� �׻� ����
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			//isLoop���� true�Ͻ� ���� �ݺ�
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while (isLoop);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}







