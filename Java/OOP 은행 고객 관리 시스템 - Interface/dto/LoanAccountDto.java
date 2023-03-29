package dto;

/**
 * 대출계좌
 */
public class LoanAccountDto extends AccountDto {

	private String mortagage; // 담보항목

	public LoanAccountDto() {
	}

	public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, String mortage) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.mortagage = mortage;
	}

	public String getMortagage() {
		return mortagage;
	}

	public void setMortagage(String mortagage) {
		this.mortagage = mortagage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" | 담보항목 : " + mortagage);
		
		
		return sb.toString();
	}
}
