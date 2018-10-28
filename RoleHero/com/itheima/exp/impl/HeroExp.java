package com.itheima.exp.impl;

import com.itheima.exp.IExp;

/**
 * 
 * @author 李聪
 *@version 1.0
 *@since 2018.10.27
 *@see IExp
 */
public class HeroExp implements IExp {
	public int exp=0;
	public void HeroExp() {
		exp+=30;
	}
	public int GetExp() {
		return exp;
	}
}
