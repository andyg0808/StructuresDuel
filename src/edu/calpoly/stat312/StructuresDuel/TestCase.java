package edu.calpoly.stat312.StructuresDuel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestCase {
	private static long currentID = 0;
	private static RandomData rand = new RandomData();

	private long id;

	// Information to run the test
	private Type type;
	private Operation op;
	private DataType keyType;
	private DataType valueType;
	private int dataCount = -1;

	// The data the test will be run with
	private Map<String, String> data;

	// How long the test took
	private long time = -1;

	public TestCase() {
		id = currentID;
		currentID++;
	}

	public long runTest() {
		LinkedHashMap<String, String> block = rand.getDataBlock(keyType,
				valueType, dataCount);
		return Tester.runTest(type, block, op).elapsedTime();
	}

	public static List<Long> runTests(List<? extends TestCase> list) {
		
		return null;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		if (this.type != null) {
			throw new IllegalOperationError("Type already set.");
		}
		this.type = type;
	}

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		if (this.op != null) {
			throw new IllegalOperationError("Op already set.");
		}
		this.op = op;
	}

	public DataType getKeyType() {
		return keyType;
	}

	public void setKeyType(DataType keyType) {
		if (this.keyType != null) {
			throw new IllegalOperationError("keyType already set.");
		}
		this.keyType = keyType;
	}

	public DataType getValueType() {
		return valueType;
	}

	public void setValueType(DataType valueType) {
		if (this.valueType != null) {
			throw new IllegalOperationError("valueType already set.");
		}
		this.valueType = valueType;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		if (this.dataCount >= 0) {
			throw new IllegalOperationError("dataCount already set.");
		}
		this.dataCount = dataCount;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		if (this.data != null) {
			throw new IllegalOperationError("data already set.");
		}
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public long getTime() {
		return time;
	}

}
