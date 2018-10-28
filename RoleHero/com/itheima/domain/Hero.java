package com.itheima.domain;

import com.itheima.exp.IExp;
import com.itheima.clock.Counter;


import com.itheima.BattleField.*;
/**
 * <em><b>定义英雄抽象类</b></em>
 * 
 *<p> 用于实现英雄抽象的基本属性、能力招式和表现形式（字符化）
 * 基本属性包括英雄名字heroName{@link #heroName}、生命值HP{@link #HP}、魔法值MP{@link #MP}、经验值Exp{@link #iexp}（回调）
 * 以及位置信息（蓝方{@link #BlueLocationX}与{@link #BlueLocationY}和红方{@link #RedLocationX}与{@link #RedLocationY}）；
 * <p>能力招式包括主动技能{@link #activeAttack(Hero)}、被动技能{@link #passionAttack(Hero)}和普通攻击{@link #normalAttack(Hero)}；
 * <p>技能招式释放后，可独立于人物角色，在限定时间内存在；
 * <p>人物和招式均可选用字符形式进行表现，在不同状态下可以有不同展现；
 * @author YM
 * @version 1.0
 * @since 2018.10.27
 */
public abstract class Hero{

	public String heroName;
	public IExp iexp;
	public int HP;
	public int MP;
	public int []RedLocationX= {8,8,8,8,8,8,7,7,7,1,1,1,15,15,15};
	public int []RedLocationY= {1,2,3,4,5,8,26,19,12,26,19,12,26,19,12};
	public int []BlueLocationX= {8,8,8,8,8,8,9,9,9,1,1,1,15,15,15};
	public int []BlueLocationY= {53,54,55,56,57,50,33,39,46,33,39,46,33,39,46};
	/**
	 * @return 返回英雄的特定字符{@code heroChar}
	 */
	public abstract char heroChar();
	
	/**
	 * <em><b>普通攻击</b></em>
	 * <p>不消耗MP值的小伤害攻击
	 * @param hero 被攻击的英雄
	 */
	public abstract void normalAttack(Hero hero);
	/**
	 * <em><b>主动技能</b></em>
	 * <p>消耗一定MP值的高伤害攻击
	 * @param hero 被攻击的英雄
	 */
	public abstract void activeAttack(Hero hero);
	/**
	 * <em><b>被动技能</b></em>
	 * <p>无需操作便可以自动触发的技能,在这里作为玩家操作触发
	 * @param hero 被攻击的英雄
	 */
	public abstract void passionAttack(Hero hero);
	/**
	 * 重置英雄的角色名、HP值、MP值
	 */
	public abstract void  Set();
	/**
	 * <em><b>英雄攻击</b></em>
	 * <p>判断攻击英雄是红方还是蓝方
	 * <p>执行攻击操作指令，对攻击英雄范围内的置顶被攻击英雄造成伤害
	 * <p>最后返回技能特效（字符）
	 * @param attack 攻击操作指令（normalattack/passionattack/activeattack）
	 * @param Fpos	攻击英雄位置
	 * @param Lpos 被攻击英雄位置
	 * @param battlefield 战场
	 * @return 返回特定技能效果字符
	 */
	public abstract char Attack(String attack,int Fpos,int Lpos,BattleFieldMap battlefield);
	public Counter counter=new Counter();
	/**
	 * <em><b>英雄死亡判断</b></em>
	 * <p>判断被攻击英雄的HP值是否小于等于0：
	 * <ul>
	 * <li>若小于等于0，判断攻击者是否为水晶或者塔；若不是，则该英雄获得经验值；设置被攻击英雄的复活时间并重置该英雄的属性</li>
	 * </ul>
	 * @param hero 被攻击英雄
	 */
	public void IfDead(Hero hero) {
		if(hero.HP<=0) {
			if(heroName!="水晶"&&heroName!="塔")
				this.iexp.HeroExp();
			hero.counter.SetDeadTime();
			System.out.println("敌方英雄"+hero.heroName+"死亡");
			hero.Set();
		}
	}
	/**
	 * 
	 * @return 返回英雄角色名
	 */
	public String getHeroName() {
		return heroName;
	}
	/**
	 * 设置英雄角色名
	 * @param heroName 英雄角色名
	 */
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	/**
	 * 
	 * @return 返回英雄经验值
	 */
	public int getExp() {
		return iexp.GetExp();
	}
	/**
	 * 设置初始化英雄经验值
	 * @param iexp 设置初始化英雄经验值接口
	 */
	public void setExp(IExp iexp) {
		this.iexp = iexp;
	}
	/**
	 * 设置英雄HP值
	 * @param hP 英雄HP值
	 */
	public void setHP(int hP) {
		HP = hP;
	}
	/**
	 * 设置英雄MP值
	 * @param mP 英雄MP值
	 */
	public void setMP(int mP) {
		MP = mP;
	}

}
