package with_god.view; //with_god.vo; d에요 


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.model.vo.SY_itemHaewonmac;

public class SY_inGamePanel extends JPanel{ // 게임중인 패널 
	 //-유저가 보유한 아이템 출력. - 아이템 사용시 효과 발동 후 아이템 개수 줄어듦
     //인게임패널(extends 프레임) 깔고 
     // 내가 보유한 아이템(라벨)들이 보이게 해놈 (인게임중패널안에서)
	 //사용하면 효과발동, 아이템 개수는 줄어듬 
	
	private JFrame jf;
	private JPanel jp = this;
	
	public SY_inGamePanel() {}
	
	public SY_inGamePanel(JFrame jf) {
		this.jf = jf;
		
		this.setLayout(null); // x,y 좌표값 지정할 수 있음 
		this.setSize(1300,800);
		
		jf.add(this);
		
		JLabel backJl = new JLabel(new ImageIcon(new ImageIcon("src/image/gamebackGround.jpg").getImage().getScaledInstance(1300, 800, 0)));
		backJl.setBounds(0, 0, 1300, 800);
		JLabel haewonmac = new JLabel(new ImageIcon(new ImageIcon("images/해원맥.png").getImage().getScaledInstance(100, 100, 0)));
		JLabel gangrim = new JLabel(new ImageIcon(new ImageIcon("images/강림.png").getImage().getScaledInstance(100,100, 0)));
		JLabel duckchun = new JLabel(new ImageIcon(new ImageIcon("images/덕춘.png").getImage().getScaledInstance(100,100, 0)));
		haewonmac.setBounds(1140, 200, 100, 100);
		gangrim.setBounds(1000, 200, 100, 100);
		duckchun.setBounds(840, 200, 100, 100);
		
		jp.add(haewonmac);
		jp.add(gangrim);
		jp.add(duckchun);
		jp.add(backJl);
		
		
		haewonmac.addMouseListener(new MouseAdapter() {
		

			@Override
			public void mouseClicked(MouseEvent e) {
				SY_itemHaewonmac h = new SY_itemHaewonmac();
				//boolean haewonmacskill = h.timeStop();// haewonmacskill에 true값 담겨짐.
			}
	    });
		
		
		
		
		
	/*	
		gangrim.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				SY_itemGangrim g = new SY_itemGangrim();
				boolean gangrim = g.GangrimRandom();
			}
	    });
		
		
		duckchun.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				SY_itemDuckchun d = new SY_itemDuckchun();
				boolean haewonmacskill = d.DuckchunRandom();
			}
	    });
		*/
		
        //this.setVisible(true);
       //panel.setComponentZOrder(jl, 1); //라벨 앞쪾에 보이는 순서 
		
		
		
     
	}
	
	

}
