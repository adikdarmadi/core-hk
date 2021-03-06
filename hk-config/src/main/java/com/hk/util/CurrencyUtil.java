package com.hk.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * The Class Currency Util.
 * 
 * @author Adik
 */
public class CurrencyUtil {

	private CurrencyUtil() {
		super();
	}

	/**
	 * Display prince in INA *
	 * 
	 * @param price
	 * */
	public static String getPriceInINA(double price) {
		DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat
				.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryDecimalSeparator(',');
		formatRp.setGroupingSeparator('.');

		indonesiaCurrency.setDecimalFormatSymbols(formatRp);
		return indonesiaCurrency.format(price);
	}

	/**
	 * Display prince in US Dollar *
	 * 
	 * @param price
	 * */
	public static String getPriceInUSD(double price) {
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.US);
		return currencyFormat.format(price);
	}

	/**
	 * Display prince in British Pound *
	 * 
	 * @param price
	 * */
	public static String getPriceInGBP(double price) {
		NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
		return GBP.format(price);
	}

	/**
	 * Display prince in EURO using FRANCE*
	 * 
	 * @param price
	 * */
	public static String getPriceInEURO(double price) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		return currency.format(price);
	}

	/**
	 * Display prince in Japanese Yen *
	 * 
	 * @param price
	 * */
	public static String getPriceInJPY(double price) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		return currency.format(price);
	}

	/**
	 * Display prince in Won Korea *
	 * 
	 * @param price
	 * */
	public static String getPriceInKOREA(double price) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.KOREA);
		return currency.format(price);
	}

}
