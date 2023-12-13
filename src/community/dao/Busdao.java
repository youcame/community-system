package community.dao;

import java.util.List;

import community.po.Bus;
import community.po.User;

public interface Busdao {
	public void saveBus(Bus bus) throws Exception;
	public List<Bus> findbus() throws Exception;
	public void removeBus(Bus bus) throws Exception;
	public void writeBus(List<Bus> list) throws Exception;
}
