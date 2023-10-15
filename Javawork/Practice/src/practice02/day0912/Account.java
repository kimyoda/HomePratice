package practice02.day0912;

public class Account {
	private String accountNo;//계좌번호
	private String accountName;//계좌 주인
	private int money;// 잔액
	
	//생성자
	public Account(String accountNo, String accountName, int money) {
		this.accountName = accountName;
		this.accountNo = accountNo;
		this.money = money;
	}
	
	//계좌번호가 맞을경우 true를 반환해주는 메서드
	public boolean isAccount(String accountNo) {
		if(accountNo.equals(this.accountNo)) {
			return true;
		} else {
			return false;
		}
	}
	//외부에서 입금 시 money에 추가되는 메서드(addMoney)
	public void addMoney(int money) {
		this.money += money;
	}
	//외부에서 출금 시 money에 빼는 메서드(subMoney) 
	public void subMoney(int money) {
		this.money -= money;
	}
	//출력해주는 메서드 계좌번호 예금주 잔액(accountWrite)
	public void accountWrite() {
		System.out.println(accountNo+ "\t" + accountName + "\t" + money);
	}
}
