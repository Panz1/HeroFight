package com.skill;


/**
 * 基础技能类
 * 
 * @author Chuck.Dong
 *
 */
public class BaseSkill {
	//技能名称
	private String skillName;
	//技能特效触发几率
	private float specProbability;	

	protected String getSkillName() {
		return skillName;
	}

	protected void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	protected float getSpecProbability() {
		return specProbability;
	}

	protected void setSpecProbability(float specProbability) {
		this.specProbability = specProbability;
	}
}
