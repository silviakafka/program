package annotationExample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parser {

	public void parse(Object obj,String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method m=obj.getClass().getMethod(methodName, null);
		if(m.isAnnotationPresent(HelloWorld.class))
		{
			HelloWorld hw=m.getAnnotation(HelloWorld.class);
			System.out.println("before the method,hey!");
			m.invoke(obj,null);
			System.out.println("after the method");
		}
	}
	
}
