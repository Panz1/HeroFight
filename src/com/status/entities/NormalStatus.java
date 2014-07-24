package com.status.entities;

import java.util.Date;

import com.status.BaseStatus;
import com.status.StatusEffectContant;

/**
 * 状态：正常
 * 
 * @author Chuck.Dong
 * 
 */
public class NormalStatus extends BaseStatus {
	public NormalStatus(){	//正常状态默认持续无限时长
		this.setStatusName("【正常】");	//设置状态名
		this.setStatusStart(new Date().getTime());	//设置状态开始时间
		this.setStatusLong(-1);			//设置状态持续时间，-1表示持续无限时长
		this.setStatusEffect(StatusEffectContant.NORMAL);	//设置状态效果
	}
}
