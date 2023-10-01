package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect //컴포넌트 스캔이 되는건 아니기 때문에 빈으로 등록해야 함
public class AspectV1 {

    //스프링 AOP 는 AspectJ 의 문법을 차용하여 프록시 방식 AOP 를 제공하는 것이지 AspectJ 를 직접 사용하는 것이 아님
    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature()); //join point 시그니쳐
        return joinPoint.proceed();
   }

    /**
     * AOP 용어 정리
     *
     * 조인 포인트(Join Point)
     * - 어드바이스가 적용될 수 있는 위치, 메소드 실행, 생성자 호출 등 프로그램 실행 중 지점을 말함
     * - 조인 포인트는 추상적인 개념으로 AOP 를 적용할 수 있는 모든 지점이라 생각하면 된다
     * - 스프링 AOP 는 프록시 방식을 사용하므로 조인 포인트는 항상 메소드 실행 지점으로 제한된다
     *
     * 포인트컷(Pointcut)
     * - 조인 포인트 중에서 어드바이스가 적용될 위치를 선별하는 기능
     * - 주로 AspectJ 표현식으로 지정
     * - 프록시를 사용하는 스프링 AOP 는 메서드 실행 지점만 포인트컷으로 선별 가능
     *
     * 타겟(Target)
     * - 어드바이스를 받는 객체, 포인트컷으로 결정
     *
     * 어드바이스(Advice)
     * - 부가 기능을 수행
     * - 특정 조인 포인트에서 Aspect 에 의해 취해지는 조치
     *
     * 애스펙트(Aspect)
     * - 어드바이스 + 포인트컷을 모듈화 한 것
     * - 여러 어드바이스와 포인트컷이 함께 존재
     *
     * 어드바이저(Advisor)
     * - 하나의 어드바이스와 하나의 포인트컷으로 구성
     * - 스프링 AOP 에서만 사용되는 특별한 용어
     * 
     * 위빙(Weaving)
     * - 포인트컷으로 결정한 타겟의 조인 포인트에 어드바이스를 적용하는 것
     * - 위빙을 통해 핵심 기능 코드에 영향을 주지 않고 부가 기능을 추가할 수 있음
     * - AOP 적용을 위해 애스펙트를 객체에 연결한 상태
     *
     * AOP 프록시
     * - AOP 기능을 구현하기 위해 만든 프록시 객체로 스프링에서 AOP 프록시는 JDK 동적 프록시 또는 CGLIB 프록시이다
     */

}
