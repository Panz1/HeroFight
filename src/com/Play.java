package com;

import com.common.Arena;
import com.hero.BaseHero;
import com.hero.entities.BM;
import com.hero.entities.DH;
import com.hero.entities.MK;

/**
 * 游戏入口类
 * 
 * @author Chuck.Dong
 *
 */
public class Play {

	public static void main(String[] args) {
		BaseHero MK=new MK("MK");
		BaseHero MK1=new MK("MK1");
		BaseHero BM=new BM("BM");
		BaseHero BM1=new BM("BM1");
		BaseHero DH=new DH("DH");
		BaseHero DH1=new DH("DH1");
//		Arena arena=new Arena(MK,BM);
//		Arena arena=new Arena(MK,DH);
		Arena arena=new Arena(BM,DH);
//		Arena arena=new Arena(MK,MK1);
//		Arena arena=new Arena(BM,BM1);
//		Arena arena=new Arena(DH,DH1);
		
		arena.fight();
	}

}
