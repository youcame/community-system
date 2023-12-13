package community.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import community.po.Bus;

public class AddBusTest {
	public static void main(String args[]) throws Exception{
		List<Bus> list=new ArrayList<Bus>();
		Bus bus=new Bus();
		bus.setDaima("123");
		bus.setDate("每天");
		bus.setDate1("下午");
		bus.setDate2("8:00");
		bus.setDirection("上行");
		bus.setName("202");
		bus.setEndtime("未确定");
		bus.setNum("1");
		bus.setType("岛内班车");
		bus.setType(null);
		list.add(bus);
		FileOutputStream fos=new FileOutputStream("./src/busrecord.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
	}
}
