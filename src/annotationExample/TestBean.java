package annotationExample;

public class TestBean {

	@HelloWorld
	public void method1()
	{
		System.out.println("this is method1");
	}
	
	public void method2()
	{
		System.out.println("this is method2");
	}
	
	@HelloWorld
	public void method3()
	{
		System.out.println("this is method3");
	}
}
