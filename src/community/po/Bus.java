package community.po;

import java.io.Serializable;
import java.util.List;

public class Bus implements Serializable{
	private String daima;
	private String name;
	private String direction;
	private String date;
	private String date1;
	private String date2;
	private String endtime;
	private String num;
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDaima() {
		return daima;
	}
	public void setDaima(String daima) {
		this.daima = daima;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Bus [daima=" + daima + ", name=" + name + ", direction=" + direction + ", date=" + date + ", date1="
				+ date1 + ", date2=" + date2 + ", endtime=" + endtime + ", num=" + num + ", type=" + type + "]";
	}
}
