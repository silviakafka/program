

import java.util.ArrayList;
import java.util.Vector;

public class DFS {

	static int[] book=new int[10];
	static int[] result=new int[10];
	static int n=8;
	
	
	
	public static void main(String[] args)
	{
		Vector<Integer> v=new Vector<Integer>();
	}

	private static void dfs(int step) {
		// TODO Auto-generated method stub
		if(step<=n)
		{
			for(int i=1;i<=n;i++)
			{
				if(book[i]==0)
				{
					result[step]=i;
					book[i]=1;
					dfs(step+1);
					book[i]=0;
				}
			}
		}
		else
		{
			for(int i=1;i<=n;i++)
				System.out.print(result[i]+" ");
			
			System.out.println(" ");
		}
		
	}
}
