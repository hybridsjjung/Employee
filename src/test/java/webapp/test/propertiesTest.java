package webapp.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// properties 파일 정보 불러오기

public class propertiesTest {

	public static void main(String[] args) throws IOException {
		
		test2();
	}
	
	static void test2() throws IOException {
		Properties dbprop = new Properties();
		
		InputStream inStream = propertiesTest.class.getResourceAsStream("/webapp/resource/db.properties"); // class path상의 위치(절대경로)
		
		dbprop.load(inStream);
		
		String className = dbprop.getProperty("oracle.className");
		String url = dbprop.getProperty("oracle.url");
		String user = dbprop.getProperty("oracle.user");
		String password = dbprop.getProperty("oracle.password");
		
		System.out.println("className = " + className);
		System.out.println("url = " + url);
		System.out.println("user = " + user);
		System.out.println("password = " + password);
		
	}
	
	static void test1() throws IOException {
		
		Properties dbprop = new Properties();
		
		FileInputStream inStream = new FileInputStream("db.properties"); // File system상의 위치

		dbprop.load(inStream);
		
		String className = dbprop.getProperty("oracle.className");
		String url = dbprop.getProperty("oracle.url");
		String user = dbprop.getProperty("oracle.user");
		String password = dbprop.getProperty("oracle.password");
		
		System.out.println("className = " + className);
		System.out.println("url = " + url);
		System.out.println("user = " + user);
		System.out.println("password = " + password);
	}

}
