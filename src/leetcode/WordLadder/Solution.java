package leetcode.WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		String start="hit";
		String end="cog";
		Set<String> dict=new HashSet<String>();
		String[] dictArray=new String[]{"hot","dot","dog","lot","log"};
		for(String word:dictArray)
		{
			dict.add(word);
		}
		System.out.println(new Solution().ladderLength(start,end,dict));
	}
	
	 public int ladderLength(String start, String end, Set<String> dict) {
	     
		 if(dict.size()==0) return 0;
		 if(start==""||start==null) return 0;
		 if(ifAdjacent(start, end))return 2;
		
		 Set<StringGraph> dictGraph=createDictGraph(dict);
		 
		//如果不记录状态 反复访问  时间复杂度会上升
		/* Set<StringGraph> dictGraph=new HashSet<StringGraph>();
		 for(String temp:dict)
		 {
			 StringGraph tempGraph=new StringGraph(temp,false);
			 dictGraph.add(tempGraph);
		 }*/
		 
		 int length=2;
		 Queue<StringGraph> myList=new LinkedList<StringGraph>();
		 StringGraph node=new StringGraph(start,false);
		 boolean ifSuccess=false;
		 while(length<=dictGraph.size())
		 {
			 length++;
			 //找到节点的所有未被访问的邻接节点
			 //每次去和所有Graph进行比较，时间复杂度会上升
			 Set<StringGraph> tempAdjacency=findAdjacencySet(node.val,dictGraph);	
			 //访问所有节点  并比较它们与end的关系，访问之后，将其置为已访问，并加入到list中
			 for(StringGraph middle:tempAdjacency)
			 {
				 if(ifAdjacent(middle.val,end))
				 {
					 ifSuccess=true;
					 break;
				 }
				 else
				 {
					 middle.ifVisited=true;
					 myList.add(middle);
				 }
			 }	 
			 if(ifSuccess)
				 break;
			 else
			 {
				 node=myList.poll();
			 }
				 
		 }
	     if(ifSuccess)   return length;
	     else return 0;
	  }


	private Set<StringGraph> createDictGraph(Set<String> dict) {
		// TODO Auto-generated method stub
		return null;
	}

	private Set<StringGraph> findAdjacencySet(String target, Set<StringGraph> dictGraph) {
		
		Set<StringGraph> adjacencySet=new HashSet<StringGraph>();
		for(StringGraph onedictGraph:dictGraph)
		{
			if(ifAdjacent(onedictGraph.val,target))
			{
				 if(onedictGraph.ifVisited==false)
				  adjacencySet.add(onedictGraph);
			}
		}
		return adjacencySet;
	}

	private boolean ifAdjacent(String dictWord, String target) {
		int difference=0;
		for(int i=0;i<dictWord.length();i++)
		{
			if(dictWord.charAt(i)!=target.charAt(i))
			{
				difference++;
			}
		}
		if(difference==1)return true;
		else return false;
	}
	
	class StringGraph
	{
		String val;
		boolean ifVisited;
		Set<StringGraph> adjacency;
		public StringGraph(String val, boolean ifVisited) {
			super();
			this.val = val;
			this.ifVisited = ifVisited;
		}
	}

}
