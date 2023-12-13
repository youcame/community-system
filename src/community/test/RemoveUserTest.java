package community.test;

import community.dao.Busdao;
import community.dao.Userdao;
import community.dao.impl.Busdaoimpl;
import community.dao.impl.Userdaoimpl;
import community.po.User;

public class RemoveUserTest {
	public static void main(String[] args) throws Exception {
		Userdao userdao=new Userdaoimpl();
		User user=new User();
		//id=无, zhanghao=40000000, name=HAHAHA, sex=女, birth=2001-01-01, mima=40000000, tele=10085, quanxian=顾客
		user.setId("无");
		user.setBirth("2001-01-01");
		user.setZhanghao("40000000");
		user.setSex("女");
		user.setMima("40000000");
		user.setTele("10085");
		user.setQuanxian("顾客");
		user.setName("HAHAHA");
		userdao.removeUser(user);
	}
}
