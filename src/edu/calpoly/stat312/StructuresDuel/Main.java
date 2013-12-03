package edu.calpoly.stat312.StructuresDuel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.calpoly.stat312.StructuresDuel.StructureTest.DataType;
import edu.calpoly.stat312.StructuresDuel.StructureTest.Operation;
import edu.calpoly.stat312.StructuresDuel.StructureTest.TestCase;
import edu.calpoly.stat312.StructuresDuel.StructureTest.Type;
import edu.calpoly.stat312.StructuresDuel.StructureTest.IO.CSV;

public class Main {

	private static final SimpleDateFormat FILE_DATE = new SimpleDateFormat(
			"d-MMM-y:H:m:s:S");

	public static void main(String[] args) {
		String name;

		// Select a name for the output file
		if (args.length > 0) {
			name = args[0];
		} else {
			// Create a new name based on the current time
			name = "output-" + FILE_DATE.format(new Date());
		}

		List<TestCase> type = new ArrayList<TestCase>();
		List<TestCase> operation = new ArrayList<TestCase>();
		List<TestCase> count = new ArrayList<TestCase>();

		// Base instance from which all count instances are derived
		int[] sizes = { 100000, 500000, 1000000 };
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
		cases = TestCase.replicate(cases, 250);

		// Randomize the test order
		TestCase.shuffle(cases);

		// Run the tests
		TestCase.runList(cases, System.out);

		System.out.println("Writing CSV output...");
		try {
			CSV writer = new CSV(name);
			writer.writeAll(cases);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("Data saved to " + name);
		System.out.println("Done.");
	}
	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */
}
