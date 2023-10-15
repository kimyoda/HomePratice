import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_Mysqljdbc {

	static final String MYSQL_DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";//
	private int count;

	public Ex2_Mysqljdbc () {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: " +e.getMessage());
		}
	}

	public void sawonAllDate() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon order by num";

		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("번호\t이름\t부서\t성별\t점수");
			System.out.println("=".repeat(40));
			int total = 0;
			int count = 0;
			double avg;
			while(rs.next()) {
				String no = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				total += score;
				count++;
				
				System.out.println(no+ "\t" + name + "\t" + score + "\t" + gender + "\t" + buseo);
			}
			System.out.println("\n총점: " + total);
			avg=(double)total/count;
			System.out.printf("평균: %3.1f\n", avg);
			
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패: " + e.getMessage());
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
		Ex2_Mysqljdbc ex = new Ex2_Mysqljdbc();
		ex.sawonAllDate();
	}

}
