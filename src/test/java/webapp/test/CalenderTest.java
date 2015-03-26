package webapp.test;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalenderTest {

	@SuppressWarnings("deprecation")
	public static void printCalender(int year, int month) {
		System.out.println("year : " + year + ", month : " + month);
		
		Date date = new Date(year - 1900, month-1, 1);
		
		int mon = date.getMonth();
		date.setDate(date.getDate());
		
		if(date.getDay() != 0 || date.getDay() != 1 || date.getDay() != 2 || 
				date.getDay() != 3 || date.getDay() != 4 || date.getDay() != 5) {
			for(int i = 0; i < date.getDay(); i++)
				System.out.print("♥	");
		}
		
		while(true) {
			if(mon != date.getMonth())
				break;
			System.out.print(date.getDate() + "	");
			date.setDate(date.getDate()+1);
			
			if(date.getDay() == 0)
				System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			boolean flag = true;
			String param = "";
			do {
				flag = true;
				System.out.print("yyyy/MM : ");
				param = scan.nextLine();
				System.out.println("param = " + param);
			
//				flag = param.matches("[1-9][0-9][0-9][0-9]/[0-1][0-9]"); // 정규표현식
				flag = param.matches("[1-9][0-9]{3}/[0-1][0-9]"); 
				
			} while(!flag);
			
			StringTokenizer tokens = new StringTokenizer(param, "/");
			
			printCalender(Integer.parseInt((String)tokens.nextElement()), 
						Integer.parseInt((String)tokens.nextElement()));
		}

	}

}
