package edu.calpoly.stat312.StructuresDuel.TestCaseIO;

import edu.calpoly.stat312.StructuresDuel.TestCase;

public class TestBean {
	public TestBean(TestCase source) {
		id = source.getId();
		type = source.getType().name();
		op = source.getOp().name();
		dataCount = source.getDataCount();
		nanoTime = source.getTime();
	}

	private long id;
	private String type;
	private String op;
	private int dataCount;
	private long nanoTime;

	private static final String[] header = { "id", "type", "op", "dataCount",
			"nanoTime" };

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public long getNanoTime() {
		return nanoTime;
	}

	public void setNanoTime(long nanoTime) {
		this.nanoTime = nanoTime;
	}

	public static String[] getHeader() {
		return header;
	}
}