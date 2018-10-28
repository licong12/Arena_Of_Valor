package com.itheima.clock;

import com.itheima.BattleField.BattleFieldMap;

/**
 * <em><b>复活时间计时器</b></em>
 * 主要由设置复活时间{@link #SetDeadTime()}和获得复活时间{@link #GetCount()}以及复活时间倒数{@link #DeadTime_decrement()}组成
 * @author 李聪
 * @version 1.0
 * @since 2018.10.27
 *
 */
public class Counter {
	private int Count;
	public Counter() {
		Count=0;
	}
	/**
	 * 设置复活时间为10秒
	 */
	public void SetDeadTime() {
		Count=10;
	}
	/**
	 * 
	 * @return 返回复活时间
	 */
	public int GetCount() {
		return Count;
	}
	/**
	 * 复活时间倒数，每次减一秒
	 */
	public void DeadTime_decrement() {	
		Count--;
	}
}
