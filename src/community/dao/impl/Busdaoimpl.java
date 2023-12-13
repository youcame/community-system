package community.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.dao.Busdao;
import community.po.Bus;
import community.po.User;

public class Busdaoimpl implements Busdao{
	public void saveBus(Bus bus) throws Exception {
		List<Bus> list=null;
		FileInputStream fis=new FileInputStream("./src/busrecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List<Bus>)ois.readObject();
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/busrecord.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if(list!=null)list.add(bus);
			else {
				list=new ArrayList<Bus>();
				list.add(bus);
			}
			oos.writeObject(list);
			oos.flush();
		}
		finally {
			fos.close();
		}
	}

	@Override
	public List<Bus> findbus() throws Exception{
		FileInputStream fis;
			fis = new FileInputStream("./src/busrecord.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<Bus> list =new ArrayList<Bus>();
			list=(List)ois.readObject();
			ois.close();
			return list;
	}

	@Override
	public void removeBus(Bus bus) throws Exception {
		List<Bus> list=new ArrayList<Bus>();
		FileInputStream fis=new FileInputStream("./src/busrecord.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(List)ois.readObject();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDaima().equals(bus.getDaima())) {
				list.remove(i);
				break;
			}
		}
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("./src/busrecord.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			fos.close();
			oos.close();
		}catch(Exception e1){
			System.out.printf("错误信息为:"+e1.getMessage());
		}
	}

	@Override
	public void writeBus(List<Bus> list) throws Exception{
		FileOutputStream fos=new FileOutputStream("./src/busrecord.txt");
		ObjectOutputStream ois=new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.flush();
		ois.close();
		fos.close();
		// TODO 自动生成的方法存根
		
	}
}
