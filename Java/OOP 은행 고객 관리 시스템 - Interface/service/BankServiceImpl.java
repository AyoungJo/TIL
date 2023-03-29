package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dto.AccountDto;
import dto.InstallAccountDto;
import dto.LoanAccountDto;
import dto.SavingAccountDto;
import dto.UserDto;
import exception.BalanceLackException;
import exception.UserAccountNotFoundException;

public class BankServiceImpl implements BankService {

	ArrayList<UserDto> userList = new ArrayList<>();
	ArrayList<AccountDto> accountList = new ArrayList<>();

	public BankServiceImpl() {

		// 고객 정보 //
		userList.add(new UserDto(111, "조아영", "joa@gmail.com", "010-1111-1111", false));
		userList.add(new UserDto(222, "예삐", "yeahbbi@naver.com", "010-2222-2222", true));
		userList.add(new UserDto(333, "미니", "mini@naver.com", "010-3333-3333", false));
		userList.add(new UserDto(444, "미남이", "handsome@gmail.com", "010-4444-4444", true));

		// 계좌 정보 //
		// 저축계좌 - 이체 수수료 추가
		accountList.add(new SavingAccountDto(10, "00100101001001", 500, 111, 500));
		accountList.add(new SavingAccountDto(70, "00700707007007", 500, 333, 0));
		accountList.add(new SavingAccountDto(50, "00500505005005", 200, 222, 500));

		// 대출 계좌 - 담보 항목 추가
		accountList.add(new LoanAccountDto(20, "00200202002002", 1000, 111, "주택구입자금대출"));
		accountList.add(new LoanAccountDto(60, "00600606006006", 500, 333, "주택신축자금대출"));
		accountList.add(new LoanAccountDto(30, "00300303003003", 0, 444, "토지분양자금대출"));
		accountList.add(new LoanAccountDto(40, "00400404004004", 1000, 222, "청약담보대출"));

		// 정기예금계좌 - 기간, 금액 추가
		accountList.add(new InstallAccountDto(80, "0413246550021351", 1000, 111, 2, 5000));
		accountList.add(new InstallAccountDto(90, "0660078952112351", 1000, 222, 1, 3000));
		accountList.add(new InstallAccountDto(15, "0231123001531871", 1000, 444, 3, 6000));
	}

	@Override
	public ArrayList<AccountDto> getAccountList(int userSeq) {
		ArrayList<AccountDto> list = new ArrayList<>();
		for (AccountDto ac : accountList) {
			if (ac != null && ac.getUserSeq() == userSeq) {
				list.add(ac);
			}
		}
		return list;
	}

	@Override
	public UserDto getUserDetail(int userSeq) {
		for (UserDto udo : userList) {
			if (udo.getUserSeq() == userSeq) {
				return udo;
			}
		}
		return null;
	}

	@Override
	public ArrayList<AccountDto> getAccountList() {
		return accountList;
	}

	@Override
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> sortedAccountList = new ArrayList<>();

		for (AccountDto ad : accountList) {
			sortedAccountList.add(ad);
		}

		Collections.sort(sortedAccountList);
		return sortedAccountList;
	}

	@Override
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> sortedAccountList = new ArrayList<>();

		for (AccountDto ad : accountList) {
			sortedAccountList.add(ad);
		}

		// 익명
		Collections.sort(sortedAccountList, new Comparator<AccountDto>() {
			public int compare(AccountDto o1, AccountDto o2) {
				return o1.getAccountSeq() - o2.getAccountSeq();
			};
		});

		return sortedAccountList;
	}

	/////////////////////////////////////////
	// 추가
	// 사용자 또는 계좌가 없으면 예외 발생
	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
		/*
		 * for (int i = 0; i < accountList.size(); i++) { AccountDto ad =
		 * accountList.get(i); if (ad.getUserSeq() == userSeq && ad.getAccountSeq() ==
		 * accountSeq) { return ad; } }
		 */

		for (AccountDto ad : accountList) {
			if (ad.getUserSeq() == userSeq && ad.getAccountSeq() == accountSeq) {
				return ad;
			}
		}
		throw new UserAccountNotFoundException();
	}

	// 출금 금액이 모자르면 예외 발생
	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {
		//UserAccountNotFoundException 예외처리한 getUserAccount()를 호출했기 때문에 withdraw()에도 예외처리
		AccountDto ad = getUserAccount(userSeq, accountSeq);

		if (ad.getBalance() < amount) {	//인출 불가 -> 잔액 부족
			throw new BalanceLackException();	//예외 발생 시킴
		}
		//값 변경
		ad.setBalance(ad.getBalance() - amount);
		
		return ad.getBalance();
	}

}
