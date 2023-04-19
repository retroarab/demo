package com.example.demo.benchmark.cpu.threading;

import com.example.demo.benchmark.IBenchmark;

public class CPUThreading implements IBenchmark {

	private int size;

	@Override
	public void initialize(int size) {
		this.size = size;
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException(
				"Method not implemented yet. Use run(Object) instead.");
	}

	@Override
	public void run(Object option) {
		if (option instanceof Integer) {
			int nThreads = (Integer) option;

			Thread[] threadsArr = new Thread[nThreads];
			for (int i = 0; i < nThreads; i++) {
				SQRTWorker worker = new SQRTWorker(i * size / nThreads, (i + 1)
						* size / nThreads);
				threadsArr[i] = new Thread(worker);
				threadsArr[i].start();
			}

			for (int i = 0; i < nThreads; i++) {
				try {
					threadsArr[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new UnsupportedOperationException(
					"Incorrect parameter type. Use an Integer object.");
		}
	}

	@Override
	public void warmUp() {
		throw new UnsupportedOperationException(
				"Method not implemented yet. Use warmUp(Object) instead.");
	}

	@Override
	public void warmUp(Object option) {
		for (int i = 0; i < 4; i++) {
			if (option instanceof Integer) {
				this.run((Integer) option);
			} else {
				throw new UnsupportedOperationException(
						"Incorrect parameter type. Use an Integer object.");
			}
		}
	}
}
