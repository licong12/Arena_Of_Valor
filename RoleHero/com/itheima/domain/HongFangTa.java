/**
 * {@link Package}
 */
package com.itheima.domain;

import com.itheima.BattleField.BattleFieldMap;
/**
 * <strong>红方塔类</strong>
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *@see Hero
 */
public class HongFangTa extends Hero {

	public HongFangTa(){
		super.setHeroName("塔");
		super.setHP(7000);
		super.setMP(0);
	}
	public void Set(){
		super.setHeroName("塔");
		super.setHP(7000);
		super.setMP(0);
	}
	public char heroChar() {
		return '0';
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
		if(Math.abs(battlefield.firstAttack.get(Fpos-1).RedLocationX[Fpos-1]-battlefield.lastAttack.get(Lpos-1).BlueLocationX[Lpos-1])<=4&&Math.abs(battlefield.firstAttack.get(Fpos-1).RedLocationY[Fpos-1]-battlefield.lastAttack.get(Lpos-1).BlueLocationY[Lpos-1])<=4) {
			normalAttack(battlefield.lastAttack.get(Lpos-1));
			return '0';
		}
		return ' ';
	}
}
