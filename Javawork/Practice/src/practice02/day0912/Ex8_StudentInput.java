package practice02.day0912;

import java.util.Scanner;

public class Ex8_StudentInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inwon;
		MyStudent []stu;
		
		System.out.println("정보를 입력할 인원수는?");
		inwon = Integer.parseInt(sc.nextLine());
		stu = new MyStudent[inwon];
		
		for(int i = 0; i<inwon; i++) {
			System.out.println(i + "번의 이름은?");
			String name = sc.nextLine();
			System.out.println(i + "번의 국어점수는?");
			int kor = Integer.parseInt(sc.nextLine());
			System.out.println(i + "번의 영어점수는?");
			int eng = Integer.parseInt(sc.nextLine());
			
			stu[i] = new MyStudent(name, kor, eng);
		}
		System.out.println("이름\t국어\t영어\t총점\t평균\t등급");
		System.out.println("=".repeat(50));
		for(MyStudent my:stu) {
			System.out.println(my.getName() + "\t" + my.getKor() + "\t" + my.getEng()
			+ "\t" + my.getTotal() + "\t" + my.getAverage() + "\t" + my.getGrade());
		}
	}

}
