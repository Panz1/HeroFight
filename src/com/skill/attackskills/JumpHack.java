package com.skill.attackskills;

import com.common.CommonUtils;
import com.hero.BaseHero;
import com.skill.BaseAttackSkill;

/**
 * 技能：跳劈
 * 
 * @author Chuck.Dong
 *
 */
public class JumpHack extends BaseAttackSkill {
	
	public JumpHack(){
		this.setSkillName("【跳劈】");
		this.setSpecProbability((float) 0.3);
	}

	@Override
	public void launch(BaseHero hero,BaseHero destination) {
		float damage=hero.getAttack();
		if(CommonUtils.isTrigger(this.getSpecProbability())){	//发动技能
			System.out.println(hero.getHeroName()+"发动"+this.getSkillName());
			damage=damage*2;
		}else{	//未发动技能
			System.out.println(hero.getHeroName()+"未发动"+this.getSkillName());
		}
		destination.hert(damage, hero);
	}

}
