package community.po;

import java.io.Serializable;

public class Passenger implements Serializable{
	private String name;
	private String tele;
	private String BusDai;
	private String sex;
	public String getBusDai() {
		return BusDai;
	}
	public void setBusDai(String busDai) {
		BusDai = busDai;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", tele=" + tele + ", BusDai=" + BusDai + ", sex=" + sex + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
