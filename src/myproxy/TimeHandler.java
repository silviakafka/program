package myproxy;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{

	private Object target;	
	public TimeHandler(Object  target) {
		this.target=target;
	}

	public void invoke(Object o,Method m) {
		System.out.println("start time");
		try {
			m.invoke(target, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("end time");
		
	}
}
