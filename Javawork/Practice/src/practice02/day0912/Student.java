package practice02.day0912;

import java.util.Date;

class Student {
	private String name;
	private int birthYear;
	private int score;

	Student(){
		name = "";
		birthYear = 2000;
		score = 50;

	}
	Student(String name){
		this.name = name;
		birthYear = 2000;
		score = 50;
	}
	Student(String name, int birthYear, int score){
		this.name = name;
		this.birthYear = birthYear;
		this.score = score;
	}
	public void studentInfo() {
		System.out.println("** 학생정보 **");
		System.out.println("이름 : " + name);
		
		int year = new Date().getYear()+1990;
		System.out.println("태어난 년도 : " +birthYear + ", 나이: " + (year-birthYear));
		System.out.println("점수: " + score + "점");
		System.out.println("-".repeat(30));
	}

}
