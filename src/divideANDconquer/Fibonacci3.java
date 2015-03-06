package divideANDconquer;


//µü´ú   
public class Fibonacci3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=77;
		int result=findFibonacci(n);
		System.out.println(result);
	}

	private static int findFibonacci(int n) {
		// TODO Auto-generated method stub
		int lastlast=1;
		int last=2;
		int x=0;
		
		for(int i=3;i<=n;i++)
		{
			x=lastlast+last;
			lastlast=last;
			last=x;
			
		}
		
		return x;
				
	}

}
