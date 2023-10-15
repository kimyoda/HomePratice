package practice0919;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableFile extends JFrame {

	JTable table;
	DefaultTableModel model;
	JTextField tfName, tfAge, tfAddr;
	JButton btnAdd;
	
	final static String FILENAME="C:\\NaverTest\\member.txt";
	
	public TableFile(String title) {
		super(title);
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(400, 300);//프레임의 너비, 높이
		//디자인이나 이벤트를 구한다
		this.setDesign();
		this.setVisible(true);
		
		//윈도우 이벤트 발생 - 익명내부클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			FileWriter fw = null;
			try {
				fw = new FileWriter(FILENAME, true);
				//행갯수
				int row = table.getRowCount();
				for(int i = 0; i<row; i++) {
					String name = (String) model.getValueAt(i, 0);
					String age = (String) model.getValueAt(i, 1);
					String addr = (String) model.getValueAt(i, 2);
					
					fw.write(name + "," + age + " , " + addr + "\n");//
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			System.exit(0);
			super.windowClosing(e);
		}
		});
			
	}
	
	private void setDesign() {
		JPanel p = new JPanel();
		tfName = new JTextField(4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
