package com.skill.defenseskills;

import com.common.CommonUtils;
import com.hero.BaseHero;
import com.skill.BaseDefenseSkill;

/**
 * 技能：闪避
 * 
 * @author Chuck.Dong
 *
 */
public class Evade extends BaseDefenseSkill {
	
	public Evade(){
		this.setSkillName("【闪避】");
		this.setSpecProbability((float) 0.3);
	}

	@Override
	public float launch(float damage,BaseHero hero,BaseHero enemy) {
		float finalDamage=damage;
		if(CommonUtils.isTrigger(this.getSpecProbability())){	//发动技能
			System.out.println(hero.getHeroName()+"发动"+this.getSkillName());
			finalDamage=0;
		}else{	//未发动技能
			System.out.println(hero.getHeroName()+"未发动"+this.getSkillName());
		}
		return finalDamage;
	}

}
