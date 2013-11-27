package edu.calpoly.stat312.StructuresDuel.StructureTest.IO;

import java.io.IOException;
import java.util.List;

import edu.calpoly.stat312.StructuresDuel.StructureTest.TestCase;

public interface TestCaseWriter {
	/**
	 * Write the TestCase to the destination for this TestCaseWriter
	 * 
	 * @param t
	 *            The TestCase to write
	 * @throws IOException
	 */
	void write(TestCase t) throws IOException;

	/**
	 * Write all the TestCases in the list to the destination for this
	 * TestCaseWriter.
	 * 
	 * @param l
	 *            The List of TestCases to write
	 * @throws IOException
	 */
	void writeAll(List<? extends TestCase> l) throws IOException;
}
