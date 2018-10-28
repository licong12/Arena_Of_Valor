package com.itheima.domain;

import java.util.List;

import com.itheima.BattleField.BattleFieldMap;
/**
 * <strong>妲己英雄类</strong>
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *@see Hero
 */
public class DaJi extends Hero {
	public DaJi(){
		super.setHeroName("妲己");
		super.setHP(3229);
		super.setMP(490);
	}
	public void Set(){
		super.setHeroName("妲己");
		super.setHP(3229);
		super.setMP(490);
	}
	public char heroChar() {
		return 'd';
	}
	public void normalAttack(Hero hero) {
		hero.HP-=10;
		IfDead(hero);
	}
	public void activeAttack(Hero hero) {
		if(this.MP-10>=0) {
			hero.HP-=100;
			this.MP-=10;
			IfDead(hero);
		}
		else 
			System.out.println("MP不足!");
	}
	public void passionAttack(Hero hero) {
		hero.HP-=5;
		IfDead(hero);
	}
	public char Attack(String attack,int Fpos,int Lpos,BattleFieldMap battlefield){
		if(battlefield.firstAttack.get(5).heroChar()=='R') {
			if(Math.abs(battlefield.firstAttack.get(Fpos-1).RedLocationX[Fpos-1]-battlefield.lastAttack.get(Lpos-1).BlueLocationX[Lpos-1])<=3&&Math.abs(battlefield.firstAttack.get(Fpos-1).RedLocationY[Fpos-1]-battlefield.lastAttack.get(Lpos-1).BlueLocationY[Lpos-1])<=3) {
				if(attack.charAt(0)=='a') {
					activeAttack(battlefield.lastAttack.get(Lpos-1));
					return '@';
				}
				else if(attack.charAt(0)=='n') {
					normalAttack(battlefield.lastAttack.get(Lpos-1));
					return '*';
				}
				else if(attack.charAt(0)=='p') {
					passionAttack(battlefield.lastAttack.get(Lpos-1));
					return 'D';
				}
			}
			else {
				if(attack.charAt(0)=='a')
					return '@';
				else if(attack.charAt(0)=='n')
					return '*';
				else if(attack.charAt(0)=='p')
					return 'D';
				System.out.println("距离过远！");
			}
		}
		else if(battlefield.firstAttack.get(5).heroChar()=='B'){
			if(Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationX[Lpos-1])<=3&&Math.abs(battlefield.firstAttack.get(Fpos-1).BlueLocationY[Fpos-1]-battlefield.lastAttack.get(Lpos-1).RedLocationY[Lpos-1])<=3) {
				if(attack.charAt(0)=='a') {
					activeAttack(battlefield.lastAttack.get(Lpos-1));
					return '@';
				}
				else if(attack.charAt(0)=='n') {
					normalAttack(battlefield.lastAttack.get(Lpos-1));
					return '*';
				}
				else if(attack.charAt(0)=='p') {
					passionAttack(battlefield.lastAttack.get(Lpos-1));
					return 'D';
				}
			}
			else {
				if(attack.charAt(0)=='a')
					return '@';
				else if(attack.charAt(0)=='n')
					return '*';
				else if(attack.charAt(0)=='p')
					return 'D';
				System.out.println("距离过远！");
			}
		}
		return 0;
	}
}
