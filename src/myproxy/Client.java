package myproxy;

public class Client {

	public static void main(String[] args) throws Exception {
		UserService t=new UserServiceImpl();
		InvocationHandler h=new TimeHandler(t);
		UserServiceImpl u=(UserServiceImpl) Proxy.newProxyInstance(UserServiceImpl.class,h);
		u.addUser();
	}
}
