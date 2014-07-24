package com.hero.entities;

import com.hero.BaseHero;
import com.skill.BaseAttackSkill;
import com.skill.BaseDefenseSkill;
import com.skill.attackskills.JumpHack;
import com.skill.defenseskills.Rebound;
import com.status.entities.NormalStatus;

/**
 * 英雄：BM
 * 
 * @author Chuck.Dong
 *
 */
public class BM extends BaseHero {
	
	public BM(String name){
		this.setHeroName(name+"(BM)");		//设置英雄名称
		this.setMaxHP(650);					//设置最大生命值
		this.setCurrentHP(this.getMaxHP());	//设置当前生命值
		this.setAttack(40);					//设置攻击力
		this.setAttackTime(1500);			//设置攻击时间
		BaseAttackSkill attackSkill=new JumpHack();	
		this.setAttackSkill(attackSkill);	//设置攻击技能
		BaseDefenseSkill defenseSkill=new Rebound();
		this.setDefenseSkill(defenseSkill);	//设置防御技能
		this.setStatus(new NormalStatus());		//设置状态
	}

}
