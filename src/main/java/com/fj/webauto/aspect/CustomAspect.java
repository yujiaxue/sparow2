package com.fj.webauto.aspect;

//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.junit.Before;

/**
 * author:张福军 date:2018年7月4日 time:下午7:16:11
 * 
 **/

//@Aspect
public class CustomAspect {

	//@Pointcut("execution(@com.fj.webauto.annotation.StepInfo * *..*.*(..))")
	public void StepInfoMethod() {
	}

	//@Before("execution(* *.*(..)) && @annotation(com.fj.webauto.annotation.StepInfo)")
//	public Object aa(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("ok..........................");
//		return pjp.proceed();
//	}
//
//	// @Before("StepInfoMethod()")
//	public Object beforeStepMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//		String key = joinPoint.getSignature().toString();
//		// Log.e(TAG, "beforeDebugTraceMethod: " + key);
//		System.out.println("ok...");
//		Object proceed = joinPoint.proceed();
//
//		return proceed;
//	}
//
//	@Around("execution(* com.xys.aspectjxdemo.MainActivity.testAOP())")
//	public void onActivityMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		String key = proceedingJoinPoint.getSignature().toString();
//		proceedingJoinPoint.proceed();
//	}

}
