package forOffer;

public class FindInArray {

	public static void main(String[] args)
	{
		int[][] test=new int[][]{{2,4,6,8,9,14},
								 {3,5,9,11,18,20},
								 {5,9,14,22,25,29},
								 {7,10,15,24,28,32},
								 {8,11,17,25,29,35},
								 {8,11,17,25,29,35}};
		int x=29;
		int[] result=new int[2];
		result=findInArray(test,x);
		System.out.println("横坐标："+(result[0]+1)+"纵坐标："+(result[1]+1));//下标从1开始算  更直观一点
	}

	private static int[] findInArray(int[][] test, int x) {
		
		int placeX=0;
		int placeY=test.length-1;
		
		while(placeX<test.length&&placeY>=0)
		{
			if(x==test[placeX][placeY])
			return new int[]{placeX,placeY};
			else if(x>test[placeX][placeY])
				placeX++;
			else
				placeY--;
		}
		
		
		return  new int[]{-1,-1};
	}
}
