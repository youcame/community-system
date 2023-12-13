package community.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.po.Bus;
import community.po.Passenger;

public class AddpassengerTest {
	public static void main(String[] args) throws Exception{
		List<Passenger> list=new ArrayList<Passenger>();
		Passenger a=new Passenger();
		a.setBusDai("123");
		a.setName("zhao");
		a.setSex("男");
		a.setTele("10088");
		list.add(a);
		FileOutputStream fos=new FileOutputStream("./src/Passenger.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
	}
}
