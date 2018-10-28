package com.itheima.clock;

/**
 * <strong>战场时钟类</strong>
 * 只要有时间推进{@link #Clock_increment()}、返回时分秒({@link #GetHour()} {@link #GetMinute()} {@link #GetSecond()})和打印时间{@link #ClockDisplay()}组成
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *
 */
public class BattleFieldClock {
	private int Hour,Minute,Second;
	public BattleFieldClock(){
		Hour=0;Minute=0;Second=0;
	}
	/**
	 * 时间推进，每一回合时间增加一秒；
	 */
	public void Clock_increment() {
		Second++;
		if(Second==60) {
			Minute++;
			Second=0;
			if(Minute==60) {
				Hour++;
				Minute=0;
			}
		}
	}
	/**
	 * 
	 * @return 返回{@code Hour}
	 */
	public int GetHour() {
		return Hour;
	}
	/**
	 * 
	 * @return 返回{@code Minute}
	 */
	public int GetMinute() {
		return Minute;
	}
	/**
	 * 
	 * @return 返回{@code Second}
	 */
	public int GetSecond() {
		return Second;
	}
	/**
	 * 时间展示
	 */
	public void ClockDisplay() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("               	   Time:"+Hour+":"+Minute+":"+Second);
		System.out.println("-----------------------------------------------------------");
	}
}
