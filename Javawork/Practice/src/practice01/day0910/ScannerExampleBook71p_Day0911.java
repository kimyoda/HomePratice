package practice01.day0910;

import java.util.Scanner;

public class ScannerExampleBook71p_Day0911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x 값 입력 : ");
		String strX = sc.nextLine();
		int x = Integer.parseInt(strX);
		
		System.out.println("y 값 입력: ");
		String strY = sc.nextLine();
		int y = Integer.parseInt(strY);
		
		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();
		
		while(true) {
			System.out.println("입력 문자열: ");
			String data = sc.nextLine();
			if(data.equals("q")) {
				break;
			}
			System.out.println("출력 문자열: " + data);
			System.out.println();
		}
		System.out.println("종료");
	}

}
