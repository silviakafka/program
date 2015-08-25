package myaspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class Audience2 {

	public static final String anyMethod="execution(* myaspect.Performer.*(..))";
	
	@Before(anyMethod)
	public void takeSeats()
	{
		System.out.println("the audience2 is taking their seats");
	}
}
