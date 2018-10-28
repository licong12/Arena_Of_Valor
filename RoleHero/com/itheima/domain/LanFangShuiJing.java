package com.itheima.domain;

import java.util.List;

import com.itheima.BattleField.BattleFieldMap;
/**
 * <strong>蓝方水晶类</strong>
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *@see Hero
 */
public class LanFangShuiJing extends Hero {

	public LanFangShuiJing(){
		super.setHeroName("水晶");
		super.setHP(9000);
		super.setMP(0);
	}
	public void Set(){
		super.setHeroName("水晶");
		super.setHP(9000);
		super.setMP(0);
	}
	public char heroChar() {
		return 'B';
	}

	public void normalAttack(Hero hero) {
		hero.HP-=700;
		IfDead(hero);
	}
	public void activeAttack(Hero hero) {
	}

	public void passionAttack(Hero hero) {
	}
	public char Attack(String attack,int Fpos,int Lpos,BattleFieldMap battlefield) {
		if(Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationX[Lpos-1])<=4&&Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationY[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationY[Lpos-1])<=4) {
			normalAttack(battlefield.lastAttack.get(Lpos-1));
			return 'B';
		}
		return ' ';
	}
}
