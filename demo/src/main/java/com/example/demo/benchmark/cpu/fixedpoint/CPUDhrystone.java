package com.example.demo.benchmark.cpu.fixedpoint;

import com.example.demo.benchmark.IBenchmark;

public class CPUDhrystone extends GlobalVariables implements IBenchmark {

	private int numberOfRuns;

	@Override
	public void initialize(int size) {
		this.numberOfRuns = size;
	}

	@Override
	public void run() {
		runDhrystone(this.numberOfRuns);
	}

	private void runDhrystone(int numberOfRuns) {
		int intLoc1, intLoc2, intLoc3;
		int[] intLocRef3 = new int[1];
		int[] intLocRef1 = new int[1];
		char charIndex;
		int[] enumLoc = new int[1];
		String stringLoc1, stringLoc2;

		nextRecordGlob = secondRecord;
		recordGlob = firstRecord;
		recordGlob.recordComp = nextRecordGlob;
		recordGlob.discr = ident1;
		recordGlob.enumComp = ident3;
		recordGlob.intComp = 40;
		recordGlob.stringComp = "DHRYSTONE PROGRAM, SOME STRING";
		stringLoc1 = "DHRYSTONE PROGRAM, 1'ST STRING";

		for (int runIndex = 1; runIndex <= numberOfRuns; ++runIndex) {
			proc5();
			proc4();

			intLoc1 = 2;
			intLoc2 = 3;

			stringLoc2 = "DHRYSTONE PROGRAM, 2'ND STRING";

			enumLoc[0] = ident2;
			boolGlob = !func2(stringLoc1, stringLoc2);

			while (intLoc1 < intLoc2) {
				intLocRef3[0] = 5 * intLoc1 - intLoc2;
				proc7(intLoc1, intLoc2, intLocRef3);
				intLoc1 += 1;
			}

			intLoc3 = intLocRef3[0];
			proc8(arrayGlob1, arrayGlob2, intLoc1, intLoc3);
			proc1(recordGlob);

			for (charIndex = 'A'; charIndex <= charGlob2; ++charIndex) {
				if (enumLoc[0] == func1(charIndex, 'C'))
					proc6(ident1, enumLoc);
			}

			intLoc3 = intLoc2 * intLoc1;
			intLoc2 = intLoc3 / intLoc1;
			intLoc2 = 7 * (intLoc3 - intLoc2) - intLoc1;

			intLocRef1[0] = intLoc1;
			proc2(intLocRef1);
			intLoc1 = intLocRef1[0];
		}
	}
	
	private void proc1(RecordType pointerParVal) {

		RecordType nextRecord = pointerParVal.recordComp;

		pointerParVal.recordComp = recordGlob;
		pointerParVal.intComp = 5;
		nextRecord.intComp = pointerParVal.intComp;
		nextRecord.recordComp = pointerParVal.recordComp;
		proc3(nextRecord.recordComp);

		int[] intRef = new int[1];

		if (nextRecord.discr == ident1) {
			nextRecord.intComp = 6;
			intRef[0] = nextRecord.enumComp;
			proc6(pointerParVal.enumComp, intRef);
			nextRecord.enumComp = intRef[0];
			nextRecord.recordComp = recordGlob.recordComp;
			intRef[0] = nextRecord.intComp;
			proc7(nextRecord.intComp, 10, intRef);
			nextRecord.intComp = intRef[0];
		} else
			pointerParVal = pointerParVal.recordComp;
	}

	private void proc2(int intParRef[]) {
		int intLoc;
		int enumLoc;

		intLoc = intParRef[0] + 10;
		enumLoc = 0;

		do {
			if (charGlob1 == 'A') {
				intLoc -= 1;
				intParRef[0] = intLoc - intGlob;
				enumLoc = ident1;
			}
		} while (enumLoc != ident1);
	}

	private void proc3(RecordType pointerParRef) {
		if (recordGlob != null)
			pointerParRef = recordGlob.recordComp;
		else
			intGlob = 100;

		int[] intCompRef = new int[1];
		intCompRef[0] = recordGlob.intComp;
		proc7(10, intGlob, intCompRef);
		recordGlob.intComp = intCompRef[0];
	}

	private void proc4() {
		boolean boolLoc;

		boolLoc = charGlob1 == 'A';
		boolLoc = boolLoc || boolGlob;
		charGlob2 = 'B';
	}

	private void proc5() {
		charGlob1 = 'A';
		boolGlob = false;
	}

	private void proc6(int enumParVal, int enumParRef[]) {
		enumParRef[0] = enumParVal;

		if (!func3(enumParVal))
			enumParRef[0] = ident4;

		switch (enumParVal) {
		case ident1:
			enumParRef[0] = ident1;
			break;
		case ident2:
			if (intGlob > 100)
				enumParRef[0] = ident1;
			else
				enumParRef[0] = ident4;
			break;
		case ident3:
			enumParRef[0] = ident2;
			break;
		case ident4:
			break;
		case ident5:
			enumParRef[0] = ident3;
			break;
		}
	}

	private void proc7(int intParVal1, int intParVal2, int intParRef[]) {
		int intLoc;

		intLoc = intParVal1 + 2;
		intParRef[0] = intParVal2 + intLoc;
	}

	private void proc8(int[] arrayParRef1, int[][] arrayParRef2,
			int intParVal1, int intParVal2) {
		int intIndex, intLoc;

		intLoc = intParVal1 + 5;
		arrayParRef1[intLoc] = intParVal2;
		arrayParRef1[intLoc + 1] = arrayParRef1[intLoc];
		arrayParRef1[intLoc + 30] = intLoc;
		for (intIndex = intLoc; intIndex <= intLoc + 1; ++intIndex)
			arrayParRef2[intLoc][intIndex] = intLoc;
		arrayParRef2[intLoc][intLoc - 1] += 1;
		arrayParRef2[intLoc + 20][intLoc] = arrayParRef1[intLoc];
		intGlob = 5;
	}

	private int func1(char charParVal1, char charParVal2) {
		char charLoc1, charLoc2;

		charLoc1 = charParVal1;
		charLoc2 = charLoc1;
		if (charLoc2 != charParVal2)
			return ident1;
		else
			return ident2;
	}

	private boolean func2(String stringPar1Ref, String stringPar2Ref) {
		int intLoc;
		char charLoc = '\0';

		intLoc = 2;
		while (intLoc <= 2)
			if (func1(stringPar1Ref.charAt(intLoc),
					stringPar2Ref.charAt(intLoc + 1)) == ident1) {
				charLoc = 'A';
				intLoc += 1;
			}
		
		if (charLoc >= 'W' && charLoc < 'Z')
			intLoc = 7;
		if (charLoc == 'X')
			return true;
		else {
			if (stringPar1Ref.compareTo(stringPar2Ref) > 0) {
				intLoc += 7;
				return true;
			} else
				return false;
		}
	}

	private boolean func3(int enumParVal) {
		int enumLoc;

		enumLoc = enumParVal;
		if (enumLoc == ident3)
			return true;
		else
			return false;
	}

	@Override
	public void run(Object option) {
		throw new UnsupportedOperationException("Method not implemented yet.");
	}

	@Override
	public void warmUp() {	
		this.run();
	}

	@Override
	public void warmUp(Object option) {
		throw new UnsupportedOperationException("Method not implemented yet.");
	}
}
