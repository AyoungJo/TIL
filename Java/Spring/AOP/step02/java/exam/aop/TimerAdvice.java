package exam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 핵심 비즈니스 로직의 수행시간 측정하는 Advice
 * 결과 : 핵심 비즈니스 로직의 수행시간을 측정하여 성능 개선에 도움을 줄 수 있음
 * 공통의 기능 : around 방식(사전, 사후 처리)
 * 사전 : 현재 시간을 구한다.
 * 사후 : 현재 시간을 구해서 사전의 시간과 gap 출력(사후-사전)
*
 */
public class TimerAdvice {
	//대상 메소드를 호출하기 전과 후의 동작을 구현하는 메소드
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//사전처리
		//사전처리를 하는 타겟대상의 메소드 정보 가져오기
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[ LOG ] " + methodName + " 호출 전 사전처리중...");
		
		Object params [] = joinPoint.getArgs();
		for(Object o : params) {
			System.out.print(o + " , ");
		}
		System.out.println();
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제 핵심 기능 담당 메소드 call
		Object obj = joinPoint.proceed();	//다음 advice call or 실제 핵심 기능을 담당하는 메소드 call
		
		sw.stop();
		System.out.println("[ LOG ]" + methodName + " 리턴 값 obj = " + obj);
		System.out.println("[ LOG ]" + methodName + "의 총 실행 ms = " + sw.getTotalTimeMillis());
		System.out.println("[ LOG ]" + methodName + " 사후처리 완료");
		
		//사후처리
		return obj;
		
	}
}
