package dto;

/**
 * 저축계좌
 */
public class SavingAccountDto extends AccountDto {

	private int transferFee;// 이체수수료

	public SavingAccountDto() {
	}

	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee = transferFee;
	}

	public int getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" | 이체 수수료 : ");
		sb.append(transferFee);
		return sb.toString();
	}

//	@Override
//	public String toString() {
//		return super.toString() + " | 이체 수수료 : " + transferFee;
//	}

}
