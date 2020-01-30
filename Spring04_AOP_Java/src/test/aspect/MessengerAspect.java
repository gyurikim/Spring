package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 * 1. 리턴 타입은  상관없다.
	 * 2. 메소드 명이 send로 시작하는 메소드
	 * 3. 메소드에 전달되는 인자도 상관없다
	 * 
	 * 위의 3가지 조건을 모두 만족시키는 메소드에 아래 aop가 적용된다
	 */
	@Around("execution(* send*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		//aop가 적용된 메소드 수행 직전
		System.out.println("--수행이전--");
		
		//aop가 적용된 메소드에 전달된 인자를 Objsct[]로 얻어낼수 있다.
		Object[] args=joinPoint.getArgs();
		// 반복문 돌면서 찾고싶은 type을 찾는다
		for(Object tmp:args) {
			if(tmp instanceof String) {//만일 String type이면
				String msg=(String)tmp;
				System.out.println("aop에서 읽어낸 내용 : "+msg);
				if(msg.contains("바보")) {
					System.out.println("바보라고 하지마!!");
					return;// 메소드 종료
				}
			}
		}
		
		//aop가 적용된 메소드 수행하고 리턴되는 값 받아오기 (void이면 null이 리턴된다)
		Object obj=joinPoint.proceed();
		
		//aop가 적용된 메소드 리턴 직후
		System.out.println("--수행직후--");
	}
	
}





