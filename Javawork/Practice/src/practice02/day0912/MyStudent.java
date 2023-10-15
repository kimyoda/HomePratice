package practice02.day0912;

public class MyStudent {
	private String name;
	private int kor, eng;
	
	public MyStudent(String name, int kor, int eng) {
		this.name = name;
		this.eng = eng;
		this.kor = kor;
	}
	
	//getter method
	public int getKor() {
		return kor;
	}

	public String getName() {
		return name;
	}

	public int getEng() {
		return eng;
	}
	
	public int getTotal() {
		return kor + eng;
	}
	
	public double getAverage() {
		return getTotal() / 2.0;
	}
	public String getGrade() {
		double avg = this.getAverage();
		if(avg >= 90) {
			return "A그룹";
		} else if(avg>= 80) {
			return "B그룹";
		} else {
			return "탈락";
		}
	}
	
}
