package community.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.po.Service;
import community.po.User;

public class AddServiceTest {
	public static void main(String args[]) throws Exception{
		User user1=new User();
		user1.setId("2");
		user1.setName("Xu");
		user1.setZhanghao("10000000");
		user1.setMima("10000000");
		user1.setSex("男");
		user1.setQuanxian("生活管家");
		user1.setTele("10086");
		user1.setBirth("2002-02-02");
		User user3=new User();
		user3.setId("4");
		user3.setName("Tang");
		user3.setZhanghao("30000000");
		user3.setMima("30000000");
		user3.setSex("男");
		user3.setQuanxian("顾客");
		user3.setTele("10086");
		user3.setBirth("2001-01-01");
		Service service=new Service();
		service.setLivemanager(user1);
		service.setOldpeople(user3);
		List<Service> list=new ArrayList<Service>();
		list.add(service);
		FileOutputStream fos=new FileOutputStream("./src/servicerecord.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		
	}
}
