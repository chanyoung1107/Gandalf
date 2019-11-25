package with_god.controller;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import with_god.model.vo.User;

public class CY_ChooseDirectory {

	public CY_ChooseDirectory(User tp) {
	
		//파일선택 객체 생성
		JFileChooser chooser = new JFileChooser();
		//파일경로를 가져옴
		int ret = chooser.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			//선택 안했을시에 에러창 열어준다.
			JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			//리턴을 써야 console 창에 에러가 안뜸.
			return;
		}
		
		//절대경로 받아옴
		String filePath = chooser.getSelectedFile().getPath();
		System.out.println(filePath);
		
		//이미지를 회원객체에 넣어줌
		tp.setImageLoad(filePath);
	}
}

