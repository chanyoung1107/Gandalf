package with_god.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import with_god.run.SB_Run;

public class SB_Music extends Thread{
	//자바 줌 사이트에있는 라이브라리 중 하나
	private Player player;
	//isLoop라는 변수는 곡이 무한반복인지 한 번 재생하고 꺼지는지에 대한 설정
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public SB_Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			//파일 가져오기
			file = new File(SB_Run.class.getResource("/Music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			//player에 해당 파일 담기
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
	//언제 실행되고 있더라고 항상 종료
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			//isLoop값이 true일시 무한 반복
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







