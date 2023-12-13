package community.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.dao.Passengerdao;
import community.po.Passenger;

public class Passengerdaoimpl implements Passengerdao{
	public void savePassenger(Passenger a) throws Exception {
		List<Passenger> list=null;
		FileInputStream fis=new FileInputStream("./src/passenger.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List<Passenger>)ois.readObject();
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/passenger.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if(list!=null)list.add(a);
			else {
				list=new ArrayList<Passenger>();
				list.add(a);
			}
			oos.writeObject(list);
			oos.flush();
		}
		finally {
			fos.close();
		}
	}

	@Override
	public List<Passenger> findPassenger() throws Exception{
			FileInputStream fis;
			fis = new FileInputStream("./src/passenger.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<Passenger> list =new ArrayList<Passenger>();
			list=(List)ois.readObject();
			ois.close();
			return list;
	}

	@Override
	public void writePassenger(List<Passenger> list) throws Exception {
		FileOutputStream fos=new FileOutputStream("./src/passenger.txt");
		ObjectOutputStream ois=new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.flush();
		ois.close();
		fos.close();
		// TODO 自动生成的方法存根
	}
}
