package edu.calpoly.stat312.StructuresDuel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.calpoly.stat312.StructuresDuel.TestCaseIO.CSV;

public class Main {

	public static void main(String[] args) {
		List<TestCase> type = new ArrayList<>();
		List<TestCase> operation = new ArrayList<>();
		List<TestCase> count = new ArrayList<>();

		// Base instance from which all count instances are derived
		int[] sizes = { 100, 10000, 1000000 };
		for (int i : sizes) {
			count.add(new TestCase(DataType.RANDOM, DataType.RANDOM, i));
		}

		Operation[] ops = { Operation.INSERT, Operation.RETRIEVE,
				Operation.DELETE };
		for (Operation o : ops) {
			operation.add(new TestCase(o));
		}

		Type[] types = { Type.HASHTABLE, Type.BINARY_SEARCH_TREE, Type.TRIE };
		for (Type t : types) {
			type.add(new TestCase(t));
		}

		// Generate a full-factorial regimen of test cases
		List<TestCase> cases = TestCase.cartesianProd(type, TestCase.Part.TYPE,
				operation, TestCase.Part.OPERATION);
		cases = TestCase.cartesianProd(cases, count, TestCase.Part.GENSETTINGS);

		// Generate a number of replicates of test cases
		//cases = TestCase.replicate(cases, 10);

		// Randomize the test order
		TestCase.shuffle(cases);

		// Run the tests
		TestCase.runList(cases);

		try {
			CSV writer = new CSV("sample");
			writer.writeAll(cases);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */
}
