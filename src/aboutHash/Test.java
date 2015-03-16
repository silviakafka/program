package aboutHash;

import java.util.HashMap;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("a".hashCode());
		System.out.println(new Integer(97).hashCode());
		System.out.println(new Integer(97).equals("a"));
		
		//任何类均为Object类的间接子类，所以均继承方法public int hashCode()
		//该方法返回的值一般是通过将该对象的内部地址转换成一个整数来实现的。
		Object a=new Object();
		System.out.println(a.hashCode());
		Object b=new Object();
		System.out.println(b.hashCode());
		
		HashMap c=new HashMap();
		c.put("key", "value");
		
		Integer x;
		
		
		//不同类型的对象有不同的散列算法。
		//Integer 这种对基础类型的封装类，散列值等同于数值本身
		
		//String hashCode参见源码  遍历字符串求和（不同位上加权） 
		//HashMap a;
		System.out.println(new Integer(732).hashCode());
		
		
		
		/*java.lang.Object a;
		java.lang.String a;*/
	}

}
