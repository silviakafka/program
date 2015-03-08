package dataStructure;

public class CreateGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int INFINITY=65535;
		
		Graph g=new Graph();
		g.vexesNum=10;
		g.edgeNum=11;
		
		for(int i=0;i<g.vexesNum;i++)
		{
			g.vexs[i]="v"+i;
		}
		
		for(int i=0;i<g.vexesNum;i++)
			for(int j=0;j<g.vexesNum;j++)
			{
				g.edge[i][j]=0;
			}
		
		for(int i=0;i<g.edgeNum;i++)
		{
			//可以由用户自定义边 
		}
		
		
		g.edge[0][1]=1;
		g.edge[0][2]=1;
		g.edge[0][3]=1;
		g.edge[0][4]=1;
		g.edge[0][5]=1;
		g.edge[0][6]=1;
		g.edge[2][3]=1;
		g.edge[4][5]=1;
		g.edge[2][7]=1;
		g.edge[7][8]=1;
		g.edge[8][9]=1;
		
		for(int i=0;i<g.vexesNum;i++)
			for(int j=0;j<g.vexesNum;j++)
			{
				if(g.edge[i][j]!=0)
					g.edge[j][i]=g.edge[i][j];
			}
		
		
		for(int i=0;i<g.vexesNum;i++)
		{
			System.out.print("第i行：  ");
			for(int j=0;j<g.vexesNum;j++)
			{
				System.out.print("  "+g.edge[i][j]);
			}
			System.out.println("");
		}
			
	}

}



class Graph
{
	final  int MAXVEX=30;
	
	int vexesNum;
	int edgeNum;
	String[] vexs=new String[MAXVEX];
	int[][] edge=new int[MAXVEX][MAXVEX];
	}
