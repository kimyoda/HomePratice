package practice0919;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {

	JTable table1;
	
	JTable table2;
	
	public Table(String title) {
		super(title);
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임 종료해주는 메서드
		this.setDesign();
		this.setVisible(true);
		
	}
	
	private void setDesign() {
		
		//table 2개를 넣기 위해 2행 1열로 레이아웃 변경
		this.setLayout(new GridLayout(2, 1));
	
		DefaultTableModel model = new DefaultTableModel(new String[] {"이름", "나이", "주소"}, 3);
		table1 = new JTable(model);
		
		this.add(new JScrollPane(table1));
		
		//table2에는 데이타를 넣어보자
		String [][] data = {
				{"강부자", "56", "강남구"},
				{"이순재", "60", "여의도"},
				{"신구", "60", "제주도"}
		};
		
		table2 = new JTable(data, new String [] {"이름", "나이", "주소"});
		this.add(new JScrollPane(table2));
		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table ex = new Table("JTable");
	}

}
