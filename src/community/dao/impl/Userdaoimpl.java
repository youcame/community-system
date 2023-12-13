package community.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.dao.Userdao;
import community.po.Bus;
import community.po.User;

public class Userdaoimpl implements Userdao{
	
	@Override
	public void saveUser(User user) throws Exception {
		List<User> list=null;
		FileInputStream fis=new FileInputStream("./src/userrecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List<User>)ois.readObject();
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/userrecord.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if(list!=null)list.add(user);
			else {
				list=new ArrayList<User>();
				list.add(user);
			}
			oos.writeObject(list);
			oos.flush();
		}
		finally {
			fos.close();
		}
	}

	@Override
	public List<User> findUser() throws Exception {
		FileInputStream fis=new FileInputStream("./src/userrecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		List<User> list =new ArrayList<User>();
		list=(List)ois.readObject();
		ois.close();
		return list;
	}

	@Override
	public void removeUser(User user) throws Exception {
		List<User> list=new ArrayList<User>();
		FileInputStream fis=new FileInputStream("./src/userrecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List<User>)ois.readObject();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getZhanghao().equals(user.getZhanghao())) {
				list.remove(i);
				break;
			}
		}
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/userrecord.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			fos.close();
			oos.close();
		}catch(Exception e1){
			System.out.printf("错误信息为:"+e1.getMessage());
		}
	}

	@Override
	public void writeUser(List<User> list) throws Exception {
		FileOutputStream fos=new FileOutputStream("./src/userrecord.txt");
		ObjectOutputStream ois=new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.flush();
		ois.close();
		fos.close();
	}

	
	
}
