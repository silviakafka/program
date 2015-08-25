package myaspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class Audience {

	public static final String anyMethod="execution(* myaspect.Performer.*(..))";
	
	@Before(anyMethod)
	public void takeSeats()
	{
		System.out.println("the audience is taking their seats");
	}
}
