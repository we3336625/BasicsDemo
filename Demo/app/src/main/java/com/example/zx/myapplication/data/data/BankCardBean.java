package com.example.zx.myapplication.data.data;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class BankCardBean {

	private String bankName;
	private String cardNumber;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "BankCardBean{" +
				"bankName='" + bankName + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				'}';
	}
}
