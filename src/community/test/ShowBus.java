package community.test;

import java.util.List;

import community.dao.Busdao;
import community.dao.impl.Busdaoimpl;
import community.po.Bus;

public class ShowBus {
	public static void main(String args[]) throws Exception{
		Busdao busdao=new Busdaoimpl();
		List<Bus> busList=busdao.findbus();
		System.out.println(busList);
	}
}
