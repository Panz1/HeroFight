package com.skill;

import com.hero.BaseHero;

/**
 * 基础防御技能类
 * 
 * @author Chuck.Dong
 *
 */
public abstract class BaseDefenseSkill extends BaseSkill {
	/**
	 * 发动防御技能
	 * 
	 * @param damage
	 *            防御前伤害值
	 * @param hero
	 *            发动防御技能英雄
	 * @param enemy
	 *            伤害来源
	 * @return 防御后伤害值
	 */
	public abstract float launch(float damage,BaseHero hero,BaseHero enemy);
}
