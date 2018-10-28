package com.itheima.BattleField;

import java.util.ArrayList;
import java.util.List;
import com.itheima.domain.*;
import com.itheima.BaseMap.*;
import com.itheima.clock.BattleFieldClock;

/**
 * <em>定义战场地图类（战场控制包括战场地图和回合控制）</em>
 * 
 * <p>主要由红蓝方英雄和水晶与塔加入战场、红蓝方英雄移动、红蓝方英雄发动攻击、英雄复活倒计时、回合交换、战场展示等方法组成
 * <p>战场地图由基本地图{@link com.itheima.BaseMap.BaseMap}和
 * 地图附着物（英雄{@link com.itheima.domain.AnQiLa}、{@link com.itheima.domain.DaJi}、{@link com.itheima.domain.HouYi}等）、水晶（红方水晶{@link com.itheima.domain.HongFangShuiJing}
 * 和{@link com.itheima.domain.LanFangShuiJing}）和塔（蓝方塔{@link com.itheima.domain.LanFangTa}和红方塔{@link com.itheima.domain.HongFangTa}）组成；
 *<p>基本地图包括普通区域和不可通行区域等；
 *<p>地图附着物包括人物角色和技能招式等；
 *<p>战场展示由战场地图和临时效果组成，临时效果指对特定区域内的人物、招式表现形式进行合成展示；
 * @author 李聪
 * @version 1.0
 *@since 2018.10.27
 */
