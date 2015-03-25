package leetcode.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args)
	{
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s1="A";
		List<String> result=new Solution().findRepeatedDnaSequences(s1);
		System.out.println(result);
	}
	
    public  List<String> findRepeatedDnaSequences(String s) {
    	
    	if(s==null||s.length()<10)
    		return new ArrayList<String>();
    	Temp[] convertToInt=new Temp[s.length()-9];
    	for(int i=0;i<convertToInt.length;i++)
    	{
    		Temp t=new Temp();
    		convertToInt[i]=t;
    	}
    	
    	for(int i=0;i<=s.length()-10;i++)
    	{
    		int start=i;
    		int sum=0;
    		for(;start<10+i;start++)
    		{
    			sum=sum*4+charGetInt(s.charAt(start));
    		}
    		convertToInt[i].num=sum;
    		convertToInt[i].place=i;
    	}
    	//复杂度nlgn
    	//会破环位置关系
    	Arrays.sort(convertToInt);
    	
    	//使用set保证没有重复
    	Set<Integer> resultIntSet=new HashSet<Integer>();
    	//用于记录位置
    	List<Integer> placeList=new ArrayList<Integer>();
    	int size=resultIntSet.size();
    	//复杂度n
    	for(int i=1;i<convertToInt.length;i++)
    	{
    		if(convertToInt[i].num==convertToInt[i-1].num)
    		{
    			resultIntSet.add(convertToInt[i].num);
    			if(resultIntSet.size()>size)
    			{
    				placeList.add(convertToInt[i].place);
    			}
    			size=resultIntSet.size();
    		}
    			
    	}
    	
    	//用于记录位置
    	List<String> resultList=new ArrayList<String>();
    	for(int i=0;i<placeList.size();i++)
    	{
    		resultList.add(s.substring(placeList.get(i), placeList.get(i)+10));
    	}
    	return resultList;
    }

	private  int charGetInt(char x) {
		switch(x)
		{
			case 'A':return 0;
			case 'C':return 1;
			case 'G':return 2;
			case 'T':return 3;
		}
		return 0;
			
	}
	
	
	class Temp implements Comparable
	{
		int num;
		int place;
		

		public int compareTo(Object o) {
			if (o instanceof Temp){  
				Temp obj=(Temp)o;
				if(this.num>obj.num)
					return 1;
				else if(this.num==obj.num)
					return 0;
				else
				return -1;
			}
			return 1;
		}
	}
}
