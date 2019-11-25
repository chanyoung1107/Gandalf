package with_god.controller;

import java.util.ArrayList;

import with_god.model.dao.UserDao;
import with_god.model.vo.User;

public class YJ_UserManager {

	private UserDao ud = new UserDao();
	
	public void insertUser(User u) {
		//���Ͽ� ��ϵ� ����Ʈ��ȸ
		ArrayList<User> list = ud.readUserList();
		//��ȸ������ �ִ��� Ȯ��
		if(list == null) {
			list = new ArrayList<User>();
			System.out.println(list);
		}
		//����Ʈ�� user��ü �߰�
		list.add(u);
		System.out.println(list);
		//����Ʈ�� ���Ͽ� ��� �� ����� ������ ����
		int result = ud.writeUserList(list);
		//���� ���п��ο� ���� �� ������ ����
		if(result > 0) {
			System.out.println("��ϼ���");
		}else {
			System.out.println("��Ͽ���");
		}
		
	}
}


