public class BattleFieldMap{
	public static List<Hero> Blue=new ArrayList<Hero>();
	public static List<Hero> Red=new ArrayList<Hero>();
	public static List<Hero> firstAttack=Red;
	public static List<Hero> lastAttack=Blue;
	public String []HeroBase= {"后羿","安琪拉","妲己","程咬金","鲁班七号"};
	public BaseMap map=new BaseMap();
	public BattleFieldClock battlefieldclock=new BattleFieldClock();
	/**
	 * <b><em>红方英雄和水晶与塔加入战场</em></b>
	 * <p>将hero加入Red List列表中，并在地图上的对应位置打印对应英雄的符号（{@code HeroChar}）：
	 * <ul>
	 * <li>{@code Red.add(hero1);map.ch[8][1]=hero1.heroChar();}</li>
	 * </ul>
	 * @param hero1 英雄1
	 * @param hero2 英雄1
	 * @param hero3 英雄1
	 * @param hero4 英雄1
	 * @param hero5 英雄1
	 * @param hero6 红方水晶
	 * @param hero7 中路塔3
	 * @param hero8 中路塔2
	 * @param hero9 中路塔1
	 * @param hero10 上路塔3
	 * @param hero11 上路塔2
	 * @param hero12 上路塔1
	 * @param hero13 下路塔3
	 * @param hero14 下路塔2
	 * @param hero15 下路塔1
	 */
	public void Redinitialize(Hero hero1,Hero hero2,Hero hero3,Hero hero4,Hero hero5,Hero hero6,Hero hero7,Hero hero8,Hero hero9,Hero hero10,Hero hero11,Hero hero12,Hero hero13,Hero hero14,Hero hero15){
		Red.add(hero1);map.ch[8][1]=hero1.heroChar();
		Red.add(hero2);map.ch[8][2]=hero2.heroChar();
		Red.add(hero3);map.ch[8][3]=hero3.heroChar();
		Red.add(hero4);map.ch[8][4]=hero4.heroChar();
		Red.add(hero5);map.ch[8][5]=hero5.heroChar();
		Red.add(hero6);map.ch[8][8]=hero6.heroChar();
		Red.add(hero7);map.ch[7][26]=hero7.heroChar();
		Red.add(hero8);map.ch[7][19]=hero8.heroChar();
		Red.add(hero9);map.ch[7][12]=hero9.heroChar();
		Red.add(hero10);map.ch[1][26]=hero10.heroChar();
		Red.add(hero11);map.ch[1][19]=hero11.heroChar();
		Red.add(hero12);map.ch[1][12]=hero12.heroChar();
		Red.add(hero13);map.ch[15][26]=hero13.heroChar();
		Red.add(hero14);map.ch[15][19]=hero14.heroChar();
		Red.add(hero15);map.ch[15][12]=hero15.heroChar();
	}
	/**
	 * <b><em>蓝方英雄和水晶与塔加入战场</em></b>
	 * <p>将hero加入Blue List列表中，并在地图上的对应位置打印对应英雄的符号（{@code HeroChar}）：
	 * <ul>
	 * <li>{@code Blue.add(hero1);map.ch[8][1]=hero1.heroChar();}</li>
	 * </ul>
	 * @param hero1 英雄1
	 * @param hero2 英雄1
	 * @param hero3 英雄1
	 * @param hero4 英雄1
	 * @param hero5 英雄1
	 * @param hero6 蓝方水晶
	 * @param hero7 中路塔1
	 * @param hero8 中路塔2
	 * @param hero9 中路塔3
	 * @param hero10 上路塔1
	 * @param hero11 上路塔2
	 * @param hero12 上路塔3
	 * @param hero13 下路塔1
	 * @param hero14 下路塔2
	 * @param hero15 下路塔3
	 */
	public void Blueinitialize(Hero hero1,Hero hero2,Hero hero3,Hero hero4,Hero hero5,Hero hero6,Hero hero7,Hero hero8,Hero hero9,Hero hero10,Hero hero11,Hero hero12,Hero hero13,Hero hero14,Hero hero15){
		Blue.add(hero1);map.ch[8][53]=hero1.heroChar();
		Blue.add(hero2);map.ch[8][54]=hero2.heroChar();
		Blue.add(hero3);map.ch[8][55]=hero3.heroChar();
		Blue.add(hero4);map.ch[8][56]=hero4.heroChar();
		Blue.add(hero5);map.ch[8][57]=hero5.heroChar();
		Blue.add(hero6);map.ch[8][50]=hero6.heroChar();
		Blue.add(hero7);map.ch[9][33]=hero7.heroChar();
		Blue.add(hero8);map.ch[9][39]=hero8.heroChar();
		Blue.add(hero9);map.ch[9][46]=hero9.heroChar();
		Blue.add(hero10);map.ch[1][33]=hero10.heroChar();
		Blue.add(hero11);map.ch[1][39]=hero11.heroChar();
		Blue.add(hero12);map.ch[1][46]=hero12.heroChar();
		Blue.add(hero13);map.ch[15][33]=hero13.heroChar();
		Blue.add(hero14);map.ch[15][39]=hero14.heroChar();
		Blue.add(hero15);map.ch[15][46]=hero15.heroChar();
	}
	/**
	 * <b><em>蓝方英雄移动</em></b>
	 * <p>回合开始，已死亡的英雄复活时间减一，循环判断参数{@code heroChar}是否为蓝方英雄中的其中之一的符号。
	 * 若是,判断该英雄是否已经死亡（即复活时间是否大于0）。若英雄未死亡，判断前进方向是否有障碍物。
	 * 若没有障碍物，则英雄执行移动指令，并打印移动信息。若有障碍物，则英雄不执行移动指令，并打印提示信息。
	 * <p>复活时间减一秒：{@link com.itheima.clock.Counter#DeadTime_decrement()}
	 * <ul>
	 * <li>{@code DeadTime_decrement();}</li>
	 *</ul> 
	 * <p>判断敌方英雄生死：{@link com.itheima.clock.Counter#GetCount()}
	 * <ul>
	 * <li>{@code (Blue.get(i).counter.GetCount()==0)==true} 则敌方英雄未死亡，执行移动命令</li>
	  * <li>{@code (Blue.get(i).counter.GetCount()==0)==false} 则敌方英雄死亡，不执行移动命令</li>
	 * </ul>
	 * <p>判断前进方向是否有障碍物（即是否有非空格字符）(以向左为例）：
	 * <ul>
	 * <li>{@code (map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]-1]==' '&&movecmd.charAt(0)=='l')==true} 
	 * 则表示无障碍物且向左前进</li>
	 * <li>{@code (map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]-1]==' '&&movecmd.charAt(0)=='l')==true}
	 * 则表示有障碍物且向左前进，则停止移动操作并打印提示信息</li>
	 *</ul> 
	 * <p>执行移动指令：
	 * <ul>
	 * <li>前进后的位置上打印heroChar：
	 *{@code map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]-1]=Blue.get(i).heroChar();}</li>
	 *<li>原位置上的heroChar变为空格字符：
	 *{@code map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';}</li>
	 *<li>英雄的位置信息改变：{@link Hero#BlueLocationX} {@link Hero#BlueLocationY}
	 *{@code Blue.get(i).BlueLocationY[i]-=1;}}</li>
	 *</ul>
	 *<p>打印地图：{@link BattleFieldMap#MapDisplay()}
	 * @param heroChar 对应英雄的符号
	 * @param movecmd 移动操作指令（left/right/up/down）
	 */
	public void Bluemove(char heroChar,String movecmd) {
		
		for(int i=0;i<5;i++) {
			if(heroChar==Blue.get(i).heroChar()) {
				if(Blue.get(i).counter.GetCount()==0) {
					if(map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]-1]==' '&&movecmd.charAt(0)=='l') {
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]-1]=Blue.get(i).heroChar();
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';	
						Blue.get(i).BlueLocationY[i]-=1;
						System.out.println("蓝方"+Blue.get(i).getHeroName()+"向左移动");
							break;
						}
					else if(map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]+1]==' '&&movecmd.charAt(0)=='r') {
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]+1]=Blue.get(i).heroChar();
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';
						Blue.get(i).BlueLocationY[i]+=1;
						System.out.println("蓝方"+Blue.get(i).getHeroName()+"向右移动");
							break;
						}
					else if(map.ch[Blue.get(i).BlueLocationX[i]-1][Blue.get(i).BlueLocationY[i]]==' '&&movecmd.charAt(0)=='u') {
						map.ch[Blue.get(i).BlueLocationX[i]-1][Blue.get(i).BlueLocationY[i]]=Blue.get(i).heroChar();
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';
						Blue.get(i).BlueLocationX[i]-=1;
						System.out.println("蓝方"+Blue.get(i).getHeroName()+"向上移动");
							break;
					}
					else if(map.ch[Blue.get(i).BlueLocationX[i]+1][Blue.get(i).BlueLocationY[i]]==' '&&movecmd.charAt(0)=='d') {
						map.ch[Blue.get(i).BlueLocationX[i]+1][Blue.get(i).BlueLocationY[i]]=Blue.get(i).heroChar();
						map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';
						Blue.get(i).BlueLocationX[i]+=1;
						System.out.println("蓝方"+Blue.get(i).getHeroName()+"向下移动");
							break;
					}
					else
						System.out.println("有障碍物，无法移动！");
				}
			}
		}
			MapDisplay();
		}
	/**
	 * <b><em>红方英雄移动</em></b>
	 * <p>回合开始，已死亡的英雄复活时间减一，循环判断参数{@code heroChar}是否为红方英雄中的其中之一的符号。
	 * 若是,判断该英雄是否已经死亡（即复活时间是否大于0）。若英雄未死亡，判断前进方向是否有障碍物。
	 * 若没有障碍物，则英雄执行移动指令，并打印移动信息。若有障碍物，则英雄不执行移动指令，并打印提示信息。
	 *<p> 复活时间减一秒：{@link com.itheima.clock.Counter#DeadTime_decrement()}
	 * <ul>
	 * <li>{@code DeadTime_decrement();}</li>
	 * </ul>
	 * <p>判断敌方英雄生死：{@link com.itheima.clock.Counter#GetCount()}
	 * <ul>
	 * <li>{@code (Red.get(i).counter.GetCount()==0)==true} 则敌方英雄未死亡，执行移动命令</li>
	  * <li>{@code (Red.get(i).counter.GetCount()==0)==false} 则敌方英雄死亡，不执行移动命令</li>
	 *</ul> 
	 * <p>判断前进方向是否有障碍物（即是否有非空格字符）(以向左为例）：
	 * <ul>
	 * <li>{@code (map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]-1]==' '&&movecmd.charAt(0)=='l')==true}
	 * 则表示无障碍物且向左前进</li>
	 * <li>{@code (map.ch[Red.get(i).BlueLocationX[i]][Red.get(i).RedLocationY[i]-1]==' '&&movecmd.charAt(0)=='l')==true}
	 * 则表示有障碍物且向左前进，则停止移动操作并打印提示信息</li>
	 *</ul> 
	 * <p>执行移动指令：
	 * <ul>
	 * <li>前进后的位置上打印heroChar：
	 *{@code map.ch[Red.get(i).BlueLocationX[i]][Red.get(i).RedLocationY[i]-1]=Red.get(i).heroChar();}</li>
	 *<li>原位置上的heroChar变为空格字符：
	 *{@code map.ch[Red.get(i).BlueLocationX[i]][Red.get(i).RedLocationY[i]]=' ';}</li>
	 *<li>英雄的位置信息改变：{@link Hero#BlueLocationX} {@link Hero#BlueLocationY}
	 *{@code Red.get(i).RedLocationY[i]-=1;}}</li>
	 *</ul>
	 *<p>打印地图：{@link BattleFieldMap#MapDisplay()}
	 * 
	 * @param heroChar 对应英雄的符号
	 * @param movecmd 移动操作指令（left/right/up/down）
	 */
	public void Redmove(char heroChar,String movecmd) {
		DeadTime_decrement();
		for(int i=0;i<5;i++) {
			if(heroChar==Red.get(i).heroChar()) {
				if(Red.get(i).counter.GetCount()==0) {
					if(map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]-1]==' '&&movecmd.charAt(0)=='l') {
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]-1]=Red.get(i).heroChar();
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=' ';	
							Red.get(i).RedLocationY[i]-=1;
							System.out.println("红方"+Red.get(i).getHeroName()+"向左移动");
							break;
						}
					else if(map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]+1]==' '&&movecmd.charAt(0)=='r') {
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]+1]=Red.get(i).heroChar();
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=' ';
							Red.get(i).RedLocationY[i]+=1;
							System.out.println("红方"+Red.get(i).getHeroName()+"向右移动");						
							break;
						}
					else if(map.ch[Red.get(i).RedLocationX[i]-1][Red.get(i).RedLocationY[i]]==' '&&movecmd.charAt(0)=='u') {
							map.ch[Red.get(i).RedLocationX[i]-1][Red.get(i).RedLocationY[i]]=Red.get(i).heroChar();
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=' ';
							Red.get(i).RedLocationX[i]-=1;
							System.out.println("红方"+Red.get(i).getHeroName()+"向上移动");
							break;
						}
					else if(map.ch[Red.get(i).RedLocationX[i]+1][Red.get(i).RedLocationY[i]]==' '&&movecmd.charAt(0)=='d') {
							map.ch[Red.get(i).RedLocationX[i]+1][Red.get(i).RedLocationY[i]]=Red.get(i).heroChar();
							map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=' ';
							Red.get(i).RedLocationX[i]+=1;
							System.out.println("红方"+Red.get(i).getHeroName()+"向下移动");
							break;
						}
					else
						System.out.println("有障碍物，无法移动！或 指令输出错误");	
				}
			}
		}
			MapDisplay();
		}
	/**
	 * <em><b>红方攻击</b></em>
	 * <p>回合开始，已死亡的英雄复活时间减一秒（{@link com.itheima.clock.Counter#DeadTime_decrement()}）,
	 * <p>判断双方英雄是否有死亡状态的存在：
	 * <ul>
	 * <li>若无死亡{@code (firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0)==true}，
	 * 循环判断蓝方英雄是否有在红方水晶或塔攻击范围内的；</li>
	 * <li>若有死亡,则停止攻击操作,打印战场。</li>
	 * </ul>
	 * <p>判断蓝方英雄是否有在红方水晶或塔攻击范围内：
	 *<ul>
	 *<li>若有蓝方英雄在红方水晶攻击范围内({@code (firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='0'||firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='R')==true})，
	 *则这些蓝方英雄遭受红方水晶或塔攻击;</li>
	 * <li>若无蓝方英雄在红方水晶内，则无操作；</li>
	 * </ul>
	 * <p>判断选定的双方英雄是否存在死亡状态的：
	 * <ul>
	 * <li>若有，则停止攻击操作，打印战场{@link #MapDisplay()};</li>
	 * <li>若无，则红方英雄进入攻击状态</li>
	 * </ul>
	 * <p>判断攻击命令是被动还是其他攻击方式：
	 * <ul>
	 * <li>若发动被动技能({@code(attackcmd.charAt(0)=='p')==true})，则红方英雄自身发出技能效果；</li>
	 * <li>若发动其他技能攻击({@code(attackcmd.charAt(0)=='p')==false})，则朝某一方向发动技能并打印三张存在技能效果的连环战场；</li>
	 *</ul>
	 *<p> 最后打印最终战场{@link #MapDisplay()};
	 * 
	 * @param attackcmd 攻击操作指令
	 * @param Fpos 先手英雄位置
	 * @param Lpos	后手英雄位置
	 * @param battlefield 战场
	 */
	public void RedAttack(String attackcmd,int Fpos,int Lpos,BattleFieldMap battlefield){
		DeadTime_decrement();
		if(firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0) {
			for(int i=5;i<=14;i++) 
				if(firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='0'||firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='R') 
					map.ch[lastAttack.get(Lpos-1).BlueLocationX[Lpos-1]][lastAttack.get(Lpos-1).BlueLocationY[Lpos-1]]=firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield);
			if(firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0) {
				if(attackcmd.charAt(0)=='p') {
					map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][firstAttack.get(Fpos-1).RedLocationY[Fpos-1]]=firstAttack.get(Fpos-1).Attack(attackcmd,Fpos,Lpos,battlefield);
					MapDisplay();
					map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][firstAttack.get(Fpos-1).RedLocationY[Fpos-1]]=firstAttack.get(Fpos-1).heroChar();
				}
				else {
					int t=3;
					int RY=firstAttack.get(Fpos-1).RedLocationY[Fpos-1];
					while(t!=0) {
						t--;
						RY++;
						char ch_Temp=map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][RY];
						map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][RY]=firstAttack.get(Fpos-1).Attack(attackcmd, Fpos, Lpos, battlefield);
						MapDisplay();
						map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][RY]=ch_Temp;
						map.ch[firstAttack.get(Fpos-1).RedLocationX[Fpos-1]][firstAttack.get(Fpos-1).RedLocationY[Fpos-1]]=firstAttack.get(Fpos-1).heroChar();
					}
				}	
			}
			map.ch[lastAttack.get(Lpos-1).BlueLocationX[Lpos-1]][lastAttack.get(Lpos-1).BlueLocationY[Lpos-1]]=lastAttack.get(Lpos-1).heroChar();	
		}
		MapDisplay();
	}
	/**
	 * <em><b>蓝方攻击</b></em>
	 * 
	 * <p>回合开始，已死亡的英雄复活时间减一秒（{@link com.itheima.clock.Counter#DeadTime_decrement()}）,
	 * <p>判断双方英雄是否有死亡状态的存在：
	 * <ul>
	 * <li>若无死亡{@code (firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0)==true}，
	 * 循环判断红方英雄是否有在蓝方水晶或塔攻击范围内的；</li>
	 * <li>若有死亡,则停止攻击操作,打印战场。</li>
	 * </ul>
	 * <p>判断红方英雄是否有在蓝方水晶或塔攻击范围内：
	 *<ul>
	 *<li>若有红方英雄在蓝方水晶攻击范围内({@code (firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='0'||firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='R')==true})，
	 *则这些红方英雄遭受蓝方水晶或塔攻击;</li>
	 * <li>若无红方英雄在红方水晶内，则无操作；</li>
	 * </ul>
	 * <p>判断选定的双方英雄是否存在死亡状态的：
	 * <ul>
	 * <li>若有，则停止攻击操作，打印战场{@link #MapDisplay()};</li>
	 * <li>若无，则蓝方英雄进入攻击状态</li>
	 * </ul>
	 * <p>判断攻击命令是被动还是其他攻击方式：
	 * <ul>
	 * <li>若发动被动技能({@code(attackcmd.charAt(0)=='p')==true})，则蓝方英雄自身发出技能效果；</li>
	 * <li>若发动其他技能攻击({@code(attackcmd.charAt(0)=='p')==false})，则朝某一方向发动技能并打印三张存在技能效果的连环战场；</li>
	 *</ul>
	 *<p> 最后打印最终战场{@link #MapDisplay()};
	 * 
	 * @param attackcmd 攻击操作指令
	 * @param Fpos 先手英雄位置
	 * @param Lpos	后手英雄位置
	 * @param battlefield 战场
	 */
	public void BlueAttack(String attackcmd,int Fpos,int Lpos,BattleFieldMap battlefield){
		DeadTime_decrement();
		if(firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0) {
			for(int i=5;i<=14;i++)
				if(firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='O'||firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield)=='B')
					map.ch[lastAttack.get(Lpos-1).RedLocationX[Lpos-1]][lastAttack.get(Lpos-1).RedLocationY[Lpos-1]]=firstAttack.get(i).Attack(attackcmd,i+1,Lpos,battlefield);
			if(firstAttack.get(Fpos-1).counter.GetCount()==0&&lastAttack.get(Lpos-1).counter.GetCount()==0) {
				if(attackcmd.charAt(0)=='p') {
					map.ch[firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]][firstAttack.get(Fpos-1).BlueLocationY[Fpos-1]]=firstAttack.get(Fpos-1).Attack(attackcmd,Fpos,Lpos,battlefield);
					MapDisplay();
					map.ch[firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]][firstAttack.get(Fpos-1).BlueLocationY[Fpos-1]]=firstAttack.get(Fpos-1).heroChar();
				}
				else {
					int t=3;
					int BY=firstAttack.get(Fpos-1).BlueLocationY[Fpos-1];
					while(t!=0) {
						t--;
						BY--;
						char ch_Temp=map.ch[firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]][BY];
						map.ch[firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]][BY]=firstAttack.get(Fpos-1).Attack(attackcmd, Fpos, Lpos, battlefield);
						MapDisplay();
						map.ch[firstAttack.get(Fpos-1).BlueLocationX[Fpos-1]][BY]=ch_Temp;
					}
				}	
			}
			map.ch[lastAttack.get(Lpos-1).RedLocationX[Lpos-1]][lastAttack.get(Lpos-1).RedLocationY[Lpos-1]]=lastAttack.get(Lpos-1).heroChar();	
		}
		MapDisplay();
	}
	/**
	 * <p><b>复活时间倒计时</b>
	 *<p>循环判断五名英雄中是否有已死亡的({@link com.itheima.clock.Counter#GetCount()}大于0)
	 *<ul>
	 *<li>若有{@code ((GetCount()>0)==true)},则复活时间减一秒（{@link com.itheima.clock.Counter#DeadTime_decrement()}）,且该英雄消失（战场上的英雄字符被空格符号代替）；
	 *<li>若无或经过刚才的减一秒操作后复活时间为0的{@code ((GetCount()==0)==true)},则该在战场上打印出该英雄。
	 *</ul>
	 */
	public void DeadTime_decrement() {	
		for(int i=0;i<5;i++) {
			if(Red.get(i).counter.GetCount()>0) {
				Red.get(i).counter.DeadTime_decrement();
				map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=' ';
			}			
			else if(Blue.get(i).counter.GetCount()>0) {
				Blue.get(i).counter.DeadTime_decrement();
				map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=' ';
			}			
			if(Red.get(i).counter.GetCount()==0)
				map.ch[Red.get(i).RedLocationX[i]][Red.get(i).RedLocationY[i]]=Red.get(i).heroChar();
			else if(Blue.get(i).counter.GetCount()==0)
				map.ch[Blue.get(i).BlueLocationX[i]][Blue.get(i).BlueLocationY[i]]=Blue.get(i).heroChar();
		}
	}
	/**
	 * 先手执行完操作命令后，变为后手；
	 * 后手变为先手。
	 */
	public void RoundChange() {
		List<Hero> temp;
		temp=firstAttack;
		firstAttack=lastAttack;
		lastAttack=temp;
	}
	/**
	 * 打印红蓝双方五位英雄英雄的HP值、MP值、Exp经验值以及复活时间和水晶的HP值。
	 */
	public void HeroDisplay() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("               		Red");
		System.out.println("-----------------------------------------------------------");
		System.out.println("            Hero1:"+Red.get(0).getHeroName()+" HP:"+Red.get(0).HP+" MP:"+Red.get(0).MP+" EXP:"+Red.get(0).getExp()+" DeadTime:"+Red.get(0).counter.GetCount());
		System.out.println("            Hero2:"+Red.get(1).getHeroName()+" HP:"+Red.get(1).HP+" MP:"+Red.get(1).MP+" EXP:"+Red.get(1).getExp()+" DeadTime:"+Red.get(1).counter.GetCount());
		System.out.println("            Hero3:"+Red.get(2).getHeroName()+" HP:"+Red.get(2).HP+" MP:"+Red.get(2).MP+" EXP:"+Red.get(2).getExp()+" DeadTime:"+Red.get(2).counter.GetCount());
		System.out.println("            Hero4:"+Red.get(3).getHeroName()+" HP:"+Red.get(3).HP+" MP:"+Red.get(3).MP+" EXP:"+Red.get(3).getExp()+" DeadTime:"+Red.get(3).counter.GetCount());
		System.out.println("            Hero5:"+Red.get(4).getHeroName()+" HP:"+Red.get(4).HP+" MP:"+Red.get(4).MP+" EXP:"+Red.get(4).getExp()+" DeadTime:"+Red.get(4).counter.GetCount());
		System.out.println("            Hero6:"+Red.get(5).getHeroName()+" HP:"+Red.get(5).HP);
		System.out.println("-----------------------------------------------------------");
		System.out.println("               		Blue");
		System.out.println("-----------------------------------------------------------");
		System.out.println("            Hero1:"+Blue.get(0).getHeroName()+" HP:"+Blue.get(0).HP+" MP:"+Blue.get(0).MP+" EXP:"+Blue.get(0).getExp()+" DeadTime:"+Blue.get(0).counter.GetCount());
		System.out.println("            Hero2:"+Blue.get(1).getHeroName()+" HP:"+Blue.get(1).HP+" MP:"+Blue.get(1).MP+" EXP:"+Blue.get(1).getExp()+" DeadTime:"+Blue.get(1).counter.GetCount());
		System.out.println("            Hero3:"+Blue.get(2).getHeroName()+" HP:"+Blue.get(2).HP+" MP:"+Blue.get(2).MP+" EXP:"+Blue.get(2).getExp()+" DeadTime:"+Blue.get(2).counter.GetCount());
		System.out.println("            Hero4:"+Blue.get(3).getHeroName()+" HP:"+Blue.get(3).HP+" MP:"+Blue.get(3).MP+" EXP:"+Blue.get(3).getExp()+" DeadTime:"+Blue.get(3).counter.GetCount());
		System.out.println("            Hero5:"+Blue.get(4).getHeroName()+" HP:"+Blue.get(4).HP+" MP:"+Blue.get(4).MP+" EXP:"+Blue.get(4).getExp()+" DeadTime:"+Blue.get(4).counter.GetCount());
		System.out.println("            Hero6:"+Blue.get(5).getHeroName()+" HP:"+Blue.get(5).HP);
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
	}
	/**
	 * 打印战场地图
	 */
	public void MapDisplay() {
		for(int i=0;i<17;i++) {
			for(int j=0;j<59;j++) {
				System.out.print(map.ch[i][j]);
			}
			System.out.println();
		}			
	}
}
