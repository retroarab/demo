package com.example.demo.benchmark.cpu.floatingpoint;

import java.math.BigDecimal;

public class PiCalculator {
	private static final BigDecimal FOUR = BigDecimal.valueOf(4);
	private static final BigDecimal ONE = BigDecimal.valueOf(1);
	private static final BigDecimal ZERO = BigDecimal.valueOf(0);
	private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

	/**
	 * Compute the value of pi to the specified number of digits after the
	 * decimal point. The value is computed using Machin's formula: pi/4 =
	 * 4*arctan(1/5) - arctan(1/239) and a power series expansion of arctan(x)
	 * to sufficient precision.
	 */

	public BigDecimal computePi(int digits) {
		int scale = digits + 5; // for scale = digits the value of pi is
								// incorrect , the correction is performed by
								// adding 5 at scale;
		BigDecimal arctan1_5 = arctan(5, scale);
		BigDecimal arctan1_239 = arctan(239, scale);
		BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239)
				.multiply(FOUR);
		return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Compute the value, in radians, of the arctangent of the inverse of the
	 * supplied integer to the specified number of digits after the decimal
	 * point. The value is computed using the power series expansion for the arc
	 * tangent: arctan(x) = x - (x^3)/3 + (x^5)/5 - (x^7)/7 + (x^9)/9 ...
	 */

	private BigDecimal arctan(int denominator, int scale) {
		BigDecimal result, number, term;
		BigDecimal denominatorX = BigDecimal.valueOf(denominator);
		BigDecimal denominatorX2 = BigDecimal
				.valueOf(denominator * denominator);
		number = ONE.divide(denominatorX, scale, roundingMode);
		result = number;
		int i = 1;
		do {
			number = number.divide(denominatorX2, scale, roundingMode);
			int denom = 2 * i + 1; // /3, /5 , /7 , /9
			term = number
					.divide(BigDecimal.valueOf(denom), scale, roundingMode);
			if (i % 2 != 0) { // finds the sign between terms
				result = result.subtract(term);
			} else {
				result = result.add(term);
			}
			i++;
		} while (term.compareTo(ZERO) != 0);
		return result;
	}

}
