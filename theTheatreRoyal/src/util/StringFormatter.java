package util;

import java.text.DecimalFormat;

public class StringFormatter {
	DecimalFormat df;

	public StringFormatter() {
		df = new DecimalFormat("0.00");
		
	}
	
	public String formatPrice(Double price) {
		return "£" + df.format(price);
	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		
	}
}



