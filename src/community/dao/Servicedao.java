package community.dao;


import java.util.List;

import community.po.Passenger;
import community.po.Service;

public interface Servicedao {
	public void saveService(Service service) throws Exception;
	public List<Service> findService() throws Exception;
	public void writeService(List<Service> list) throws Exception;
}
