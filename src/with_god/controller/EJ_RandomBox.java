package with_god.controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import with_god.model.vo.User;

public class EJ_RandomBox extends JPanel {
	private JLabel itemlb;
	private int imageSizeW = 220;
	private int imageSizeH = 300;
	private int itemCountD = 0;
	private int itemCountK = 0;
	private int itemCountH = 0;
	//private HashMap<String, Integer> itemhm = new HashMap<String, Integer>();
	
	public EJ_RandomBox(User user) {
		itemCountK = user.getItemCountK();
		itemCountH = user.getItemCountH();
		itemCountD = user.getItemCountD();
	}
	
	public Dialog sd(JFrame mf, User user) {
		
		
		int itemRandom = new Random().nextInt(3);
		
		if(itemRandom == 0) {
			itemlb = new JLabel(new ImageIcon(new ImageIcon("Images/�ؿ���.png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
			user.setItemCountH(user.getItemCountH() + 1);
		//	itemhm.put("�ؿ���", itemCountH);
			

		}else if(itemRandom == 1) {
			itemlb = new JLabel(new ImageIcon(new ImageIcon("Images/����.png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
			user.setItemCountK(user.getItemCountK() + 1);
		//	itemhm.put("����", itemCountK);

		}else {
			itemlb = new JLabel(new ImageIcon(new ImageIcon("Images/����.png").getImage().getScaledInstance(imageSizeW, imageSizeH, 0)));
			user.setItemCountD(user.getItemCountD() + 1);
		//	itemhm.put("����", itemCountD);

		}
		
		itemlb.setBounds(100, 100, 220, 300);
		JLabel jl = new JLabel("�̰� ��������", JLabel.CENTER);
		jl.setBounds(0, 10, 400, 100);
		jl.setForeground(Color.WHITE);
		jl.setFont(new Font("�޸�����ü",Font.BOLD,30));
		
		Dialog sd = new Dialog(mf,"Dialog", true);
		sd.setSize(400,500);
		sd.setLocationRelativeTo(mf);
		sd.setBackground(Color.black);
		sd.setLayout(null);
		sd.add(itemlb);
		sd.add(jl);
		
		JButton button1 = new JButton("Ȯ��");
		button1.setBounds(160,430, 80, 30);
		sd.add(button1);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sd.dispose();
			}
			
		});
		sd.setUndecorated(true);
		return sd;
	}

//	public HashMap<String, Integer> getItemhm() {
//		return itemhm;
//	}
//
//	public void setItemhm(HashMap<String, Integer> itemhm) {
//		this.itemhm = itemhm;
//	}
//	
//	
	
}
