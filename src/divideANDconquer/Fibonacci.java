package divideANDconquer;


//递归  复杂度  2的n次方
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=23;
		int result=findFibonacci(n);
		System.out.println(result);
	}

	private static int findFibonacci(int n) {
		// TODO Auto-generated method stub
		if(n==1||n==2)
			return n;
		
		return findFibonacci(n-2)+ findFibonacci(n-1);
	}

}
