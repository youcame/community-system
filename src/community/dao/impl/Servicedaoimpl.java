package community.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.dao.Servicedao;
import community.po.Bus;
import community.po.Service;

public class Servicedaoimpl implements Servicedao{

	@Override
	public void saveService(Service service) throws Exception{
		List<Service> list=null;
		FileInputStream fis=new FileInputStream("./src/servicerecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List<Service>)ois.readObject();
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/servicerecord.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if(list!=null)list.add(service);
			else {
				list=new ArrayList<Service>();
				list.add(service);
			}
			oos.writeObject(list);
			oos.flush();
		}
		finally {
			fos.close();
		}
	}

	@Override
	public List<Service> findService() throws Exception{
		FileInputStream fis;
		fis = new FileInputStream("./src/servicerecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		List<Service> list =new ArrayList<Service>();
		list=(List)ois.readObject();
		ois.close();
		return list;
	}

	@Override
	public void writeService(List<Service> list) throws Exception {
		FileOutputStream fos=new FileOutputStream("./src/servicerecord.txt");
		ObjectOutputStream ois=new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.flush();
		ois.close();
		fos.close();
		// TODO 自动生成的方法存根
		
	}

}
