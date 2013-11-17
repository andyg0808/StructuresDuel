package edu.calpoly.stat312.StructuresDuel.StructureTest.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import edu.calpoly.stat312.StructuresDuel.StructureTest.TestCase;

public class CSV implements TestCaseWriter {

	/**
	 * The writer for this object
	 */
	private ICsvBeanWriter csvWriter;
	private boolean started;

	private static CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] {
				new Optional(), // id
				new Optional(), // type
				new Optional(), // op
				new Optional(), // dataCount
				new Optional() // nanoTime
		};

		return processors;
	}

	public CSV(String filename) throws IOException {
		csvWriter = new CsvBeanWriter(new FileWriter(filename),
				CsvPreference.STANDARD_PREFERENCE);
	}

	/**
	 * Writes the header for the CSV file
	 * @throws IOException
	 */
	private void start() throws IOException {
		csvWriter.writeHeader(TestBean.getHeader());
		started = true;
	}

	@Override
	public void write(TestCase t) throws IOException {
		if (!started) {
			start();
		}

		TestBean b = new TestBean(t);

		csvWriter.write(b, TestBean.getHeader(), getProcessors());
	}

	@Override
	public void writeAll(List<? extends TestCase> l) throws IOException {
		if (!started) {
			start();
		}
		for (TestCase c : l) {
			TestBean b = new TestBean(c);
			csvWriter.write(b, TestBean.getHeader(), getProcessors());
		}
	}

	public void close() throws IOException {
		csvWriter.close();
	}
	
	
}
