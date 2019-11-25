package with_god.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import with_god.model.vo.User;

public class UserDao {

	public UserDao() {}
	
	public ArrayList<User> readUserList() {
		
		//초기값을 지정해야 한다.
		ObjectInputStream ois = null;
		ArrayList<User> list = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.dat"));
			
				list = (ArrayList <User>)ois.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public int writeUserList(ArrayList<User> list) {
		
		ObjectOutputStream oos = null;
		
		int result = 0;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.dat"));
			oos.writeObject(list);
			
			result++;
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}













