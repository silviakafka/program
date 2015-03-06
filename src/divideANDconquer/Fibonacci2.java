package divideANDconquer;

public class Fibonacci2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=77;
		int result=findFibonacci(n);
		System.out.println(result);
	}

	private static int findFibonacci(int n) {
		// TODO Auto-generated method stub
		//为下标统一浪费第0个  所以用第1个
		int[] num=new int[n+1];
		num[0]=0;
		num[1]=1;
		num[2]=2;
		for(int i=3;i<=n;i++)
		{
			num[i]=num[i-1]+num[i-2];
		}
		
		return num[n];
				
	}

}
