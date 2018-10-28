package com.itheima.domain;

import com.itheima.BattleField.BattleFieldMap;
/**
 * <strong>蓝方塔类</strong>
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *@see Hero
 */
public class LanFangTa extends Hero {
	
	public LanFangTa(){
		super.setHeroName("塔");
		super.setHP(7000);
		super.setMP(0);
	}
	public void Set() {
		super.setHeroName("塔");
		super.setHP(7000);
		super.setMP(0);
	}
	public char heroChar() {
		return 'O';
	}
	public void normalAttack(Hero hero) {
		hero.HP-=250;
		IfDead(hero);
	}
	public void activeAttack(Hero hero){
	}
	public void passionAttack(Hero hero) {
	}
	public char Attack(String attack,int Fpos,int Lpos,BattleFieldMap battlefield) {
		if(Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationX[Lpos-1])<=4&&Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationY[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationY[Lpos-1])<=4) {
			normalAttack(battlefield.lastAttack.get(Lpos-1));
			return 'O';
		}
		return ' ';
	}
}
