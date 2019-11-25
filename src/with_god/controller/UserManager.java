package with_god.controller;

import java.util.ArrayList;

import with_god.model.dao.UserDao;
import with_god.model.vo.User;

public class UserManager {

	private UserDao ud = new UserDao();
	ArrayList<User> list = ud.readUserList();
	
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
	
	public void updatePw(User user) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setPw(user.getPw());
				ud.writeUserList(list);
				break;
			}
		}
		}
	public void updateCoin(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setCoin(user.getCoin());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateNickName(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setNickName(user.getNickName());
				ud.writeUserList(list);
				break;
			}
		}
		
	}
	public void updateEmail(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setEmail(user.getEmail());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateDream(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setDream(user.getDream());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateImageLoad(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setImageLoad(user.getImageLoad());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateScore(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setScore(user.getScore());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateItemK(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setItemCountK(user.getItemCountK());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateItemD(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setItemCountD(user.getItemCountD());
				ud.writeUserList(list);
				break;
			}
		}
	}
	public void updateItemH(User user) {

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(user.getId())) {
				list.get(i).setItemCountH(user.getItemCountH());
				ud.writeUserList(list);
				break;
			}
		}
	}
}


















