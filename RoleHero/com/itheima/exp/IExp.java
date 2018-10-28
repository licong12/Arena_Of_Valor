package com.itheima.exp;

/**
 * <em><b>召唤师经验接口</b></em>
 * <p>有击败英雄获取经验和获取经验信息两个方法组成
 * @author 李聪
 *@version 1.0
 *@since 2018.10.27
 *@see IExp
 */
public interface IExp {
	/**
	 * 击败敌方英雄获得经验
	 */
	public void HeroExp();
	/**
	 * 
	 * @return 返回英雄经验值
	 */
	public int  GetExp();
}
