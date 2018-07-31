package com.fj.webauto.test;

import com.fj.webauto.annotation.StepInfo;

/**
* author:张福军
* date:2018年7月5日
* time:上午9:34:35
* 
**/

public class Test2 {

	
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.haha();
	}
	
	@StepInfo(info="fujun")
	public   void haha() {
		System.out.println("woshihahah....");
	}
}
