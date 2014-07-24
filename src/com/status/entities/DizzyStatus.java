package com.status.entities;

import java.util.Date;

import com.status.BaseStatus;
import com.status.StatusEffectContant;

/**
 * 状态：晕眩
 * 
 * @author Chuck.Dong
 * 
 */
public class DizzyStatus extends BaseStatus {
	public DizzyStatus(long statusLong){
		long statusStart=new Date().getTime();
		this.setStatusName("【晕眩】");	//设置状态名
		this.setStatusStart(statusStart);	//设置状态开始时间
		this.setStatusLong(statusLong);	//设置状态持续时间，-1表示持续无限时长
		this.setStatusEnd(statusStart+statusLong);	//设置状态结束时间
		this.setStatusEffect(StatusEffectContant.DONOTHING);	//设置状态效果
	}
}
