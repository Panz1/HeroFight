package com.hero.entities;

import com.hero.BaseHero;
import com.skill.BaseAttackSkill;
import com.skill.BaseDefenseSkill;
import com.skill.attackskills.Thump;
import com.skill.defenseskills.God;
import com.status.entities.NormalStatus;

/**
 * 英雄：MK
 * 
 * @author Chuck.Dong
 *
 */
public class MK extends BaseHero {
	
	public MK(String name){
		this.setHeroName(name+"(MK)");		//设置英雄名称
		this.setMaxHP(700);					//设置最大生命值
		this.setCurrentHP(this.getMaxHP());	//设置当前生命值
		this.setAttack(50);					//设置攻击力
		this.setAttackTime(2500);			//设置攻击时间
		BaseAttackSkill attackSkill=new Thump();	
		this.setAttackSkill(attackSkill);	//设置攻击技能
		BaseDefenseSkill defenseSkill=new God();
		this.setDefenseSkill(defenseSkill);	//设置防御技能
		this.setStatus(new NormalStatus());		//设置状态
	}
	
}
