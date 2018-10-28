package com.itheima.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.itheima.domain.AnQiLa;
import com.itheima.domain.ChengYaoJin;
import com.itheima.domain.DaJi;
import com.itheima.domain.Hero;
import com.itheima.domain.HouYi;
import com.itheima.domain.LuBanQiHao;
import com.itheima.exp.impl.HeroExp;

class HeroTest {

	@Test
	void test() {
		Hero hero1=new AnQiLa();		hero1.setExp(new HeroExp());
		Hero hero2=new HouYi();			hero2.setExp(new HeroExp());
		Hero hero3=new ChengYaoJin();	hero3.setExp(new HeroExp());
		Hero hero4=new LuBanQiHao();	hero4.setExp(new HeroExp());
		Hero hero5=new DaJi();			hero5.setExp(new HeroExp());
		assertEquals(3323,hero1.HP);
	}

}
