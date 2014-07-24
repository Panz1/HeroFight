package com.skill.attackskills;

import com.common.CommonUtils;
import com.hero.BaseHero;
import com.skill.BaseAttackSkill;
import com.status.entities.DizzyStatus;

/**
 * 技能：重击
 * 
 * @author Chuck.Dong
 *
 */
public class Thump extends BaseAttackSkill {
	
	public Thump(){
		this.setSkillName("【重击】");
		this.setSpecProbability((float) 0.3);
	}

	@Override
	public void launch(BaseHero hero,BaseHero destination) {
		float damage=hero.getAttack();
		if(CommonUtils.isTrigger(this.getSpecProbability())){	//发动技能
			System.out.println(hero.getHeroName()+"发动"+this.getSkillName());
			damage=destination.hert(damage, hero);
			if(damage!=0){	//伤害不为0表示攻击到对方
				destination.setStatus(new DizzyStatus(3000L)); // 设置被攻击方为晕眩状态
				System.out.println(destination.getHeroName() + "晕眩3秒");
			}
		}else{	//未发动技能
			System.out.println(hero.getHeroName()+"未发动"+this.getSkillName());
			destination.hert(damage, hero);
		}
	}

}
