package bit701_0923;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_Oraclejbc {
	static final String ORACLE_DRIVER ="oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public Ex1_Oraclejbc() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류: " +e.getMessage());
		}

	}
	
	public void shopAllDates() {
		Connection conn = null;
		//System.out.println("오라클연결 성공");
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop order by sang_no";
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
		stmt = conn.createStatement();
		rs=stmt.executeQuery(sql);
		System.out.println("상품번호\t상품명\t가격\t색상");
		System.out.println("=".repeat(40));
		int total = 0;
		while(rs.next()) {
			String no = rs.getString("sang_no");
			String name = rs.getString("sang_name");
			int price = rs.getInt("sang_price");
			String color = rs.getString("sang_color");
			
			total += price;
			System.out.println(no+"\t" + name + "\t" + price + "\t" + color);
		}
		System.out.println("\n총금액: " + total);
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패: " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_Oraclejbc ex = new Ex1_Oraclejbc();
		ex.shopAllDates();
	}

}
