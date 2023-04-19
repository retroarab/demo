package com.example.demo.benchmark.cpu.floatingpoint;

import com.example.demo.benchmark.IBenchmark;

public class CPUDigitsOfPi implements IBenchmark {
	private PiCalculator piCalculator;
	private int size;

	@Override
	public void initialize(int size) {
		this.piCalculator = new PiCalculator();
		this.size = size;
	}

	@Override
	public void run() {
		piCalculator.computePi(size);
	}

	@Override
	public void run(Object option) {
		throw new UnsupportedOperationException(
				"Method not implemented yet. Use run() instead.");
	}

	@Override
	public void warmUp() {		
		this.run();
	}

	@Override
	public void warmUp(Object option) {
		throw new UnsupportedOperationException(
				"Method not implemented yet.");
	}

}
