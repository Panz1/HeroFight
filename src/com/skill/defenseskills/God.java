package com.skill.defenseskills;

import com.common.CommonUtils;
import com.hero.BaseHero;
import com.skill.BaseDefenseSkill;

/**
 * 技能：天神
 * 
 * @author Chuck.Dong
 *
 */
public class God extends BaseDefenseSkill {
	
	public God(){
		this.setSkillName("【天神】");
		this.setSpecProbability((float) 0.6);
	}

	@Override
	public float launch(float damage,BaseHero hero,BaseHero enemy) {
		float finalDamage=damage;
		if(CommonUtils.isTrigger(this.getSpecProbability())){	//发动技能
			System.out.println(hero.getHeroName()+"发动"+this.getSkillName());
			finalDamage=damage/2;
		}else{	//未发动技能
			System.out.println(hero.getHeroName()+"未发动"+this.getSkillName());
		}
		return finalDamage;
	}

}
