package com.common;

import com.hero.BaseHero;

/**
 * 竞技场类
 * 
 * @author Chuck.Dong
 * 
 */
public class Arena {
	
	private BaseHero hero1;
	private BaseHero hero2;
	
	public Arena(BaseHero hero1,BaseHero hero2){
		hero1.setEnemy(hero2);
		hero2.setEnemy(hero1);
		this.hero1=hero1;
		this.hero2=hero2;
	}
	
	public void fight(){
		new Thread(this.hero1).start();
		new Thread(this.hero2).start();
	}

}
