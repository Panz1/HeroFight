package com.status;


/**
 * 基础状态类
 * 
 * @author Chuck.Dong
 * 
 */
public class BaseStatus {
	//状态名
	private String statusName;
	//状态开始时间
	private long statusStart;
	//状态持续时长
	private long statusLong;
	//状态结束时间
	private long statusEnd;
	//状态效果
	private int statusEffect;
	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public long getStatusStart() {
		return statusStart;
	}
	public void setStatusStart(long l) {
		this.statusStart = l;
	}
	public long getStatusLong() {
		return statusLong;
	}
	public void setStatusLong(long statusLong) {
		this.statusLong = statusLong;
	}
	public long getStatusEnd() {
		return statusEnd;
	}
	public void setStatusEnd(long statusEnd) {
		this.statusEnd = statusEnd;
	}
	public int getStatusEffect() {
		return statusEffect;
	}
	public void setStatusEffect(int statusEffect) {
		this.statusEffect = statusEffect;
	}
}
