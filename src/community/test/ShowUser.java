package community.test;

import java.util.List;

import community.dao.Userdao;
import community.dao.impl.Userdaoimpl;
import community.po.User;

public class ShowUser{
	public static void main(String[] args) throws Exception {
		Userdao userdao=new Userdaoimpl();
		List<User> userList=userdao.findUser();
		System.out.println(userList);
	}
}
