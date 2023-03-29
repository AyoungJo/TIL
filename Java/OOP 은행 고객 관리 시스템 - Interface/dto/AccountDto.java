package dto;

/**
 * 계좌 클래스
 */
public class AccountDto implements Comparable<AccountDto> {
	private int accountSeq; 		// 계좌 일련번호
	private String accountNumber; 	// 번호
	private int balance;			// 잔고
	private int userSeq; 			// 고객 일련번호

	public AccountDto() {
	}

	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userSeq = userSeq;
	}

	public int getAccountSeq() {
		return accountSeq;
	}

	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Override
	public int compareTo(AccountDto o) {
		// 자신.잔액 - 인수.잔액 -> 오름차순
		return this.balance - o.balance;
	}

	@Override
	public String toString() {
		return "계좌 일련번호 : " + accountSeq + " | 번호 : " + accountNumber + " | 잔고 : " + balance + " | 고객일련번호 : " + userSeq;
	}
}
