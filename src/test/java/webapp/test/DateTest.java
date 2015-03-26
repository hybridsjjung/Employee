package webapp.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import webapp.escape.Background;
import webapp.escape.Screen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest {

	static Log log = LogFactory.getLog(DateTest.class);
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		
		Date current = new Date();
		
		log.info(current);
		log.info(current.toLocaleString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		
		Calendar current = Calendar.getInstance();
		
		log.info(current.getTime());
		log.info(current.getTime().toLocaleString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test3() {
		
		Date current = new Date();
		
		current.setDate(current.getDate() + 100); // 내일로 setting
		log.info("year : " + (current.getYear() + 1900));
		log.info("month : " + (current.getMonth() + 1));
		log.info("date : " + current.getDate()); // 날짜
		log.info("week : " + current.getDay()); // 요일
	}
	
	@Test
	public void test4() {
		
		Date date = new Date(2015 - 1900, 3-1, 1); // 2015.03.01
		
		log.info("start week : " + date.getDay());
		log.info(date.toLocaleString());
		
		int month = date.getMonth();
		while(true) { // 3월을 마지막 날짜 구하기
			date.setDate(date.getDate()+1);
			
			if(month != date.getMonth())
				break;
		}
		date.setDate(date.getDate() - 1);
		log.info("end week : " + date.getDay());
		log.info("end date : " + date.getDate());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test5() {
		
		System.out.println("* January *");
		
		Date date = new Date(2015 - 1900, 1-1, 1);
		
		int month = date.getMonth();
		date.setDate(date.getDate());
		
		if(date.getDay() != 0 || date.getDay() != 1 || date.getDay() != 2 || 
				date.getDay() != 3 || date.getDay() != 4 || date.getDay() != 5) {
			for(int i = 0; i < date.getDay(); i++)
				System.out.print("X	");
		}
		
		while(true) {
			
			if(month != date.getMonth())
				break;
			System.out.print(date.getDate() + "	");
			date.setDate(date.getDate()+1);
			
			if(date.getDay() == 0)
				System.out.println();
		}
	}
	
	@Test
	public void test6() {
		Screen.clear();
		Screen.cursorPosition(5, 1);
		System.out.print("[yyyy/MM] : ");
		String param;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			param = scan.nextLine();
			
			if(param.equals("."))
				break;
			
			System.out.println("param = " + param);
		}
		
	}


}
