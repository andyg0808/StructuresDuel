package edu.calpoly.stat312.StructuresDuel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.calpoly.stat312.StructuresDuel.TestCase.Part;
import edu.calpoly.stat312.StructuresDuel.TestCaseIO.CSV;

public class Main {

	public static void main(String[] args) {
		List<TestCase> type = new ArrayList<TestCase>();
		List<TestCase> operation = new ArrayList<TestCase>();
		// Omitting counts for pilot study
		// List<TestCase> count = new ArrayList<TestCase>();

		// Base instance from which all count instances are derived
		// Chose INSERT and DELETE, since RETRIEVE will generally be part of
		// them anyway
		Operation[] ops = { Operation.INSERT, Operation.DELETE };
		for (Operation o : ops) {
			operation.add(new TestCase(o));
		}

		// BST and TRIE as two factor levels
		Type[] types = { Type.BINARY_SEARCH_TREE, Type.TRIE };
		for (Type t : types) {
			type.add(new TestCase(t));
		}

		// Create a basic TestCase array to work from.
		List<TestCase> cases = TestCase.cartesianProd(type, TestCase.Part.TYPE, operation,
				TestCase.Part.OPERATION);
		
		// Copy the value of GENSETTINGS from the new TestCase across all the other TestCases
		cases = TestCase.mapPart(cases, new TestCase(DataType.RANDOM, DataType.RANDOM, 100000), Part.GENSETTINGS);

		// Generate a number of replicates of test cases.
		// 10 specified by professor
		cases = TestCase.replicate(cases, 10);

		// Randomize the test order
		TestCase.shuffle(cases);

		// Run the tests
		TestCase.runList(cases, System.out);

		System.out.print("Writing CSV output...");
		try {
			CSV writer = new CSV("pilot_data.csv");
			writer.writeAll(cases);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println(" done.");
	}
	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */
}
