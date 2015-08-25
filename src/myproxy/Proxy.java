package myproxy;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {

	public static Object newProxyInstance(Class intfc, InvocationHandler h) throws Exception
	{
		String rt="\r\n";
		String src="";
		//src+="package myproxy;"+rt+
		src=	  rt+
			  "public class "+intfc.getSimpleName()+"$Proxy{"+rt+
			  "     private myproxy.InvocationHandler h;"+rt+
			  "     public  "+intfc.getSimpleName()+"$Proxy(myproxy.InvocationHandler h){"+rt+
			  "           this.h=h;"+rt+
			  "     }"+rt;
		
		String methodString="";
		Method[] methods=intfc.getDeclaredMethods();
		for(Method m:methods)
		{
			methodString+="      "+rt+
				          "      public void "+m.getName()+"()"+rt+
				          "      { "+rt+
				          "          try{"+rt+
				          "          java.lang.reflect.Method md="+intfc.getName()+".class.getMethod(\""+m.getName()+"\"); "+rt+
				          "       	  h.invoke(this,md);"+rt+
				          "          }catch(Exception e){}"+
				          "       }"+rt;
		}
		src=src+methodString+"}";
		System.out.println(src);
		
		//将生成的代理类写入文件
		String fileName="d:\\myproxy\\"+intfc.getSimpleName()+"$Proxy.java";
		File f=new File(fileName);
		FileWriter fw=new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//在程序中进行编译
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr=compiler.getStandardFileManager(null, null, null);
		Iterable units=fileMgr.getJavaFileObjects(fileName);
		CompilationTask t=compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		
		//加载到内存
		URL[] urls=new URL[]{new URL("file:/d:/myproxy/")};
		URLClassLoader url=new URLClassLoader(urls);
		Class c=url.loadClass(intfc.getSimpleName()+"$Proxy");
		
		Constructor constructor=c.getConstructor(InvocationHandler.class);
		Object o=constructor.newInstance(h);
		return o;
	}
}
