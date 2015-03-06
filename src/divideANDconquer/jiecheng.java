package divideANDconquer;

public class jiecheng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=12;
		System.out.println(recursiveJiecheng(n));
		
	}

	private static int recursiveJiecheng(int n) {
		// TODO Auto-generated method stub
		if(n==1)
		{
			return 1;
		}
		return n*recursiveJiecheng(n-1);
	}

}
