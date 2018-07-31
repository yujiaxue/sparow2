package com.fj.webauto.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author:张福军 date:2018年7月2日 time:下午7:06:08
 * 
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CaseInfo {
	String caseName() default "红星_uicase";

	String owner() default "张福军";

	
	
	
}
