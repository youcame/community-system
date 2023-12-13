package community.test;

import community.dao.Passengerdao;
import community.dao.impl.Passengerdaoimpl;

public class ShowPassenger {
	public static void main(String[] args) throws Exception{
		Passengerdao a=new Passengerdaoimpl();
		System.out.println(a.findPassenger());
	}
}
