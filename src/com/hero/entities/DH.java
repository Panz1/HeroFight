package com.hero.entities;

import com.hero.BaseHero;
import com.skill.BaseAttackSkill;
import com.skill.BaseDefenseSkill;
import com.skill.attackskills.Bloodsucking;
import com.skill.defenseskills.Evade;
import com.status.entities.NormalStatus;

/**
 * 英雄：DH
 * 
 * @author Chuck.Dong
 *
 */
public class DH extends BaseHero {
	
	public DH(String name){
		this.setHeroName(name+"(DH)");		//设置英雄名称
		this.setMaxHP(600);					//设置最大生命值
		this.setCurrentHP(this.getMaxHP());	//设置当前生命值
		this.setAttack(30);					//设置攻击力
		this.setAttackTime(1000);			//设置攻击时间
		BaseAttackSkill attackSkill=new Bloodsucking();
		this.setAttackSkill(attackSkill);	//设置攻击技能
		BaseDefenseSkill defenseSkill=new Evade();
		this.setDefenseSkill(defenseSkill);	//设置防御技能
		this.setStatus(new NormalStatus());		//设置状态
	}

}
