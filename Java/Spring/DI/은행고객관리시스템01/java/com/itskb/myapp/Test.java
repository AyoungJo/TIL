package com.itskb.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itskb.myapp.calculator.InterestCalculatorService;

//constructor + setter
public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("interest-calculator.xml");

		InterestCalculatorService interestCalculatorService =context.getBean("interestCalculatorService", InterestCalculatorService.class);
		int amount = 100_000_000;
		double loanInterest = interestCalculatorService.calculateLoanInterest(amount);
		System.out.printf("Amount : %10d loanInterest is %.2f", amount, loanInterest);
		
		System.out.println("\n-------------------------------- ");
		
		InterestCalculatorService interestCalculatorService2 = context.getBean("interestCalculatorService", InterestCalculatorService.class);
		double savingInterest = interestCalculatorService2.calculateSavingInterest(amount);
		System.out.printf("Amount : %10d savingInterest is %.2f", amount, savingInterest);
		
	}

}
