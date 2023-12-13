package community.test;

import community.dao.Servicedao;
import community.dao.impl.Servicedaoimpl;

public class ShowService {
	public static void main(String[] args) throws Exception{
		Servicedao s=new Servicedaoimpl();
		System.out.println(s.findService());
	}
}
