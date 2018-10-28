package com.itheima.BattleFieldTest;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import com.itheima.BattleField.BattleFieldMap;
import com.itheima.clock.BattleFieldClock;
import com.itheima.domain.Hero;
import com.itheima.domain.HouYi;
import com.itheima.domain.DaJi;
import com.itheima.domain.AnQiLa;
import com.itheima.domain.ChengYaoJin;
import com.itheima.domain.LuBanQiHao;
import com.itheima.domain.HongFangShuiJing;
import com.itheima.domain.HongFangTa;
import com.itheima.domain.LanFangShuiJing;
import com.itheima.domain.LanFangTa;
import com.itheima.exp.impl.HeroExp;

/**
 * <b><em>定义战场回合控制类</em></b>
 * <p>主要由回合控制包括地图人物初始化{@link #Heroinitialize(BattleFieldMap battlefield)}、战场展示({@link BattleFieldMap#MapDisplay()})、
 * 玩家输入以及战场判定（{@link #Round(BattleFieldMap, BattleFieldClock)}）组成；
 * <p>战场展示由战场地图和临时效果组成，临时效果指对特定区域内的人物、招式表现形式进行合成展示；
 *<p> 玩家输入时由玩家同时控制10个人物角色（集合），每次可控制人物移动或释放招式或发呆；
 * <p>战场判定：处理玩家输入的控制指令，依据预设规则作出判定，并将结果反馈给人物角色（如Exp增加）和战场地图（如招式效果）。
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27 
 *
 */
