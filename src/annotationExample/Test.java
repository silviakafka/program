package annotationExample;

import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		TestBean tn=new TestBean();
		Parser p=new Parser();
		p.parse(tn, "method1");
	}

}
