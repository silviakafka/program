package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String content="query=123,lllllll,query=233,query=323,aaaaaa,bbbbb";
		//String regex="query=.*?,";如果不加括号则group(1)获取不到
		String regex="(query=)(.*?),";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(content);
        /*if(!matcher.find()){  
            System.out.println("文件路径格式不正确！");  
            return;  
        }  
        System.out.println(matcher.group(0)); */
        
        
        /*int count=0;
        while (matcher.find()) {   
            count++;   
            System.out.println("Match number " + count);   
            System.out.println("start(): " + matcher.start());   
            System.out.println("end(): " + matcher.end());   
        } */
        
        while (matcher.find()) {   
            System.out.println(matcher.group(2));   
 
        }   
     
	}

}
