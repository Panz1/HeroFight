package com.skill;

import com.hero.BaseHero;

/**
 * 基础攻击技能类
 * 
 * @author Chuck.Dong
 *
 */
public abstract class BaseAttackSkill extends BaseSkill {
	/**
	 * 发动攻击技能
	 * 
	 * @param hero
	 *            发动技能英雄
	 * @param destination
	 *            攻击目标
	 */
	public abstract void launch(BaseHero hero,BaseHero destination);
}
