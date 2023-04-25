package com.itskb.myapp.calculator;

public class InterestCalculatorService {
	
	InterestCalculator loanCalcator;
	InterestCalculator savingCalcator;
	
	/* public InterestCalculatorService() {} */

	//생성자주입
	public InterestCalculatorService(InterestCalculator loanCalcator) {
		this.loanCalcator=loanCalcator;
	}
	
	//setter주입
	public void setSavingCalcator(InterestCalculator savingCalcator) {
		this.savingCalcator = savingCalcator;
	}	
	
	public double calculateLoanInterest(int amount) {
		return loanCalcator.calculate(amount);
	}
	
	public double calculateSavingInterest(int amount) {
		return savingCalcator.calculate(amount);
	}
}