public class BattleFieldRound{
	Scanner scanner=new Scanner(System.in);
	/**
	 * <b><em>选择英雄以及水晶、塔的初始化</em></b>
	 * <p>红蓝双方各选择五名英雄（后羿、安琪拉、程咬金、妲己、鲁班七号）并回调英雄初始经验值，初始化一个水晶以及上中下路各三个塔。
	 * <p>最后将红蓝双方选择的英雄和初始化的水晶、塔加入到战场中
	 *  <p>英雄初始化：
	 *  <ul>
	 * <li>Hero Rhero1=new 后羿();</li>
	 * <li>Rhero1.setExp(new HeroExp());</li>
	 * </ul>
	 * <p>水晶初始化：
	 * <ul>
	 * <li>Hero Redshuijing=new 红方水晶();</li>
	 * </ul>
	 * <p>塔初始化：
	 * <ul>
	 * <li>Hero RedTowel1=new 红方塔();</li>
	 * </ul>
	 * <p>加入战场:
	 * <ul>
	 * <li>battlefield.Redinitialize(Rhero1,..., Rhero5,Redshuijing,RedTowel1,...,RedTowel9);</li>
	 * </ul>
	 * @param battlefield 游戏中的战场，初始化的英雄、塔以及水晶附着在该战场上
	 */
	public void Heroinitialize(BattleFieldMap battlefield){
		Hero Rhero1=new HouYi();Rhero1.setExp(new HeroExp());
		Hero Rhero2=new AnQiLa();Rhero2.setExp(new HeroExp());
		Hero Rhero3=new ChengYaoJin();Rhero3.setExp(new HeroExp());
		Hero Rhero4=new DaJi();Rhero4.setExp(new HeroExp());
		Hero Rhero5=new LuBanQiHao();Rhero5.setExp(new HeroExp());
		Hero Bhero6=new HouYi();Bhero6.setExp(new HeroExp());
		Hero Bhero7=new AnQiLa();Bhero7.setExp(new HeroExp());
		Hero Bhero8=new ChengYaoJin();Bhero8.setExp(new HeroExp());
		Hero Bhero9=new DaJi();Bhero9.setExp(new HeroExp());
		Hero Bhero10=new LuBanQiHao();Bhero10.setExp(new HeroExp());
		Hero Redshuijing=new HongFangShuiJing();
		Hero Blueshuijing=new LanFangShuiJing();
		Hero RedTowel1=new HongFangTa();Hero RedTowel2=new HongFangTa();Hero RedTowel7=new HongFangTa();
		Hero RedTowel3=new HongFangTa();Hero RedTowel4=new HongFangTa();Hero RedTowel8=new HongFangTa();
		Hero RedTowel5=new HongFangTa();Hero RedTowel6=new HongFangTa();Hero RedTowel9=new HongFangTa();
		Hero BlueTowel1=new LanFangTa();Hero BlueTowel2=new LanFangTa();Hero BlueTowel7=new LanFangTa();
		Hero BlueTowel3=new LanFangTa();Hero BlueTowel4=new LanFangTa();Hero BlueTowel8=new LanFangTa();
		Hero BlueTowel5=new LanFangTa();Hero BlueTowel6=new LanFangTa();Hero BlueTowel9=new LanFangTa();	
		battlefield.Redinitialize(Rhero1, Rhero2, Rhero3, Rhero4, Rhero5,Redshuijing,RedTowel1,RedTowel2,RedTowel3,RedTowel4,RedTowel5,RedTowel6,RedTowel7,RedTowel8,RedTowel9);
		battlefield.Blueinitialize(Bhero6, Bhero7, Bhero8, Bhero9, Bhero10,Blueshuijing,BlueTowel1,BlueTowel2,BlueTowel3,BlueTowel4,BlueTowel5,BlueTowel6,BlueTowel7,BlueTowel8,BlueTowel9);
	}
	/**
	 *<b><em>回合控制并反馈结果</em></b>
	 *<p>玩家输入：由先手玩家和后手玩家各控制5个人物角色（List集合），每回合可轮流控制人物移动或释放招式或发呆；
	 *<p>战场判定：处理玩家输入的控制指令，依据预设规则作出判定，并将结果反馈给人物角色（如Exp增加）和战场地图（如招式效果）。
	 *<p>若有水晶被打破：
	 *<ul>
	 *<li>{@code (battlefield.Red.get(5).HP==0)==true} 则蓝方胜</li>
	 *<li>{@code (battlefield.Blue.get(5).HP==0)==true} 则红方胜</li>
	 *</ul>
	 *<p>若双方水晶都未被打破：
	 *<ul>
	 *<li>输入操作指令cmd：{@code move or attack}
	 *<li>{@code (cmd.length()==4)==true} 则输入对应的英雄符号{@code HeroChar}（即{@link com.itheima.domain.Hero#heroName}）和移动指令{@code movecmd（即left/right/up/down）}</li>
	 *<li>{@code (cmd.length()==6)==true} 则输入对应的攻击操作{@code attackcmd（即normalattack/passionattack/activeattack）}和先手英雄序号{@code Fpos}和后手英雄序号{@code Lpos}</li>
	 * </ul>
	 * <p>执行操作并打印地图：
	 *<ul>
	 *<li>若先手是红方：{@link BattleFieldMap#Redmove(char, String)} or {@link BattleFieldMap#RedAttack(String, int, int, BattleFieldMap)}</li>
	 *<li>{@code (cmd.length()==4)==true} {@code battlefield.Redmove(HeroChar, movecmd);}</li>
	 *<li>{@code (cmd.length()==6)==true} {@code battlefield.RedAttack(attackcmd,Fpos,Lpos,battlefield);}</li>
	 *<li>若先手是蓝方：{@link BattleFieldMap#Bluemove(char, String)} or {@link BattleFieldMap#BlueAttack(String, int, int, BattleFieldMap)}</li>
	 *<li>{@code (cmd.length()==4)==true} {@code battlefield.Bluemove(HeroChar, movecmd);}</li>
	 *<li>{@code (cmd.length()==6)==true} {@code battlefield.BluedAttack(attackcmd,Fpos,Lpos,battlefield);}</li>
	 *</ul>
	 *<p>结果反馈：
	 *<ul>
	 *<li>打印英雄信息：{@link BattleFieldMap#HeroDisplay()}
	 *<li>先后手交换：{@link BattleFieldMap#RoundChange()}</li>
	 * </ul>
	 * @param battlefield 游戏中的战场，战场判定后的效果展示在该战场上
	 * @param battlefieldclock 战斗时间，用于记录并展示游戏时间,每一次的玩家操作代表一秒
	 */
	public void Round(BattleFieldMap battlefield,BattleFieldClock battlefieldclock) {
		String cmd,movecmd,attackcmd;
		char HeroChar;
		int Fpos,Lpos;
		if(battlefield.Red.get(5).HP!=0&&battlefield.Blue.get(5).HP!=0) {
			cmd=scanner.next();
			battlefieldclock.Clock_increment();
			battlefieldclock.ClockDisplay();
			if(cmd.length()==4) {
				HeroChar=scanner.next().charAt(0);
				movecmd=scanner.next();
				if(battlefield.firstAttack.get(5).heroChar()=='R')
					battlefield.Redmove(HeroChar, movecmd);
				else if(battlefield.firstAttack.get(5).heroChar()=='B')
					battlefield.Bluemove(HeroChar, movecmd);
				battlefield.HeroDisplay();
			}
			else if(cmd.length()==6) {
				attackcmd=scanner.next();
				Fpos=scanner.nextInt();
				Lpos=scanner.nextInt();
				if(battlefield.firstAttack.get(5).heroChar()=='R')
					battlefield.RedAttack(attackcmd,Fpos,Lpos,battlefield);
				else if(battlefield.firstAttack.get(5).heroChar()=='B')
					battlefield.BlueAttack(attackcmd,Fpos,Lpos,battlefield);	
				battlefield.HeroDisplay();
			}
			battlefield.RoundChange();
		}
		if(battlefield.Red.get(5).HP==0)
			System.out.println("Blue Win!");
		else if(battlefield.Blue.get(5).HP==0)
			System.out.println("Red Win!");
	}
	/**
	 * 获得测试所需标准输入字符串，作为Scanner对象读取源
	 * @param baIn 测试所需标准输入字符串的字节流，由测试类传入
	 */
	public void setIn(ByteArrayInputStream baIn) {
		this.scanner=new Scanner(baIn);
	}
//	public static void main(String[] args) {	
//		BattleFieldMap battlefield=new BattleFieldMap();
//		BattleFieldRound battlefieldround=new BattleFieldRound();
//		BattleFieldClock battlefieldclock=new BattleFieldClock();
//		battlefieldround.Heroinitialize(battlefield);
//		battlefieldclock.ClockDisplay();
//		battlefield.MapDisplay();
//		battlefield.HeroDisplay();
//		battlefieldround.Round(battlefield,battlefieldclock);
//	}
}
