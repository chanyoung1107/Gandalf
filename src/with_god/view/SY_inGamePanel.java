package with_god.view; //with_god.vo; d���� 


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.model.vo.SY_itemHaewonmac;

public class SY_inGamePanel extends JPanel{ // �������� �г� 
	 //-������ ������ ������ ���. - ������ ���� ȿ�� �ߵ� �� ������ ���� �پ��
     //�ΰ����г�(extends ������) ��� 
     // ���� ������ ������(��)���� ���̰� �س� (�ΰ������гξȿ���)
	 //����ϸ� ȿ���ߵ�, ������ ������ �پ�� 
	
	private JFrame jf;
	private JPanel jp = this;
	
	public SY_inGamePanel() {}
	
	public SY_inGamePanel(JFrame jf) {
		this.jf = jf;
		
		this.setLayout(null); // x,y ��ǥ�� ������ �� ���� 
		this.setSize(1300,800);
		
		jf.add(this);
		
		JLabel backJl = new JLabel(new ImageIcon(new ImageIcon("src/image/gamebackGround.jpg").getImage().getScaledInstance(1300, 800, 0)));
		backJl.setBounds(0, 0, 1300, 800);
		JLabel haewonmac = new JLabel(new ImageIcon(new ImageIcon("images/�ؿ���.png").getImage().getScaledInstance(100, 100, 0)));
		JLabel gangrim = new JLabel(new ImageIcon(new ImageIcon("images/����.png").getImage().getScaledInstance(100,100, 0)));
		JLabel duckchun = new JLabel(new ImageIcon(new ImageIcon("images/����.png").getImage().getScaledInstance(100,100, 0)));
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
				//boolean haewonmacskill = h.timeStop();// haewonmacskill�� true�� �����.
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
       //panel.setComponentZOrder(jl, 1); //�� �զU�� ���̴� ���� 
		
		
		
     
	}
	
	

}
