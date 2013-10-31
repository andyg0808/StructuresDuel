package edu.calpoly.stat312.StructuresDuel;

public class IllegalOperationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6423909430869569439L;

	/**
	 * 
	 */
	public IllegalOperationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalOperationError(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalOperationError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalOperationError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public IllegalOperationError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
