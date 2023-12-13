package community.po;

import java.io.Serializable;

public class User implements Serializable{
	
	private String id;
	private String zhanghao;
	private String name;
	private String sex;
	private String birth;
	private String mima;
	private String tele;
	private String quanxian;
	@Override
	public String toString() {
		return "User [id=" + id + ", zhanghao=" + zhanghao + ", name=" + name + ", sex=" + sex + ", birth=" + birth
				+ ", mima=" + mima + ", tele=" + tele + ", quanxian=" + quanxian + "]\n";
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

	
	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
