package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {
	public static void main(String[] args) {
		String regex = "(x)(y\\w*)(z)";
		String input = "exy123z,xy456z";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out.println(m.group(2));
		}
	}
}
