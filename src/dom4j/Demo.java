package dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub

		SAXReader reader=new SAXReader();
		Document document=reader.read(new File("C:/Users/wangs47/Documents/test.xml"));
		
	}

}
