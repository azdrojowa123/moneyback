package webservice.moneyback.aspects;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class AroundAopAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(webservice.moneyback.aspects.GetRequest)")
	public ArrayList<Object> aroundGetMethod (ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info(" Before execution of {}", joinPoint);
		ArrayList<Object> result = (ArrayList<Object>)joinPoint.proceed();
		logger.info("After execution of {}", joinPoint);
		return result;
	}
}
