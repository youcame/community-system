package community.dao;

import java.util.List;

import community.po.Passenger;

public interface Passengerdao {
	public void savePassenger(Passenger a) throws Exception;
	public List<Passenger> findPassenger() throws Exception;
	public void writePassenger(List<Passenger> list) throws Exception;
}
