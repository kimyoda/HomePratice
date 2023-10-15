package bit701_0925;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex2_MysqlSawonInsert {
	DbConnect db = new DbConnect();
	
	public void sawonInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~100사이 점수");
		
		int score = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		
		Connection conn = null;
		Statement stmt = null;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_MysqlSawonInsert ex = new Ex2_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
