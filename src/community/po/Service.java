package community.po;

import java.io.Serializable;

public class Service implements Serializable{
	private User livemanager;
	private User oldpeople;
	@Override
	public String toString() {
		return "Service [livemanager=" + livemanager + ", oldpeople=" + oldpeople + "]";
	}
	public User getLivemanager() {
		return livemanager;
	}
	public void setLivemanager(User livemanager) {
		this.livemanager = livemanager;
	}
	public User getOldpeople() {
		return oldpeople;
	}
	public void setOldpeople(User oldpeople) {
		this.oldpeople = oldpeople;
	}
}
