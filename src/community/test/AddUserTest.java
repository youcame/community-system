package community.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.po.User;

public class AddUserTest {
	public static void main(String args[]) throws Exception{
		List<User> list1=new ArrayList<User>();
		User user=new User();
		user.setId("1");
		user.setName("Huang");
		user.setZhanghao("20216645");
		user.setMima("20216645");
		user.setSex("男");
		user.setQuanxian("管理员");
		user.setTele("10086");
		user.setBirth("2003-03-03");
		list1.add(user);
		User user1=new User();
		user1.setId("2");
		user1.setName("Xu");
		user1.setZhanghao("10000000");
		user1.setMima("10000000");
		user1.setSex("男");
		user1.setQuanxian("生活管家");
		user1.setTele("10086");
		user1.setBirth("2002-02-02");
		list1.add(user1);
		User user2=new User();
		user2.setId("3");
		user2.setName("Liu");
		user2.setZhanghao("20000000");
		user2.setMima("20000000");
		user2.setSex("男");
		user2.setQuanxian("后勤管家");
		user2.setTele("10086");
		user2.setBirth("2001-01-01");
		list1.add(user2);
		User user3=new User();
		user3.setId("4");
		user3.setName("Tang");
		user3.setZhanghao("30000000");
		user3.setMima("30000000");
		user3.setSex("男");
		user3.setQuanxian("顾客");
		user3.setTele("10086");
		user3.setBirth("2001-01-01");
		list1.add(user3);
		FileOutputStream fos=new FileOutputStream("./src/userrecord.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list1);
		oos.flush();
	}
}
