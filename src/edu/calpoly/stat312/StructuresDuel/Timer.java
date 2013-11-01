package edu.calpoly.stat312.StructuresDuel;

public class Timer {

	private long startTime = 0;
	private long elapsed = 0;
	boolean running = false;
	private boolean run = false;

	/**
	 * Return the elapsed time in nanoseconds. The caveats for System.nanoTime apply.
	 * @return Elapsed time in nanoseconds.
	 */
	public long elapsedNanoTime() {
		if (!run) {
			throw new UnrunTimerException();
		}

		if (running) {
			// If the timer's running then return a to-the-instant time
			return elapsed + System.nanoTime() - startTime;
		} else {
			return elapsed;
		}
	}

	public void startTimer() {
		// Set the start time
		startTime = System.nanoTime();

		running = true;
		run = true;
	}

	public void stopTimer() {
		// Set the stop time
		elapsed += System.nanoTime() - startTime;
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean hasRun() {
		return run;
	}

}
