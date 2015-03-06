package divideANDconquer;

public class MyPow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m=5;
		int n=10000;
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		System.out.println(myPowMethod1(m,n));
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("1��������ʱ�䣺 "+(endTime-startTime)+"ms");
		
		
		startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		System.out.println(myPowMethod2(m,n));
		endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("2��������ʱ�䣺 "+(endTime-startTime)+"ms");
		
		startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		System.out.println(myPowMethod3(m,n));
		endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("3��������ʱ�䣺 "+(endTime-startTime)+"ms");

	}

	
	
	private static int myPowMethod1(int m, int n) {
		// TODO Auto-generated method stub
		int result=1;
		for(int i=0;i<n;i++)
		{
			result*=m;
		}
		return result;
	}
	
	private static int myPowMethod2(int m, int n) {
		// TODO Auto-generated method stub
		if(n==0)
			return 1;
		
		if(n%2==0)
		return myPowMethod2(m,n/2)*myPowMethod2(m,n/2);
		else
		return myPowMethod2(m,n/2)*myPowMethod2(m,n/2)*m;
	}
	
	
	private static int myPowMethod3(int m, int n) {
		// TODO Auto-generated method stub
		if(n==0)
			return 1;
		
		if(n%2==0)
		{
			int temp=myPowMethod2(m,n/2);
			return temp*temp;
		}
		else
		{
			int temp=myPowMethod2(m,n/2);
			return temp*temp*m;
		}
	}

}
