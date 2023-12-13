package community.dao;

import java.util.List;

import community.po.User;

public interface Userdao {
	public void saveUser(User user) throws Exception;
	public List<User> findUser() throws Exception;
	public void removeUser(User user) throws Exception;
	public void writeUser(List<User> list) throws Exception;
}
