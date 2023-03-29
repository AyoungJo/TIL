import dto.AccountDto;
import exception.BalanceLackException;
import exception.UserAccountNotFoundException;
import service.BankService;
import service.BankServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception {
		BankService bankService = new BankServiceImpl();

		System.out.println("========================================전체 계좌 정보========================================");
		for (AccountDto accountDto : bankService.getAccountList()) {
			System.out.println(accountDto);
		}
		System.out.println();

//		
//		System.out.println(bankService.getAccountListSortByBalance());
		System.out.println(
				"========================================계좌 잔고 오름차순 정렬========================================");
		for (AccountDto accountDto : bankService.getAccountListSortByBalance()) {
			System.out.println(accountDto);
		}
		System.out.println();

		System.out.println(
				"========================================계좌 일련번호 오름차순 정렬========================================");

		for (AccountDto accountDto : bankService.getAccountListSortByUserSeq()) {
			System.out.println(accountDto);
		}
		System.out.println();

		/////////////////////////////////////////
		// 추가

		System.out.println("========================================특정 고객 정보========================================");
		try {
			System.out.println(bankService.getUserAccount(111, 15));
		} catch (UserAccountNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("========================================withdraw()========================================");
		try {
			int money = bankService.withdraw(111, 80, 1500);
			System.out.println("잔액은 " + money + "원 입니다.");
//			System.out.println("잔액은 " + bankService.withdraw(111, 80, 1500) + "원 입니다.");
		} catch (BalanceLackException e) {
			System.out.println(e.getMessage());
		}

	}

}
