package com.common;

import com.hero.BaseHero;

/**
 * 通用方法类
 * 
 * @author Chuck
 * 
 */
public class CommonUtils {
	
	/**
	 * 判断是否触发技能
	 * 
	 * @param specProbability
	 *            技能触发几率
	 * @return true:触发；false：不触发；
	 */
	public static boolean isTrigger(float specProbability) {
		if(specProbability<=0){	//必定不触发
			return false;
		}
		if(specProbability>=1){ //必定触发
			return true;
		}
		int probability = (int) (specProbability * 100);
		if ((int) (Math.random() * 100) <= probability) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断是否游戏结束
	 * 
	 * @param hero1
	 *            英雄1
	 * @param hero2
	 *            英雄2
	 * @return
	 */
	public static boolean isGameOver(BaseHero hero1,BaseHero hero2){
		if(hero1.getCurrentHP()==0){
			System.out.println(hero2.getHeroName()+"胜出");
			return true;
		}else if(hero2.getCurrentHP()==0){
			System.out.println(hero1.getHeroName()+"胜出");
			return true;
		}else{
			return false;
		}
	}
}
