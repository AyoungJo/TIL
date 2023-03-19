package bank.view;
import bank.dto.*;
import bank.service.*;

public class TestView {

	public static void main(String[] args) {
		System.out.println("***1. 고객seq에 해당하는 계좌정보 검색하기 *****");
		BankService service = new BankService();

		AccountDto[] accountList = service.getAccountList(100);
		if (accountList == null) {
			System.out.println("회원의 계좌정보가 없습니다. ");
		} else {
			System.out.println("회원계좌개수 : " + accountList.length);
			for (AccountDto dto : accountList) {
				System.out.print(dto.accountSeq + " , " + dto.accountNumber + " , " + dto.userSeq + " , ");
				System.out.println(dto.balance);
			}
		}

		System.out.println("***2. userSeq에 해당하는 고객의 정보 *************");
		UserDto userDto = service.getUserDetail(300);
		if (userDto != null) {
			System.out.print(userDto.userSeq + " , " + userDto.name + " , " + userDto.email + " , ");
			System.out.println(userDto.phone + " , " + userDto.isSleep);
		} else {
			System.out.println("회원의 정보가 없습니다.");
		}

	}

}
