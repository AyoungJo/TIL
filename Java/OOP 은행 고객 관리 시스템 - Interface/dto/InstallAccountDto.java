package dto;

/**
 * 정기예금계좌
 */
public class InstallAccountDto extends AccountDto {
	private int period; // 기간
	private int amount; // 금액

	public InstallAccountDto() {
	}

	public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.period = period;
		this.amount = amount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" | 기간 : " + period);
		sb.append(" | 금액 : " + amount);
		return sb.toString();
	}

}
