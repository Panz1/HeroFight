package com.hero;

import com.common.CommonUtils;
import com.skill.BaseAttackSkill;
import com.skill.BaseDefenseSkill;
import com.status.BaseStatus;
import com.status.StatusEffectContant;
import com.status.entities.NormalStatus;

/**
 * 基础英雄类
 * 
 * @author Chuck.Dong
 *
 */
public class BaseHero implements Runnable{
	//英雄名称
	private String heroName;	
	//最大生命值
	private float maxHP;	
	//当前生命值
	private float currentHP;
	//攻击力
	private int attack;		
	//攻击时间
	private long attackTime;
	//攻击技能
	private BaseAttackSkill attackSkill;
	//防御技能
	private BaseDefenseSkill defenseSkill;
	//状态
	private BaseStatus status;	
	//对手
	private BaseHero enemy;
	
	
	public String getHeroName() {
		return heroName;
	}
	protected void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public float getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(float maxHP) {
		this.maxHP = maxHP;
	}
	public float getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(float currentHP) {
		this.currentHP = currentHP;
	}
	public int getAttack() {
		return attack;
	}
	protected void setAttack(int attack) {
		this.attack = attack;
	}
	public long getAttackTime() {
		return attackTime;
	}
	protected void setAttackTime(long attackTime) {
		this.attackTime = attackTime;
	}
	public BaseAttackSkill getAttackSkill() {
		return attackSkill;
	}
	protected void setAttackSkill(BaseAttackSkill attackSkill) {
		this.attackSkill = attackSkill;
	}
	public BaseDefenseSkill getDefenseSkill() {
		return defenseSkill;
	}
	protected void setDefenseSkill(BaseDefenseSkill defenseSkill) {
		this.defenseSkill = defenseSkill;
	}
	public BaseStatus getStatus() {
		return status;
	}
	public void setStatus(BaseStatus status) {
		this.status = status;
	}
	public BaseHero getEnemy() {
		return enemy;
	}
	public void setEnemy(BaseHero enemy) {
		this.enemy = enemy;
	}
	
	
	/**
	 * 攻击
	 * 
	 * @param destination
	 *            攻击目标
	 */
	public void attack(BaseHero destination){
		System.out.println(this.getHeroName()+"攻击"+destination.getHeroName());
		BaseAttackSkill attackSkill=this.getAttackSkill();
		attackSkill.launch(this,destination);
	}
	
	/**
	 * 防御
	 * 
	 * @param damage
	 *            伤害值
	 * @param enemy
	 *            伤害来源
	 * @return 防御后伤害值
	 */
	private float defense(float damage,BaseHero enemy){
		BaseDefenseSkill defenseSkill=this.getDefenseSkill();
		return defenseSkill.launch(damage,this,enemy);
	}
	
	/**
	 * 攻击扣血
	 * 
	 * @param damage
	 *            伤害值
	 * @param enemy
	 *            伤害来源
	 * @return 最终伤害值
	 */
	public float hert(float damage,BaseHero enemy) {
		float finalDamage=damage;
		float finalHP=this.currentHP-damage;
		if(this.getStatus() instanceof NormalStatus 
				||this.getStatus().getStatusEffect()==StatusEffectContant.CANDEFENSE){//处于正常状态或可防御状态
			finalDamage=this.defense(damage,enemy);
			finalHP=this.currentHP-finalDamage;
		}
		if(finalHP<0){	//血量不能为负数
			finalHP=0;
		}
		System.out.println(this.getHeroName()+":"+this.currentHP+"->"+finalHP);
		this.currentHP = finalHP;
		return finalDamage;
	}
	
	/**
	 * 特效扣血
	 * 
	 * @param damage
	 *            伤害值
	 */
	public void specialHert(float damage){
		float finalHP=this.currentHP-damage;
		if(finalHP<0){	//血量不能为负数
			finalHP=0;
		}
		System.out.println(this.getHeroName()+":"+this.currentHP+"->"+finalHP);
		this.currentHP = finalHP;
	}
	
	/**
	 * 回血
	 * 
	 * @param recover
	 *            回血量
	 */
	public void recovery(float recovery) {
		float finalHP=this.currentHP+recovery;
		if(finalHP>this.maxHP){	//血量不能超过最大血量
			finalHP=this.maxHP;
		}
		System.out.println(this.getHeroName()+":"+this.currentHP+"->"+finalHP);
		this.currentHP = finalHP;
	}
	
	@Override
	public void run() {
		long nextAttackTime=System.currentTimeMillis()+this.getAttackTime();	//获取第一次进攻时间点
		while(true){
			synchronized (this) {
				if(CommonUtils.isGameOver(this,this.enemy)){	//游戏结束，一方获胜
					break;
				}else{
					if(this.getStatus() instanceof NormalStatus
							||this.getStatus().getStatusEffect()==StatusEffectContant.CANATTACK){	//处于正常或可攻击状态
						if(System.currentTimeMillis()>=nextAttackTime){	//攻击时间到
							this.attack(enemy);
							System.out.println("=======================");
							nextAttackTime=System.currentTimeMillis()+this.getAttackTime();	//获取下一次进攻时间
						}
					}else{	//其它状态
						if(System.currentTimeMillis()>=this.getStatus().getStatusEnd()){	//状态持续时间结束则恢复正常状态,每次取当前最新的状态结束时间，以确保状态的重置
							this.setStatus(new NormalStatus());
							nextAttackTime=System.currentTimeMillis()+this.getAttackTime();	//从恢复正常状态开始计算下次攻击时间
						}
					}
				}
			}
		}
	}
}
