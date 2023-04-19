package com.example.demo.benchmark;

public interface IBenchmark {
	
	/**
	 * Called to explicitly initialize benchmark data.
	 * This call should not be benchmarked.
	 */
	public void initialize(int size);
	
	/**
	 * Calls the actual benchmarking algorithm, optionally after initialize was called.
	 * This call should be benchmarked.	
	 */	
	public void run();
	public void run(Object option);
	
	/**
	 * Warm-up methods must be called before running the benchmarking algorithm.
	 */
	public void warmUp();
	public void warmUp(Object option);
}
