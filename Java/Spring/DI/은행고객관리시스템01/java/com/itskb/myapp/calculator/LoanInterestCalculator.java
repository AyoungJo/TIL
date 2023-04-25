package com.itskb.myapp.calculator;

public class LoanInterestCalculator implements InterestCalculator{

	private static final double RATE = 0.0525;
	
	@Override
	public double calculate(int amount) {
		System.out.println("LoanInterestCalculator - calculate()");
		return amount * RATE;
	}

}
