package with_god.controller;

import java.util.ArrayList;

import with_god.model.dao.UserDao;
import with_god.model.vo.User;

public class YJ_UserManager {

	private UserDao ud = new UserDao();
	
	public void insertUser(User u) {
		//파일에 기록된 리스트조회
		ArrayList<User> list = ud.readUserList();
		//조회내역이 있는지 확인
		if(list == null) {
			list = new ArrayList<User>();
			System.out.println(list);
		}
		//리스트에 user객체 추가
		list.add(u);
		System.out.println(list);
		//리스트를 파일에 기록 후 결과값 정수로 리턴
		int result = ud.writeUserList(list);
		//성공 실패여부에 따라 뷰 페이지 결정
		if(result > 0) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록에러");
		}
		
	}
}


















